package cn.dataAnalysis.webController;


import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
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

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class SecondhandhouseOriginalController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	private SecondhandhouseOriginalService secondhandhouseOriginalService;
	
	@Autowired
	private SecondhandhouseNewService secondhandhouseNewService;

	@Autowired
	private DataCountByDateService dataCountByDateService;

	/**
	 * 获取数据库中已处理的数据量
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView view) throws ParseException {
		/*
		 * 获取总的数据处理数量
		 */
		//int totalCount = secondhandhouseNewService.countAllData();
		//获取本周的周一及周日
		/*Calendar c = Calendar.getInstance();
        // 默认时，每周第一天为星期日，需要更改一下
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        Date beginDate = c.getTime();
        c.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
        Date endDate = c.getTime();*/
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        /*
		 *获取历史总数据
		 */
		Date beginDate = fmt.parse("2017-01-01");
		Date endDate = new Date();
		/*List<SecondhandhouseNew> snListHistory = secondhandhouseNewService.getByDate(beginDate, endDate);
		int a = secondhandhouseNewService.countAllData();
        Map<String, String> historyMap = new HashMap<String, String>();
        historyMap =calculateDataNewByDate(snListHistory);
        String historyAveragePrice = historyMap.get("averagePrice");
        String historyAverageTotalPrice = historyMap.get("averageTotalPrice");*/
        
        /*
		 * 本周数据
		 */
		/*List<SecondhandhouseNew> snListThisWeek = secondhandhouseNewService.getByDate();
		Map<String, String> thisWeekMap = new HashMap<String, String>();
		thisWeekMap = calculateDataNewByDate(snListThisWeek);
		String thisWeekAveragePrice = thisWeekMap.get("averagePrice");
		String thisWeekAverageTotalPrice = thisWeekMap.get("averageTotalPrice");*/
		
		DecimalFormat df = new DecimalFormat("0.00");
		//历史对比增长率
		/*double averagePriceRateMath = ((Double.valueOf(thisWeekAveragePrice) /
				Double.valueOf(historyAveragePrice)) - 1) * 100 ;
		String averagePriceRate = df.format(averagePriceRateMath);
		double totalPriceRateMath = ((Double.valueOf(thisWeekAverageTotalPrice) /
				Double.valueOf(historyAverageTotalPrice)) - 1) * 100;
		String totalPriceRate = df.format(totalPriceRateMath);
		本周单价均价（元）（每平方 本周）
		view.addObject("thisWeekAveragePrice",thisWeekAveragePrice);
		view.addObject("averagePriceRate",averagePriceRate);
		本周总价均价（万元）
		view.addObject("thisWeekAverageTotalPrice",thisWeekAverageTotalPrice);
		view.addObject(totalPriceRate,totalPriceRate);
		历史数据量
		view.addObject("historyCount",snListHistory.size());
		本周数据
		view.addObject("thisWeekCount",snListThisWeek.size());*/
		view.setViewName("index");
		return view;
	}

	/**
	 * 批量分批插入处理后的房产信息（时间插入）
	 * @throws ParseException
	 */
	@RequestMapping("/insertSecondhandhouseNew.do")
	@Transactional
	public ModelAndView insertSecondhandhouseNew(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = df.parse(beginDateStr);
		Date endDate = df.parse(endDateStr);
		Long beginTime = System.currentTimeMillis();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("beginDate",beginDate);
		map.put("endDate",endDate);
		List<SecondhandhouseOriginal> soList = secondhandhouseOriginalService.findByCaptureTime(map);
		SecondhandhouseNew sn = null;
		//批量插入新的数据
		List<SecondhandhouseNew> snList = new ArrayList<SecondhandhouseNew>();
		Double averageTotalPrice = 0.0;
		Double averagePerPrice = 0.0;
		for(SecondhandhouseOriginal so : soList){
			sn = ConvertUtils.dealWithSecondhandhouseOriginal(so);
			snList.add(sn);
			averageTotalPrice = MathUtil.add(sn.getTotalPrice(),averageTotalPrice);
			averagePerPrice = MathUtil.add(sn.getAveragePrice(),averagePerPrice);
			secondhandhouseNewService.insert(sn);
		}
		//将本期数据处理后更新表  data_count_by_date
		//时间
		DataCountByDate dataCountByDate = new DataCountByDate();
		Date captureTime = DateUtils.addDay(beginDate, 1);
		dataCountByDate.setCaptureTime(captureTime);
		dataCountByDate.setNumber(Long.valueOf(snList.size()));
		dataCountByDate.setAverageTotalPrice(averageTotalPrice / snList.size());
		dataCountByDate.setAveragePerPrice(averagePerPrice / snList.size());
		dataCountByDateService.save(dataCountByDate);
		Long endTime = System.currentTimeMillis();
		System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
		System.out.println("共处理"+soList.size()+"条数据，使用时间为"+(beginTime-endTime));
		view.setViewName("index");
		return view;
	}
	/* 
	 * 通过时间查询数据并计算
	 */
	public Map<String, String> calculateDataNewByDate(List<SecondhandhouseNew> snList){
		Map<String ,String> map =new HashMap<String , String>();
		String averagePrice = "";
		long averagePriceTotal = 0L;
		double totalPriceTotal = 0.0;
		String averageTotalPrice = "";
		int size = snList.size();
		for(SecondhandhouseNew sn : snList){
			averagePriceTotal += sn.getAveragePrice();
			totalPriceTotal += sn.getTotalPrice();
		}
//		数据格式化
		DecimalFormat df = new DecimalFormat("0.0");
		averagePrice = df.format(averagePriceTotal / size) ;
		averageTotalPrice = df.format(totalPriceTotal / size);
//		单价均价
		map.put("averagePrice", averagePrice);
//		总价均价
		map.put("averageTotalPrice", averageTotalPrice);
		return map;
	}
}


