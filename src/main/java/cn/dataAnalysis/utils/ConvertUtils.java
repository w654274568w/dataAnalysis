package cn.dataAnalysis.utils;

import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;

/**
 * Created by admin on 2017/4/6.
 */
public class ConvertUtils {

    /**
     * 用于处理新老房产信息
     * @param so
     * @return
     */
    public static SecondhandhouseNew dealWithSecondhandhouseOriginal(SecondhandhouseOriginal so){

        SecondhandhouseNew sn = new SecondhandhouseNew();
        sn.setTitle(so.getTitle() == null ? null : so.getTitle());
        sn.setCommunityName(so.getCommunityName() == null ? null : so.getCommunityName());
        sn.setRoomType(so.getRoomType() == null ? null : so.getRoomType());
        sn.setArea(so.getArea() == null ?
                null : Double.valueOf(so.getArea().substring(0, so.getArea().length()-3)));
        sn.setRegionName(so.getRegionName() == null ? null : so.getRegionName());
        sn.setComprehensiveInformation(so.getComprehensiveInformation() == null ?
                null : so.getComprehensiveInformation());
        if(so.getComprehensiveInformation() != null){
            String ci = so.getComprehensiveInformation();
            String ciNew = ci.replaceAll("\r|\n|\t| ", "");
			/*
			 * 综合信息可能存在的情形：
			 * 杨浦|低区/6层
			 * 杨浦|低区/6层|朝南
			 * 杨浦|低区/6层|1993年建
			 * 杨浦|低区/6层|朝南|1993年建
			 */
            String [] ciNewCon = ciNew.split("\\|");
            if(ciNewCon.length == 2){
                sn.setHighLowArea(ciNewCon[1]);
            } else if (ciNewCon.length == 3){
                sn.setHighLowArea(ciNewCon[1]);
                if(ciNewCon[2].contains("朝")){
                    sn.setOrientation(ciNewCon[2]);
                } else if(ciNewCon[2].contains("年")){
                    sn.setConstructionYear(Integer.parseInt(ciNewCon[2].substring(0, 4)));
                }
            }else if (ciNewCon.length == 4){
                sn.setHighLowArea(ciNewCon[1]);
                sn.setOrientation(ciNewCon[2]);
                sn.setConstructionYear(Integer.parseInt(ciNewCon[3].substring(0, 4)));
            }
        }
        if(so.getTrafficLocation() != null && so.getTrafficLocation().contains("距离")){
            sn.setTrafficLocation(so.getTrafficLocation());
        }
        sn.setTotalPrice(so.getTotalPrice() == null ? null :Double.parseDouble(so.getTotalPrice()));
        sn.setAveragePrice(so.getAveragePrice() == null ? null : Double.parseDouble(so.getAveragePrice().substring(0, so.getAveragePrice().length()-3)));
        sn.setAttentionNumber(so.getAttentionNumber() == null ? 0 : Integer.parseInt(so.getAttentionNumber()));
        sn.setCaptureTime(so.getCaptureTime());
        sn.setOriginalId(so.getId());
        return sn;
    }
}
