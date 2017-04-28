package cn.dataAnalysis.controller;

import cn.dataAnalysis.enums.RegionShanghaiEnum;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import cn.dataAnalysis.service.DataCountByRegionService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import cn.dataAnalysis.service.ShanghaiMetroStationDetailsService;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
import cn.dataAnalysis.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by admin on 2017/4/6.
 */
@Controller
public class AnalysisController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SecondhandhouseOriginalService secondhandhouseOriginalService;

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    @Autowired
    private DataCountByRegionService dataCountByRegionService;

    @Autowired
    private ShanghaiMetroStationDetailsService shanghaiMetroStationDetailsService;


    /**
     * 批量分批插入处理后的房产信息(多线程)
     */
    @RequestMapping("/insertSecondhandhouseNewMultithread")
    public ModelAndView insertSecondhandhouseNew(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse(beginDateStr);
        Date endDate = df.parse(endDateStr);
        Long beginTime = System.currentTimeMillis();
        List<SecondhandhouseOriginal> soList = secondhandhouseOriginalService.findByCaptureTime(beginDate, endDate);

        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理" + soList.size() + "条数据，使用时间为" + (beginTime - endTime));
        view.setViewName("index");
        return view;
    }


    /**
     * 根据区域处理数据信息
     *
     * @param view
     * @return
     * @throws ParseException
     */
    @RequestMapping("/analysisShanghaiDataByRegion")
    @Transactional
    public ModelAndView analysisShanghaiDataByRegion(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse(beginDateStr);
        Date endDate = df.parse(endDateStr);
        Long beginTime = System.currentTimeMillis();
        Long countList = 0l;
        //遍历生成所有区域的空对象
        List<SecondhandhouseNew> secondhandhouseNewList = new ArrayList<SecondhandhouseNew>();
        for (RegionShanghaiEnum regionShanghaiEnum : RegionShanghaiEnum.values()) {
            DataCountByRegion dataCountByRegion = new DataCountByRegion();
            dataCountByRegion.setRegionCode(regionShanghaiEnum.getCode());
            dataCountByRegion.setRegionName(regionShanghaiEnum.getDesc());
            //查询单一区域数据信息
            secondhandhouseNewList = secondhandhouseNewService.findByRegionNameAndDate(beginDate, endDate, regionShanghaiEnum.getDesc());
            Double totalPriceAmount = 0.0;
            Double averagePriceAmount = 0.0;
            Long attentionNumAmount = 0l;
            Long number = 0l;
            if (secondhandhouseNewList.size() > 0) {
                for (SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList) {
                    totalPriceAmount = MathUtil.add(totalPriceAmount, secondhandhouseNew.getTotalPrice());
                    averagePriceAmount = MathUtil.add(averagePriceAmount, secondhandhouseNew.getAveragePrice());
//                    attentionNumAmount = attentionNumAmount + secondhandhouseNew.getAttentionNumber();
                    countList += 1;
                    number += 1;
                }
                dataCountByRegion.setAverageTotalPrice(totalPriceAmount / secondhandhouseNewList.size());
                dataCountByRegion.setAveragePerPrice(averagePriceAmount / secondhandhouseNewList.size());
//                dataCountByRegion.setAttentionNumber(attentionNumAmount / secondhandhouseNewList.size());
                dataCountByRegion.setNumber(number);
                dataCountByRegion.setCaptureTime(DateUtils.addDay(beginDate, 1));
                dataCountByRegionService.save(dataCountByRegion);
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理" + countList + "条数据，使用时间为" + (beginTime - endTime));
        view.setViewName("index");
        return view;
    }

    @RequestMapping("/dealStation.do")
    @Transactional
    public ModelAndView dealStation(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse(beginDateStr);
        Date endDate = df.parse(endDateStr);
        Long beginTime = System.currentTimeMillis();
        List<SecondhandhouseNew> secondhandhouseNewList = secondhandhouseNewService.getByDate(beginDate, endDate);
        //地铁站点集合
        //List<ShanghaiMetroStationDetails> shanghaiMetroStationDetailses = new ArrayList<ShanghaiMetroStationDetails>();
        //获取所有数据的 交通信息坐标
        List<String> trafficLocationList = new ArrayList<String>();
        String trafficLocation = null;
        Map<String, String> stationMapInsert = new HashMap<String, String>();
        //遍历生成站点信息
        List<String> stationNames = new ArrayList<>();
        List<String> transferSubwayCodes = new ArrayList<>();
//        int i = 0 ;//初始code
        Boolean flage = false;
        for (SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList) {
            //获取每条数据的交通信息
            //判断信息的有无
//            if (null != secondhandhouseNew.getTrafficLocation()) {
//                trafficLocation = secondhandhouseNew.getTrafficLocation();
//                //遍历地铁站点集合，并且去重
//                trafficLocationList = this.splitTrafficLocation(trafficLocation);
//                stationNames.add(trafficLocationList.get(0));
//            }
        }
        //插入地铁站点表
        int insertCountList = 0;
        for (int i = 0; i < stationNames.size(); i++) {
            for (int j = stationNames.size() - 1; j > i; j--) {
                if (stationNames.get(i).equals(stationNames.get(j))) {
                    stationNames.remove(j);
                }
            }
        }
        for (int j = 0; j < stationNames.size(); j++) {
            ShanghaiMetroStationDetails shanghaiMetroStationDetails = new ShanghaiMetroStationDetails();
            shanghaiMetroStationDetails.setStationName(stationNames.get(j));
            shanghaiMetroStationDetailsService.save(shanghaiMetroStationDetails);
            insertCountList++;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理" + insertCountList + "条数据，使用时间为" + (beginTime - endTime));
        view.setViewName("index");
        return view;
    }

    /**
     * 拆解交通信息
     *
     * @param trafficLocation
     * @return
     */
    public List<String> splitTrafficLocation(String trafficLocation) {
        List<String> stationInfo = new ArrayList<>();
        //距离8号线成山路站531米
        String stationName = trafficLocation.substring(
                trafficLocation.indexOf("线") + 1, trafficLocation.indexOf("站") + 1
        );
        String stationCode = trafficLocation.substring(
                trafficLocation.indexOf("离"), trafficLocation.indexOf("号")
        );
        stationInfo.add(stationName);
        stationInfo.add(stationCode);
        return stationInfo;
    }

    /**
     * 批量更新数据中的地铁站点信息
     */
    @RequestMapping("/updatetTrafficLocationForNewData.do")
    public ModelAndView updatetTrafficLocationForNewData(ModelAndView view, String beginDateStr, String endDateStr) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse(beginDateStr);
        Date endDate = df.parse(endDateStr);
        List<SecondhandhouseNew> secondhandhouseNews =
                secondhandhouseNewService.getByDate(beginDate, endDate);
        String trafficLocation = null;
        String stationName = null;
        int stationDistance = 0;
        String stationDistanceStr = null;
        int n = 0;
        for (SecondhandhouseNew secondhandhouseNew : secondhandhouseNews) {
            //距离8号线成山路站531米
//            trafficLocation = secondhandhouseNew.getTrafficLocation();
            if (trafficLocation != null && !"".equals(trafficLocation)) {
                stationName = trafficLocation.substring(
                        trafficLocation.indexOf("线") + 1, trafficLocation.lastIndexOf("站") + 1
                );
                stationDistanceStr = trafficLocation.substring(
                        trafficLocation.lastIndexOf("站") + 1, trafficLocation.indexOf("米")
                );
                stationDistance = Integer.valueOf(stationDistanceStr);
                secondhandhouseNew.setStationName(stationName);
                secondhandhouseNew.setStationDistance(stationDistance);
                secondhandhouseNewService.insert(secondhandhouseNew);
                logger.info("！！！！！！！！现在处理第" + n++ + "条信息！！！！！！！！！！！！！！！！！！！");
            }
        }
        view.setViewName("index");
        return view;
    }


}
