package cn.dataAnalysis.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World12313";
    }
	
	@RequestMapping("/index.html")
    public String getIndex(HttpServletRequest request){
		String a = "a";
		String b = "b";
		String c = a + b;
		return "/index";
	}
}
