package cn.dataAnalysis.api;

import cn.dataAnalysis.utils.DateUtils;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

/**
 * Created by feng on 2017/7/26.
 */
@RestController
@RequestMapping("/api/v1")
public class DataAnalysisApiController {

    private final Logger logger = LoggerFactory.getLogger(DataAnalysisApiController.class);

    @ApiOperation(value = "getRegionPriceInfo", notes = "城区名房价信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "regionName", value = "城区名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "beginDateStr", value = "开始时间(如:2017-07-01)", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "endDateStr", value = "结束时间(如:2017-07-01)", required = false, paramType = "query", dataType = "String")
    })
    @RequestMapping(value = "/getRegionPriceInfo", method = RequestMethod.POST)
    @ResponseBody
    @Transactional
    public ApiDto getRegionPriceInfo(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam String regionName,
            @RequestParam String beginDateStr,
            @RequestParam String endDateStr) {
        ApiDto resultDto = new ApiDto();
        Pattern p = Pattern.compile("^[0-9]{4,4}-[0-1][0-9]-[0-3][0-9]$ ");
        /*校验regionName是否存在*/
        if(StringUtils.isBlank(regionName)){
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入城区名");
            return resultDto;
        }
        if(StringUtils.isBlank(beginDateStr)){
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入查询开始日期(如:2017-01-01)");
            return resultDto;
        }
        if(!DateUtils.isValidDate(beginDateStr)){
            resultDto.setErrNum(1);
            resultDto.setErrMsg("请输入正确的开始日期(如:2017-01-01)");
            return resultDto;
        }
        return resultDto;
    }
}
