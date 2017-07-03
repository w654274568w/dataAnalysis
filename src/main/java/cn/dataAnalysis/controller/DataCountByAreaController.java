package cn.dataAnalysis.controller;


import cn.dataAnalysis.model.DataCountByArea;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.DataCountByAreaService;
import cn.dataAnalysis.service.DataCountByDateService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import cn.dataAnalysis.utils.ConvertUtils;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class DataCountByAreaController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private SecondhandhouseNewService secondhandhouseNewService;

	@Autowired
	private DataCountByAreaService dataCountByAreaService;


	@RequestMapping("/dataCountByArea.do")
	public ModelAndView dataCountByArea(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = df.parse(beginDateStr);
		Date endDate = df.parse(endDateStr);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("beginDate",beginDate);
		params.put("endDate",endDate);
		List<SecondhandhouseNew> secondhandhouseNewList = secondhandhouseNewService.findByRegionNameAndDate(params);
		//遍历生成面积范围参数
//		int area = 30;
		//数据中间储存量
		//总价
		List<Double> totalPrice = new ArrayList<Double>();
		//每平米均价
		List<Double> averagePrice = new ArrayList<Double>();
		//数据量
		List<Integer> number = new ArrayList<Integer>();
		for(int n = 0; n<=150;n++){
			totalPrice.add(0.00);
			averagePrice.add(0.00);
			number.add(0);
		}
		Double area = 0.00;
		int sp = 0;
		//获取数据对应的每平米平均值
		for(SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList){
			area = secondhandhouseNew.getArea();
			sp = (int) (area - 30);
			//面积小于30的
			if(sp < 0){
				totalPrice.set(0,MathUtil.add(secondhandhouseNew.getTotalPrice(),totalPrice.get(0)));
				averagePrice.set(0,MathUtil.add(secondhandhouseNew.getAveragePrice(),averagePrice.get(0)));
				number.set(0,number.get(0) + 1);
			//面积大于30 小于 160
			} else if (sp >= 0 && sp < 150){
				totalPrice.set(sp,MathUtil.add(secondhandhouseNew.getTotalPrice(),totalPrice.get(sp)));
				averagePrice.set(sp,MathUtil.add(secondhandhouseNew.getAveragePrice(),averagePrice.get(sp)));
				number.set(sp,number.get(sp) + 1);
			//面积大于160
			} else {
				totalPrice.set(150,MathUtil.add(secondhandhouseNew.getTotalPrice(),totalPrice.get(150)));
				averagePrice.set(150,MathUtil.add(secondhandhouseNew.getAveragePrice(),averagePrice.get(150)));
				number.set(150,number.get(150) + 1);
			}
		}
		//遍历参数
		List<DataCountByArea> dataCountByAreaList = new ArrayList<DataCountByArea>();
		int k = 0;
		for(int i = 30; i <= 180; i++){
			DataCountByArea dataCountByArea = new DataCountByArea();
			dataCountByArea.setArea(Double.valueOf(i));
			dataCountByArea.setCaptureTime(DateUtils.addDay(beginDate, 1));
			if(number.get(k) != 0){
				dataCountByArea.setAverageTotalPrice(totalPrice.get(k) / number.get(k));
			}
			if(number.get(k) != 0){
				dataCountByArea.setAveragePerPrice(averagePrice.get(k) / number.get(k));
			}
			if(number.get(k) != 0){
				dataCountByArea.setNumber((long)number.get(k));
			}
			dataCountByAreaService.save(dataCountByArea);
			k++;
		}
		view.setViewName("index");
		return view;
	}
}


