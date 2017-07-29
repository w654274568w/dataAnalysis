package cn.dataAnalysis.api;

import cn.dataAnalysis.api.dto.ApiDTO;
import cn.dataAnalysis.api.dto.DataCountByRegionDTO;
import cn.dataAnalysis.api.dto.convert.DataCountByRegionConvert;
import cn.dataAnalysis.common.Constants;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.service.DataCountByDateService;
import cn.dataAnalysis.service.DataCountByRegionService;
import cn.dataAnalysis.service.SecondhandhouseNewService;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.MathUtil;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
                    averagePerPrice = MathUtil.add(averagePerPrice,secondhandhouseNew.getAveragePrice());
                    averageTotalPrice = MathUtil.add(averageTotalPrice,secondhandhouseNew.getTotalPrice());
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


}
