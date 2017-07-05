package cn.dataAnalysis.controller;

import cn.dataAnalysis.common.Constants;
import cn.dataAnalysis.common.page.JqGridPage;
import cn.dataAnalysis.common.page.PageUtils;
import cn.dataAnalysis.model.DataCountByCommunity;
import cn.dataAnalysis.model.ResponseDataBaidu;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.model.ShCommunityInfo;
import cn.dataAnalysis.service.DataCountByCommunityService;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    private DataCountByCommunityService dataCountByCommunityService;


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/communityLocationInfo.html")
    public String communityLocationInfo(HttpServletRequest request) {
        request.setAttribute("ak", Constants.AK);
        return "/community/communityLocation";
    }

    @RequestMapping("/communityLocationInfoList.json")
    @ResponseBody
    public JqGridPage communityLocationInfoListJson(HttpServletRequest request) {
        //分页码
        int page = Integer.parseInt(request.getParameter("page")) - 1;
        int rows = Integer.parseInt(request.getParameter("rows"));
        String name = request.getParameter("name");
        //分页参数
        Map<String, Object> map = new HashMap<>();
        map.put("begin", page * rows);
        map.put("rows", rows);
        if (!StringUtil.isEmpty(name)) {
            map.put("name", name);
        }
        List<ShCommunityInfo> shCommunityInfos = shCommunityInfoService.getByParams(map);
        int countAll = shCommunityInfoService.getCountByParams(map);
        return PageUtils.setListToJqGridPage(shCommunityInfos, page + 1, countAll, rows);
    }

    @RequestMapping("/communityPriceInfo.html")
    public String communityPriceInfo(HttpServletRequest request) {
        return "/community/communityPrice";
    }

    @RequestMapping("/communityPriceInfo.json")
    @ResponseBody
    public JqGridPage communityPriceInfoJson(HttpServletRequest request) {
        //分页码
        int page = Integer.parseInt(request.getParameter("page")) - 1;
        int rows = Integer.parseInt(request.getParameter("rows"));
        String name = request.getParameter("name");
        //分页参数
        Map<String, Object> map = new HashMap<>();
        map.put("begin", page * rows);
        map.put("rows", rows);
        if (!StringUtil.isEmpty(name)) {
            map.put("name", name);
        }
        /*实体集合*/
        List<DataCountByCommunity> dataCountByCommunities = dataCountByCommunityService.getByParams(map);
        /*分页参数*/
        int countAll = dataCountByCommunityService.countByParams(map);
        return PageUtils.setListToJqGridPage(dataCountByCommunities, page + 1, countAll, rows);
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
        view.setViewName("/community.html");
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
        /*遍历插入*/
        for (ShCommunityInfo shCommunityInfo : list) {
            String url = Constants.BAIDU_COORDINATE_URL +
                    "?ak=" + Constants.AK + "&address=" + "上海市" + shCommunityInfo.getName() + "&output=json&callback=showLocation";
            String res = restTemplate.getForObject(url, String.class);
            if (null != res) {
                /*解析百度接口返回值*/
                Map<String, String> map = this.queryCoordinate(res);
                if (null != map) {
                    shCommunityInfo.setCoordinateLng(map.get("lng"));
                    shCommunityInfo.setCoordinateLat(map.get("lat"));
                    shCommunityInfoService.update(shCommunityInfo);
                    countEfect++;
                }
            }
        }
        System.out.print("分析总数为：" + countAll + ",有效分析数为：" + countEfect);
        view.setViewName("/community.html");
        return view;
    }

    /**
     *
     * 按期更新小区价格信息
     *
     * @param request
     * @throws Exception
     */
    @RequestMapping("/queryCommunityPrice.do")
    public void queryCommunityPrice(HttpServletRequest request) throws Exception {
        String beginDateStr = request.getParameter("beginDateStr");
        String endDateStr = request.getParameter("endDateStr");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = df.parse(beginDateStr);
        Date endDate = df.parse(endDateStr);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("beginDate", beginDate);
        map.put("endDate", endDate);
        List<SecondhandhouseNew> secondhandhouseNewList = secondhandhouseNewService.findByRegionNameAndDate(map);
        List<ShCommunityInfo> shCommunityInfoList = shCommunityInfoService.getByParams(map);
        List<DataCountByCommunity> dataCountByCommunityList = new ArrayList<DataCountByCommunity>();
        /*初始化社区数组对象*/
        for (ShCommunityInfo shCommunityInfo : shCommunityInfoList) {
            DataCountByCommunity dataCountByCommunity = new DataCountByCommunity();
            dataCountByCommunity.setInfoId(shCommunityInfo.getId());
            dataCountByCommunity.setCommunityName(shCommunityInfo.getName());
            dataCountByCommunity.setAveragePerPrice(0.00);
            dataCountByCommunity.setAverageTotalPrice(0.00);
            dataCountByCommunity.setNumber(0l);
            dataCountByCommunityList.add(dataCountByCommunity);
        }
        /*初始化实体信息*/
        for (SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList) {
            if (!StringUtil.isEmpty(secondhandhouseNew.getCommunityName())) {
                for (DataCountByCommunity dataCountByCommunity : dataCountByCommunityList) {
                    if (secondhandhouseNew.equals(dataCountByCommunity.getCommunityName())) {
                        dataCountByCommunity.setNumber(dataCountByCommunity.getNumber() + 1);
                        dataCountByCommunity.setAveragePerPrice(
                                dataCountByCommunity.getAveragePerPrice() + secondhandhouseNew.getAveragePrice());
                        dataCountByCommunity.setAverageTotalPrice(
                                dataCountByCommunity.getAverageTotalPrice() + secondhandhouseNew.getTotalPrice());
                    }
                }
            }
        }
        /*最终确定实体对象信息*/
        for (DataCountByCommunity dataCountByCommunity : dataCountByCommunityList) {
            if (dataCountByCommunity.getNumber() > 0) {
                dataCountByCommunity.setAverageTotalPrice(
                        dataCountByCommunity.getAverageTotalPrice() / dataCountByCommunity.getNumber());
                dataCountByCommunity.setAveragePerPrice(
                        dataCountByCommunity.getAveragePerPrice()/ dataCountByCommunity.getNumber());
            }
        }
        /*将生成的对象集合插入数据库中*/


    }


    /**
     * 用于解析百度API的返回数据queryCoordinat
     *
     * @param res
     * @return
     */
    public Map<String, String> queryCoordinate(String res) {

        /*showLocation&&showLocation({"status":0,"result":{"location":
        {"lng":121.35211001234807,"lat":31.42105725341699},"precise":1,"confidence":80,"level":"地产小区"}})*/
        Map<String, String> map = new HashMap<String, String>();
        int start = res.indexOf("\"status\":");
        int end = res.indexOf(",\"", 1);
        String status = res.substring(start + 9, end);
        /*判断返回参数是否符合要求*/
        if (status.equals("0")) {
            start = res.indexOf("\"lng\":");
            end = res.indexOf(",\"lat\":");
            String lng = res.substring(start + 6, end);
            start = res.indexOf(",\"lat\":");
            end = res.indexOf("},\"");
            String lat = res.substring(start + 7, end);
            map.put("lng", lng);
            map.put("lat", lat);
            return map;
        }
        return null;
    }


}
