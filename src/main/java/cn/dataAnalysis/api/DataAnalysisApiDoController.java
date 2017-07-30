package cn.dataAnalysis.api;

import cn.dataAnalysis.api.dto.ApiDTO;
import cn.dataAnalysis.api.dto.DataCountByRegionDTO;
import cn.dataAnalysis.api.dto.convert.DataCountByRegionConvert;
import cn.dataAnalysis.common.Constants;
import cn.dataAnalysis.enums.RegionShanghaiEnum;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.service.DataCountByDateService;
import cn.dataAnalysis.service.DataCountByRegionService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.utils.BaiduMapUtils;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.corba.se.spi.ior.ObjectKey;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by feng on 2017/7/26.
 */
@RestController
@RequestMapping("/api/v1")
public class DataAnalysisApiDoController {

    @Autowired
    private DataCountByDateService dataCountByDateService;

    @Autowired
    private SecondhandhouseNewService secondhandhouseNewService;

    @Autowired
    private DataCountByRegionService dataCountByRegionService;

    @Autowired
    private RestTemplate restTemplate;

    private final Logger logger = LoggerFactory.getLogger(DataAnalysisApiDoController.class);


    @ApiOperation(value = "/queryPriceInfo.do", notes = "生成总房价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginDateStr", value = "开始时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDateStr", value = "结束时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/queryPriceInfo.do", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ApiDTO getPriceInfo(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam String beginDateStr,
                               @RequestParam String endDateStr) {
        ApiDTO resultDto = new ApiDTO();
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isBlank(beginDateStr)) {
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入查询开始日期(如:2017-01-01)");
            return resultDto;
        }
        if (!DateUtils.isValidDate(beginDateStr)) {
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入正确的开始日期(如:2017-01-01)");
            return resultDto;
        }
        params.put("beginDate", beginDateStr);
        if (!StringUtils.isBlank(endDateStr)) {
            if (!DateUtils.isValidDate(endDateStr)) {
                resultDto.setErrNum(1);
                resultDto.setErrMsg("请输入正确查询结束日期(如:2017-01-01)");
                return resultDto;
            }
        }
        params.put("endDate", endDateStr);
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = df.parse(beginDateStr);
            /*首先删除系统已存在的内容*/
            dataCountByDateService.deleteByParams(params);
            List<SecondhandhouseNew> secondhandhouseNewList = secondhandhouseNewService.getByParams(params);
            if (secondhandhouseNewList.size() > 0) {
                DataCountByDate dataCountByDate = new DataCountByDate();
                Double averageTotalPrice = 0.0;
                Double averagePerPrice = 0.0;
                for (SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList) {
                    averagePerPrice = MathUtil.add(averagePerPrice, secondhandhouseNew.getAveragePrice());
                    averageTotalPrice = MathUtil.add(averageTotalPrice, secondhandhouseNew.getTotalPrice());
                }
                dataCountByDate.setCaptureTime(DateUtils.addDay(beginDate, 1));
                dataCountByDate.setNumber(Long.valueOf(secondhandhouseNewList.size()));
                dataCountByDate.setAverageTotalPrice(averageTotalPrice / secondhandhouseNewList.size());
                dataCountByDate.setAveragePerPrice(averagePerPrice / secondhandhouseNewList.size());
                dataCountByDateService.save(dataCountByDate);
            }
            resultDto.setErrNum(1);
            resultDto.setErrMsg("操作成功！");
        } catch (Exception e) {
            resultDto.setErrNum(0);
            resultDto.setErrMsg("操作失败！");
        }
        return resultDto;
    }

    /**
     * 初始化区块信息
     *
     * @param request
     * @param response
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @ApiOperation(value = "/queryRegionPriceInfo.do", notes = "生成城区房价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginDateStr", value = "开始时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDateStr", value = "结束时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/queryRegionPriceInfo.do", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ApiDTO queryRegionPriceInfo(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam String beginDateStr,
            @RequestParam String endDateStr) {
        ApiDTO resultDto = new ApiDTO();
        Map<String, Object> params = new HashMap<String, Object>();
        if (StringUtils.isBlank(beginDateStr)) {
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入查询开始日期(如:2017-01-01)");
            return resultDto;
        }
        if (!DateUtils.isValidDate(beginDateStr)) {
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入正确的开始日期(如:2017-01-01)");
            return resultDto;
        }
        params.put("beginDate", beginDateStr);
        if (!StringUtils.isBlank(endDateStr)) {
            if (!DateUtils.isValidDate(endDateStr)) {
                resultDto.setErrNum(1);
                resultDto.setErrMsg("请输入正确查询结束日期(如:2017-01-01)");
                return resultDto;
            }
        }
        params.put("endDate", endDateStr);
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date beginDate = df.parse(beginDateStr);
            dataCountByRegionService.deleteByParams(params);
            List<SecondhandhouseNew> secondhandhouseNewList = new ArrayList<SecondhandhouseNew>();
            for (RegionShanghaiEnum regionShanghaiEnum : RegionShanghaiEnum.values()) {
                DataCountByRegion dataCountByRegion = new DataCountByRegion();
                dataCountByRegion.setRegionCode(regionShanghaiEnum.getCode());
                dataCountByRegion.setRegionName(regionShanghaiEnum.getDesc());
                //查询单一区域数据信息
                params.put("regionName", regionShanghaiEnum.getDesc());
                secondhandhouseNewList = secondhandhouseNewService.getByParams(params);
                Double totalPriceAmount = 0.0;
                Double averagePriceAmount = 0.0;
                Long number = 0l;
                if (null != secondhandhouseNewList && secondhandhouseNewList.size() > 0) {
                    for (SecondhandhouseNew secondhandhouseNew : secondhandhouseNewList) {
                        totalPriceAmount = MathUtil.add(totalPriceAmount, secondhandhouseNew.getTotalPrice());
                        averagePriceAmount = MathUtil.add(averagePriceAmount, secondhandhouseNew.getAveragePrice());
                        number += 1;
                    }
                    dataCountByRegion.setAverageTotalPrice(totalPriceAmount / secondhandhouseNewList.size());
                    dataCountByRegion.setAveragePerPrice(averagePriceAmount / secondhandhouseNewList.size());
                    dataCountByRegion.setNumber(number);
                    dataCountByRegion.setCaptureTime(DateUtils.addDay(beginDate, 1));
                    dataCountByRegionService.save(dataCountByRegion);
                }
            }
            resultDto.setErrNum(1);
            resultDto.setErrMsg("操作成功！");
        } catch (Exception e) {
            resultDto.setErrNum(0);
            resultDto.setErrMsg("操作失败！");
        }
        return resultDto;
    }

    /**
     * 计算两坐标之间的通勤
     */
    @ApiOperation(value = "/queryCommuteInfo.do", notes = "生成通勤信息信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "location1", value = "位置坐标1 (如: 121.4304864925679,31.20660427305056) ", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "locatuon2", value = "位置坐标2 (如: 121.4304864925679,31.20660427305056) ", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/queryCommuteInfo.do", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ApiDTO queryCommuteInfo(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam String location1,
            @RequestParam String locatuon2) {
        ApiDTO apiDTO = new ApiDTO();
        /*校验坐标系参数*/
        if (2 != location1.split(",").length) {
            apiDTO.setErrNum(1);
            apiDTO.setErrMsg("请输出正确的位置坐标1");
            return apiDTO;
        }
        if (2 != locatuon2.split(",").length) {
            apiDTO.setErrNum(1);
            apiDTO.setErrMsg("请输出正确的位置坐标2");
            return apiDTO;
        }
        String lat1 = location1.split(",")[0];
        String lng1 = location1.split(",")[1];
        String lat2 = locatuon2.split(",")[0];
        String lng2 = locatuon2.split(",")[1];
        if (!BaiduMapUtils.checkIsInSh(lat1, lng1)) {
            apiDTO.setErrNum(1);
            apiDTO.setErrMsg("位置坐标1，超出上海范围！");
            return apiDTO;
        }
        if (!BaiduMapUtils.checkIsInSh(lat2, lng2)) {
            apiDTO.setErrNum(1);
            apiDTO.setErrMsg("位置坐标2，超出上海范围！");
            return apiDTO;
        }
        /*拼接数据，请求百度地图API*/
        String url = Constants.BAIDU_ROUTEMATRIX_DRIVE_URL + "?ak=" + Constants.AK + "&output=json"+"&origins="+
                lat1.toString() + "," + lng1.toString()+"&destinations="+lat2.toString() + "," + lng2.toString();
        String res = restTemplate.getForObject(url,String.class);
        JSONObject result = JSON.parseObject(res);
        String status = result.get("status").toString();
        if ("0".equals(result.get("status").toString())) {
            apiDTO.setErrNum(0);
            apiDTO.setErrMsg("查询成功");
            apiDTO.setRetData(result);
        } else {
            apiDTO.setErrNum(1);
            apiDTO.setErrMsg("查询失败");
        }
        return apiDTO;
    }


}
