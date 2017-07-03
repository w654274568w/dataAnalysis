package cn.dataAnalysis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by feng on 2017/6/15.
 */

@Controller
public class MenuController {
    @RequestMapping("/sidebar.html")
    public String sidbar(HttpServletRequest request){
        return "/menus/sidebar";
    }
}
