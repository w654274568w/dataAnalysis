package cn.dataAnalysis.controller;

import cn.dataAnalysis.common.Constants;
import cn.dataAnalysis.common.page.JqGridPage;
import cn.dataAnalysis.common.page.PageUtils;
import cn.dataAnalysis.model.ResponseDataBaidu;
import cn.dataAnalysis.model.ShCommunityInfo;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.service.ShCommunityInfoService;
import cn.dataAnalysis.utils.ListUtils;
import cn.dataAnalysis.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
@Controller
@RequestMapping("/community")
public class ShCommunityController {

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    @Autowired
    private ShCommunityInfoService shCommunityInfoService;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/community.html")
    public String communityList(HttpServletRequest request){
        request.setAttribute("ak",Constants.AK);
        return "/community/community";
    }

    @RequestMapping("/communityList.json")
    @ResponseBody
    public JqGridPage communityListJson(HttpServletRequest request){
        //分页码
        int page = Integer.parseInt(request.getParameter("page")) - 1;
        int rows = Integer.parseInt(request.getParameter("rows"));
        String name = request.getParameter("name");
        //分页参数
        Map<String, Object> map = new HashMap<>();
        map.put("begin", page * rows);
        map.put("rows", rows);
        if(!StringUtil.isEmpty(name)){
            map.put("name",name);
        }
        List<ShCommunityInfo> shCommunityInfos = shCommunityInfoService.getByParams(map);
        int countAll = shCommunityInfoService.getCountByParams(map);
        return PageUtils.setListToJqGridPage(shCommunityInfos, page + 1, countAll, rows);
    }

    /**
     * 初始化挂牌房产所有的小区信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/queryCommunityInfo.do")
    public ModelAndView queryCommunityInfo(HttpServletRequest request, ModelAndView view) {
        Long beginTime = System.currentTimeMillis();
        /*首先获取所有的小区名信息*/
        List<String> nameListAll = new ArrayList<String>();
        nameListAll = secondhandhouseNewService.getAllCommunityName();
        /*获取小区信息表的信息*/
        Map<String, Object> params = new HashMap<String, Object>();
        List<ShCommunityInfo> shCommunityInfos = shCommunityInfoService.getByParams(params);
        if (null == shCommunityInfos) {
            return null;
        }
        List<String> nameListExist = new ArrayList<>();
        for (ShCommunityInfo shCommunityInfo : shCommunityInfos) {
            nameListExist.add(shCommunityInfo.getName());
        }
        /*批量对比两组数据的不同之处*/
        List<String> nameListInsert = ListUtils.compareStrList(nameListAll, nameListExist);
        for (String str : nameListInsert) {
            ShCommunityInfo shCommunityInfo = new ShCommunityInfo();
            shCommunityInfo.setName(str);
            shCommunityInfoService.insert(shCommunityInfo);
        }
        view.setViewName("index");
        Long endTime = System.currentTimeMillis();
        System.out.print("共处理数据：" + nameListInsert.size() + "条,使用时间：" + (endTime - beginTime));
        return view;
    }

    /**
     * 获取小区的坐标信息（百度坐标系）
     *
     * @param request
     * @param view
     * @return
     */
    @RequestMapping("/queryCommunityInfoCoordinate.do")
    public ModelAndView queryCommunityInfoCoordinate(HttpServletRequest request, ModelAndView view) {

        List<ShCommunityInfo> list = new ArrayList<ShCommunityInfo>();
        Map<String, Object> params = new HashMap<String, Object>();
        //params.put("id", 3);
        list = shCommunityInfoService.getByParams(params);
        int countAll = list.size();
        int countEfect = 0;
        for(ShCommunityInfo shCommunityInfo: list){
            //ShCommunityInfo shCommunityInfo = list.get(0);
            String url = Constants.BAIDU_COORDINATE_URL +
                    "?ak=" + Constants.AK + "&address=" + "上海市" + shCommunityInfo.getName()+"&output=json&callback=showLocation";
            String res = restTemplate.getForObject(url, String.class);
            if(null != res){
                /*解析百度接口返回值*/
                Map<String,String> map = this.queryCoordinate(res);
                if(null != map){
                    shCommunityInfo.setCoordinateLng(map.get("lng"));
                    shCommunityInfo.setCoordinateLat(map.get("lat"));
                    shCommunityInfoService.update(shCommunityInfo);
                    countEfect++;
                }
            }
        }
        /*for(ShCommunityInfo shCommunityInfo:list){
            shCommunityInfoService.update(shCommunityInfo);
        }*/
        System.out.print("分析总数为："+countAll+",有效分析数为："+countEfect);
        view.setViewName("");
        return view;
    }

    /**
     *
     * 用于解析百度API的返回数据queryCoordinat
     *
     * @param res
     * @return
     */
    public Map<String,String> queryCoordinate(String res){

        /*showLocation&&showLocation({"status":0,"result":{"location":{"lng":121.35211001234807,"lat":31.42105725341699},"precise":1,"confidence":80,"level":"地产小区"}})*/
        Map<String,String> map = new HashMap<String,String>();
        int start = res.indexOf("\"status\":");
        int end = res.indexOf(",\"",1);
        String status = res.substring(start+9,end);
        /*判断返回参数是否符合要求*/
        if(status.equals("0")){
            start = res.indexOf("\"lng\":");
            end = res.indexOf(",\"lat\":");
            String lng = res.substring(start+6,end);
            start = res.indexOf(",\"lat\":");
            end = res.indexOf("},\"");
            String lat = res.substring(start+7,end);
            map.put("lng",lng);
            map.put("lat",lat);
            return map;
        }
        return null;
    }



}
