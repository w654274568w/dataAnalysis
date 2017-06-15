package cn.dataAnalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by feng on 2017/6/16.
 */

@Controller
public class IndexController {

    /**
     * 首页数据加载
     * @param view
     * @return
     */
    @RequestMapping("/index.json")
    public void index(ModelAndView view){
        //已采集数据量表单！！
    }
}
