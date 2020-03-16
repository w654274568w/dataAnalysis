package cn.dataAnalysis.webController;

import cn.dataAnalysis.service.SecondhandhouseNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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
        Map<String,Object> params = new HashMap<String,Object>();
        //已采集（有效）数据量表单！！
//        int totalDataNum = secondhandhouseNewService.countAllData(params);
//        request.setAttribute("totalDataNum",totalDataNum);
        return "index";
    }
}
