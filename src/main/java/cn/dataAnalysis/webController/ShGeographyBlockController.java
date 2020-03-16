package cn.dataAnalysis.webController;

import cn.dataAnalysis.common.Constants;
import cn.dataAnalysis.model.ShGeographyBlock;
import cn.dataAnalysis.service.ShGeographyBlockService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by feng on 2017/7/11.
 */
@Controller
public class ShGeographyBlockController {

    @Autowired
    private ShGeographyBlockService shGeographyBlockService;


    /**
     * 初始化地理区块
     *
     * @param request
     */
    @RequestMapping("/queryShGeographyBlock.do")
    public void queryShGeographyBlock(HttpServletRequest request) {
        /*获取前台传入的区块级别（每个区块的长宽）*/
        String levalStr = request.getParameter("leval");
        if (StringUtils.isBlank(levalStr)) {
            return;
        }
        int leval = Integer.parseInt(levalStr);
        /*获取上海地理区域综合*/
        double latMax = Constants.BAIDU_SH_MAX_LAT;
        double latMin = Constants.BAIDU_SH_MIN_LAT;
        double lngMax = Constants.BAIDU_SH_MAX_LNG;
        double lngMin = Constants.BAIDU_SH_MIN_LNG;

        int i = leval / 1000;
        double levalLng = 0l;
        double levalLat = 0l;
        switch (i) {
            case 1:
                levalLng = Constants.BAIDU_LNG_1KM;
                levalLat = Constants.BAIDU_LAT_1KM;
                break;
            case 5:
                levalLng = Constants.BAIDU_LNG_5KM;
                levalLat = Constants.BAIDU_LAT_5KM;
                break;
            case 10:
                levalLng = Constants.BAIDU_LNG_10KM;
                levalLat = Constants.BAIDU_LAT_10KM;
                break;
            default:
                return;
        }
        /*获取经度集合*/
        List<Double> latList = new ArrayList<Double>();
        for (int m = 0; (latMin + m * levalLat) <= latMax; m++) {
            latList.add(latMin + m * levalLat);
        }
        /*获取纬度集合*/
        List<Double> lngList = new ArrayList<Double>();
        for (int n = 0; (lngMin + n * levalLng) <= lngMax; n++) {
            lngList.add(lngMin + n * levalLng);
        }
        /*初始化区块对象参数*/
        List<ShGeographyBlock> shGeographyBlocks = new ArrayList<ShGeographyBlock>();
        for (int j = 0; j < latList.size()-1; j++) {
            for (int k = 0; k < lngList.size()-1; k++) {
                ShGeographyBlock shGeographyBlock = new ShGeographyBlock();
                shGeographyBlock.setCoordinateLat1(latList.get(j));
                shGeographyBlock.setCoordinateLng1(lngList.get(k));
                shGeographyBlock.setCoordinateLat2(latList.get(j+1));
                shGeographyBlock.setCoordinateLng2(lngList.get(k+1));
                shGeographyBlock.setLeval(leval);
                shGeographyBlocks.add(shGeographyBlock);
            }
        }
        /*批量插入数据*/
        shGeographyBlockService.insertList(shGeographyBlocks);
    }
}
