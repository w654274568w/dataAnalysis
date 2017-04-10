package cn.dataAnalysis.controller;

import cn.dataAnalysis.enums.RegionShanghaiEnum;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.DataCountByRegionService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
@Controller
public class AnalysisController {

    @Autowired
    private SecondhandhouseOriginalService secondhandhouseOriginalService;

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    @Autowired
    private DataCountByRegionService dataCountByRegionService;




    /**
     * 批量分批插入处理后的房产信息(多线程)
     *
     */
    @RequestMapping("/insertSecondhandhouseNewMultithread")
    public void insertSecondhandhouseNew(HttpServletRequest request) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse("2017-02-16");
        Date endDate = df.parse("2017-02-17");
        Long beginTime = System.currentTimeMillis();
        List<SecondhandhouseOriginal> soList = secondhandhouseOriginalService.findByCaptureTime(beginDate, endDate);
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理"+soList.size()+"条数据，使用时间为"+(beginTime-endTime));
    }


    @RequestMapping("/analysisShanghaiDataByRegion")
    @Transactional
    public ModelAndView analysisShanghaiDataByRegion(ModelAndView view) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse("2017-03-31");
        Date endDate = df.parse("2017-04-03");
        Long beginTime = System.currentTimeMillis();
        Long countList = 0l;
        //遍历生成所有区域的空对象
        List<SecondhandhouseNew> secondhandhouseNewList = new ArrayList<SecondhandhouseNew>();
        for(RegionShanghaiEnum regionShanghaiEnum: RegionShanghaiEnum.values()){
            DataCountByRegion dataCountByRegion = new DataCountByRegion();
            dataCountByRegion.setRegionCode(regionShanghaiEnum.getCode());
            dataCountByRegion.setRegionName(regionShanghaiEnum.getDesc());
            //查询单一区域数据信息
            secondhandhouseNewList = secondhandhouseNewService.findByRegionNameAndDate(beginDate,endDate,regionShanghaiEnum.getDesc());
            Double totalPriceAmount = 0.0;
            Double averagePriceAmount = 0.0;
            Long attentionNumAmount = 0l;
            Long number = 0l;
            if(secondhandhouseNewList.size() > 0){
                for(SecondhandhouseNew secondhandhouseNew: secondhandhouseNewList){
                    totalPriceAmount = MathUtil.add(totalPriceAmount, secondhandhouseNew.getTotalPrice());
                    averagePriceAmount = MathUtil.add(averagePriceAmount,secondhandhouseNew.getAveragePrice());
                    attentionNumAmount = attentionNumAmount + secondhandhouseNew.getAttentionNumber();
                    countList += 1;
                    number += 1;
                }
                dataCountByRegion.setAverageTotalPrice(totalPriceAmount / secondhandhouseNewList.size());
                dataCountByRegion.setAveragePerPrice(averagePriceAmount / secondhandhouseNewList.size());
                dataCountByRegion.setAttentionNumber(attentionNumAmount / secondhandhouseNewList.size());
                dataCountByRegion.setNumber(number);
                dataCountByRegion.setCaptureTime(DateUtils.addDay(beginDate, 1));
                dataCountByRegionService.save(dataCountByRegion);
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理"+countList+"条数据，使用时间为"+(beginTime-endTime));
        view.setViewName("index");
        return view;
    }




}
