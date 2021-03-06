package cn.dataAnalysis.utils;

import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;

/**
 * Created by admin on 2017/4/6.
 */
public class ConvertUtils {

    /**
     * 用于处理新老房产信息
     *
     * @param so
     * @return
     */
    public static SecondhandhouseNew dealWithSecondhandhouseOriginal(SecondhandhouseOriginal so) {
        SecondhandhouseNew sn = new SecondhandhouseNew();
        sn.setTitle(so.getTitle() == null ? null : so.getTitle());
        sn.setCommunityName(so.getCommunityName() == null ? null : so.getCommunityName());
        //处理综合信息1
        if (so.getComprehensiveInformation1() != null) {
            String ci = so.getComprehensiveInformation1();
            String ciNew = ci.replaceAll("\r|\n|\t| ", "");
            /*
             * 综合信息1可能存在的情形：
			 * 5室2厅|157.62平|高区/6层|朝南北
			 * 1室1厅|33.32平|低区/6层
			 */
            String[] ciNewCon = ciNew.split("\\|");
            if (ciNewCon.length == 3) {
                sn.setRoomType(ciNewCon[0]);
                sn.setArea(Double.valueOf(ciNewCon[1].substring(0, ciNewCon[1].length() - 1)));
                sn.setHighLowArea(ciNewCon[2]);
            } else if (ciNewCon.length == 4) {
                sn.setRoomType(ciNewCon[0]);
                sn.setArea(Double.valueOf(ciNewCon[1].substring(0, ciNewCon[1].length() - 1)));
                sn.setHighLowArea(ciNewCon[2]);
                sn.setOrientation(ciNewCon[3]);
            }
        }
        //处理综合信息2
        if (so.getComprehensiveInformation2() != null) {
            String ci = so.getComprehensiveInformation2();
            String ciNew = ci.replaceAll("\r|\n|\t| ", "");
            /*
			 * 综合信息1可能存在的情形：
			 * 解放新村|奉贤 |南桥
			 * 绿地香颂（奉贤）（公寓） |奉贤 |海湾| 2012年建
			 */
            String[] ciNewCon = ciNew.split("\\|");
            if (ciNewCon.length == 3) {
                sn.setCommunityName(ciNewCon[0]);
                sn.setRegionName(ciNewCon[1]);
                sn.setRegionNameSecondary(ciNewCon[2]);
            } else if (ciNewCon.length == 4) {
                sn.setCommunityName(ciNewCon[0]);
                sn.setRegionName(ciNewCon[1]);
                sn.setRegionNameSecondary(ciNewCon[2]);
                sn.setConstructionYear(Integer.parseInt(ciNewCon[3].substring(0, 4)));
            }
        }
        String trafficLocation = so.getTrafficLocation();
        //http://sh.lianjia.com/ershoufang/sh4572051.html
        if (so.getDataLink() != null && !"".equals(so.getDataLink())) {
            String dataLinkStr = so.getDataLink().trim();
            Long dataId = Long.valueOf(dataLinkStr.substring(
                    dataLinkStr.lastIndexOf("sh")+2,dataLinkStr.length()-5));
            sn.setDataId(dataId);
        }
        //处理交通信息
        //距离8号线成山路站531米
        if (so.getTrafficLocation() != null && so.getTrafficLocation().contains("距离") &&
                !"".equals(so.getTrafficLocation())) {
            String stationName = trafficLocation.substring(
                    trafficLocation.indexOf("线") + 1, trafficLocation.lastIndexOf("站") + 1
            );
            String stationDistanceStr = trafficLocation.substring(
                    trafficLocation.lastIndexOf("站") + 1, trafficLocation.indexOf("米")
            );
            sn.setStationName(stationName);
            sn.setStationDistance(Integer.valueOf(stationDistanceStr));
        }
        sn.setTotalPrice(so.getTotalPrice() == null ? null : Double.parseDouble(so.getTotalPrice()));
        sn.setAveragePrice(so.getAveragePrice() == null ? null : Double.parseDouble(so.getAveragePrice().substring(2, so.getAveragePrice().length() - 3)));
        //sn.setAttentionNumber(so.getAttentionNumber() == null ? 0 : Integer.parseInt(so.getAttentionNumber()));
        sn.setCaptureTime(so.getCaptureTime());
        sn.setOriginalId(so.getId());
        return sn;
    }

    public static  void main(String[] args){
        /*String dataLinkStr = "http://sh.lianjia.com/ershoufang/sh4393259095.html";
        String a = dataLinkStr.substring(
                dataLinkStr.lastIndexOf("sh")+2,dataLinkStr.length()-5);
        Long dataId = Long.valueOf(a.trim());
        System.out.print(dataId);*/
        String a = "5室2厅|157.62平|高区/6层|朝南北";
        if (a != null) {
            String ciNew = a.replaceAll("\r|\n|\t| ", "");
            /*
             * 综合信息1可能存在的情形：
			 * 5室2厅|157.62平|高区/6层|朝南北
			 * 1室1厅|33.32平|低区/6层
			 */
            String[] ciNewCon = ciNew.split("\\|");
            String a1= ciNewCon[1].substring(0, ciNewCon[1].length() - 1);
            String a2= ciNewCon[1].substring(0, ciNewCon[1].length() - 3);
            System.out.print(a1+" "+a2);
        }
    }

}
