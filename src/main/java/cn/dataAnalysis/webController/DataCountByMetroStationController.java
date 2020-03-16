package cn.dataAnalysis.webController;


import cn.dataAnalysis.model.DataCountByMetroStation;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import cn.dataAnalysis.service.DataCountByMetroStationService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.ShanghaiMetroStationDetailsService;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DataCountByMetroStationController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private SecondhandhouseNewService secondhandhouseNewService;

	@Autowired
	private DataCountByMetroStationService dataCountByMetroStationService;

	@Autowired
	private ShanghaiMetroStationDetailsService shanghaiMetroStationDetailsService;


	@RequestMapping("/dataCountByMetroStation.do")
	@Transactional
	public ModelAndView dataCountByArea(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = df.parse(beginDateStr);
		Date endDate = df.parse(endDateStr);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("beginDate",beginDate);
		params.put("endDate",endDate);
		List<SecondhandhouseNew> secondhandhouseNewList = secondhandhouseNewService.getByParams(params);
		//获取所有地铁站店名
		List<ShanghaiMetroStationDetails> shanghaiMetroStationDetailsList =
				shanghaiMetroStationDetailsService.findAll();
		List<DataCountByMetroStation> dataCountByMetroStations = new ArrayList<DataCountByMetroStation>();
		for (ShanghaiMetroStationDetails shanghaiMetroStationDetails: shanghaiMetroStationDetailsList){
			DataCountByMetroStation dataCountByMetroStation = new DataCountByMetroStation();
			dataCountByMetroStation.setStationName(shanghaiMetroStationDetails.getStationName());
			dataCountByMetroStation.setNumber(0l);
			dataCountByMetroStation.setAverageTotalPrice(0.00);
			dataCountByMetroStation.setAveragePerPrice(0.00);
			dataCountByMetroStations.add(dataCountByMetroStation);
		}
		//计算总额
		for(SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList){
			if(null != secondhandhouseNew.getStationName() && !"".equals(secondhandhouseNew.getStationName())){
				for(DataCountByMetroStation dataCountByMetroStation: dataCountByMetroStations ){
					if(secondhandhouseNew.getStationName().equals(dataCountByMetroStation.getStationName())){
						dataCountByMetroStation.setNumber(
								dataCountByMetroStation.getNumber() + 1);
						dataCountByMetroStation.setAveragePerPrice(MathUtil.add(
								dataCountByMetroStation.getAveragePerPrice(),secondhandhouseNew.getAveragePrice()));
						dataCountByMetroStation.setAverageTotalPrice(MathUtil.add(
								dataCountByMetroStation.getAverageTotalPrice(),secondhandhouseNew.getTotalPrice()));
					}
				}
			}
		}
		//计算平均值
		for (DataCountByMetroStation dataCountByMetroStation: dataCountByMetroStations){
			if(dataCountByMetroStation.getNumber() != 0l){
				dataCountByMetroStation.setAverageTotalPrice(
						dataCountByMetroStation.getAverageTotalPrice() / dataCountByMetroStation.getNumber());
				dataCountByMetroStation.setAveragePerPrice(
						dataCountByMetroStation.getAveragePerPrice() / dataCountByMetroStation.getNumber());
			}
			dataCountByMetroStation.setCaptureTime(DateUtils.addDay(beginDate, 1));
			dataCountByMetroStationService.save(dataCountByMetroStation);
		}
		view.setViewName("index");
		return view;
	}

	@RequestMapping("/getMetroStationCoordinate.do")
	public void getMetroStationCoordinate(){
		
	}
}


