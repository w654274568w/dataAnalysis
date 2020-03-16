package cn.dataAnalysis.apiController;

import cn.dataAnalysis.apiController.dto.ApiResult;
import cn.dataAnalysis.apiController.dto.DataCountByRegionDTO;
import cn.dataAnalysis.apiController.dto.convert.DataCountByRegionConvert;
import cn.dataAnalysis.common.Constants;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.service.DataCountByDateService;
import cn.dataAnalysis.service.DataCountByRegionService;
import cn.dataAnalysis.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/26.
 */
@RestController
@RequestMapping("/api/v1")
@Api(description = "查询接口")
public class QueryApiController {

    @Autowired
    private DataCountByRegionService dataCountByRegionService;

    @Autowired
    private DataCountByDateService dataCountByDateService;

    private final Logger logger = LoggerFactory.getLogger(QueryApiController.class);

    /**
     * 查询时间轴
     *
     * @param request
     * @param response
     * @param regionName
     * @param beginDateStr
     * @param endDateStr
     * @return
     */
    @ApiOperation(value = "getRegionPriceInfo", notes = "城区名房价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName", value = "城区名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "beginDateStr", value = "开始时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDateStr", value = "结束时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getRegionPriceInfo", method = RequestMethod.POST)
    @ResponseBody
    public ApiResult getRegionPriceInfo(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam String regionName,
            @RequestParam String beginDateStr,
            @RequestParam String endDateStr) {
        ApiResult resultDto = new ApiResult();
        Map<String, Object> params = new HashMap<String, Object>();
        /*校验regionName是否存在*/
        if (StringUtils.isBlank(regionName)) {
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入城区名");
            return resultDto;
        }
        if (StringUtils.contains(regionName, "区")) {
            regionName = StringUtils.replace(regionName, "区", "");
        }
        boolean falge = false;
        for (String str : Constants.REGION) {
            if (str.equals(regionName)) {
                falge = true;
            }
        }
        if (!falge) {
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入正确的区域名");
            return resultDto;
        }
        params.put("regionName", regionName);
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
            List<DataCountByRegion> dataCountByRegionList = dataCountByRegionService.getByParams(params);
            List<DataCountByRegionDTO> dataCountByRegionDTOS =
                    DataCountByRegionConvert.convertToDTOs(dataCountByRegionList);
            resultDto.setErrNum(0);
            resultDto.setErrMsg("查询成功！");
            resultDto.setRetData(dataCountByRegionDTOS);
        } catch (Exception e) {
            resultDto.setErrNum(-1);
            resultDto.setErrMsg("查询失败！");
        }
        return resultDto;
    }

    @ApiOperation(value = "getPriceInfo", notes = "城区名房价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "beginDateStr", value = "开始时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDateStr", value = "结束时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getPriceInfo", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ApiResult getPriceInfo(HttpServletRequest request, HttpServletResponse response,
                               @RequestParam String beginDateStr,
                               @RequestParam String endDateStr) {
        ApiResult resultDto = new ApiResult();
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
            List<DataCountByDate> dataCountByDateList = dataCountByDateService.findForPage(params);
            resultDto.setErrNum(1);
            resultDto.setErrMsg("查询成功！");
            resultDto.setRetData(dataCountByDateList);
        } catch (Exception e) {
            resultDto.setErrNum(0);
            resultDto.setErrMsg("查询失败！");
        }
        return resultDto;
    }


}
