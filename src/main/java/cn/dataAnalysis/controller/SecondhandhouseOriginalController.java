package cn.dataAnalysis.controller;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;

@Controller
public class SecondhandhouseOriginalController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	private SecondhandhouseOriginalService secondhandhouseOriginalService;
	
	@Autowired
	private SecondhandhouseNewService secondhandhouseNewService;
	
	@RequestMapping("/getSecondhandhouseOriginalById")
	public void getSecondhandhouseOriginalById(Integer id){
		id = 3212;
		SecondhandhouseOriginal so = secondhandhouseOriginalService.getById(id);
//		将综合信息预处理然后进行存储
		
		Double area= Double.valueOf(so.getArea().substring(0, so.getArea().length()-3));
		Double area1 = Double.parseDouble(so.getAveragePrice().substring(0, so.getAveragePrice().length()-3));
		
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
//		楼层区域
		String a = null;
//		朝向
		String b = null;
//		建造年份
		Integer c = null;
		if(ciNewCon.length == 1){
			return;
		} else if (ciNewCon.length == 2){
			a = ciNewCon[1];
		} else if (ciNewCon.length == 3){
			a = ciNewCon[1];
			if(ciNewCon[2].contains("朝")){
				b = ciNewCon[2];
			} else if(ciNewCon[2].contains("年")){
				c = Integer.parseInt(ciNewCon[2].substring(0, 4));
			}
		}else if (ciNewCon.length == 4){
			a = ciNewCon[1];
			b = ciNewCon[2];
			c = Integer.parseInt(ciNewCon[3].substring(0, 4));
		}
		
		
		
		
		System.out.println("--------------------------这是分割线————————————————————————————————————————");
	}
	
	/**
	 * 批量插入处理后的房产信息
	 */
	@RequestMapping("/insertSecondhandhouseNew")
	public void insertSecondhandhouseNew(HttpServletRequest request){
		request.getParameter("");
		int id = 3212;
		SecondhandhouseOriginal so = secondhandhouseOriginalService.getById(id);
		SecondhandhouseNew sn = dealWithSecondhandhouseOriginal(so);
		secondhandhouseNewService.insert(sn);
		System.out.println("--------------------------这是分割线————————————————————————————————————————");
	}
	
	/**
	 * 用于处理新老房产信息
	 * @param SecondhandhouseOriginal
	 * @return
	 */
	public SecondhandhouseNew dealWithSecondhandhouseOriginal(SecondhandhouseOriginal so){
		
		SecondhandhouseNew sn = new SecondhandhouseNew();
		sn.setTitle(so.getTitle() == null ? null : so.getTitle());
		sn.setCommunityName(so.getCommunityName() == null ? null : so.getCommunityName());
		sn.setRoomType(so.getRoomType() == null ? null : so.getRoomType());
		sn.setArea(so.getArea() == null ? 
				0.00 : Double.valueOf(so.getArea().substring(0, so.getArea().length()-3)));
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
		sn.setTotalPrice(Double.parseDouble(so.getTotalPrice()));
		sn.setAveragePrice(Double.parseDouble(so.getAveragePrice().substring(0, so.getAveragePrice().length()-3)));
		sn.setAttentionNumber(Integer.parseInt(so.getAttentionNumber()));
		sn.setCaptureTime(so.getCaptureTime());
		sn.setOriginalId(so.getId());
		return sn;
	}
}


