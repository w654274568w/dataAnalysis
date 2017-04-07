package cn.dataAnalysis.controller;

import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
        //设置线程数
//        int threadNum = 2;
//        for(int i=0; i < threadNum;i++){
//            List<SecondhandhouseOriginal> soListPerThread = new ArrayList<SecondhandhouseOriginal>();
//            for(int k=0; k < soList.size(); k++){
//                soListPerThread.add(soList.get(k));
//                //设置每个线程处理的数据量
//                if(k != 0 && k % 999 == 0){//若对象达到 500 个对象，则开启一个新线程，处理任务
//                    //开启线程
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            SecondhandhouseNew sn = new SecondhandhouseNew();
//                            for(SecondhandhouseOriginal so: soListPerThread){
//                                sn = ConvertUtils.dealWithSecondhandhouseOriginal(so);
//                                secondhandhouseNewService.insert(sn);
//                            }
//                        }
//                    }).start();
////                    soListPerThread = new ArrayList<SecondhandhouseOriginal>();
//                }
//            }
//        }
        Long endTime = System.currentTimeMillis();
        System.out.println("————————————————————————————————————————这是分割线————————————————————————————————————————");
        System.out.println("共处理"+soList.size()+"条数据，使用时间为"+(beginTime-endTime));
    }


    @RequestMapping("/analysisShanghaiDataByRegion")
    public ModelAndView analysisShanghaiDataByRegion(ModelAndView view){


        view.setViewName("index");
        return view;
    }




}
