package cn.dataAnalysis.controller;

import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by feng on 2017/6/16.
 */

@Controller
public class IndexController {

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    /**
     * 首页数据加载
     * @param request
     * @return
     */
    @RequestMapping("/index.html")
    public String index(HttpServletRequest request){
        //已采集（有效）数据量表单！！
        int totalDataNum = secondhandhouseNewService.countAllData();
        request.setAttribute("totalDataNum",totalDataNum);
        return "index";
    }
}
