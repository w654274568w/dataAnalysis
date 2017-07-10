package cn.dataAnalysis.utils;

import org.aspectj.apache.bcel.util.ClassLoaderRepository;

import java.util.HashMap;
import java.util.Map;

/**
 * 百度地图工具类
 * <p>
 * Created by feng on 2017/7/10.
 */
public class BaiduMapUtils {
    static double DEF_PI = 3.14159265359; // PI
    static double DEF_2PI = 6.28318530712; // 2*PI
    static double DEF_PI180 = 0.01745329252; // PI/180.0
    static double DEF_R = 6370693.5; // 地球半径

    /*
    适用于近距离计算两坐标系距离
     */
    public static double getShortDistance(double lon1, double lat1, double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI) {
            dew = DEF_2PI - dew;
        } else if (dew < -DEF_PI) {
            dew = DEF_2PI + dew;
        }
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public static double getShortDistance(Map<String, String> map1, Map<String, String> map2) {
        double lng1 = Double.valueOf(map1.get("lng"));
        double lng2 = Double.valueOf(map2.get("lng"));
        double lat1 = Double.valueOf(map1.get("lat"));
        double lat2 = Double.valueOf(map2.get("lat"));

        double ew1 = lng1 * DEF_PI180;
        double ns1 = lat1 * DEF_PI180;
        double ew2 = lng2 * DEF_PI180;
        double ns2 = lat2 * DEF_PI180;

        double dew = ew1 - ew2;
        if (dew > DEF_PI) {
            dew = DEF_2PI - dew;
        } else if (dew < -DEF_PI) {
            dew = DEF_2PI + dew;
        }
        double dx = DEF_R * Math.cos(ns1) * dew;

        double dy = DEF_R * (ns1 - ns2);

        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("lng", "121.35776105917565");
        map1.put("lat", "31.428721770061228");
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("lng", "121.480524");
        map2.put("lat", "31.23595");

        double distance =  BaiduMapUtils.getShortDistance(map1,map2);

        System.out.print("工具类 两点间的距离为："+ distance + "米");

        /**
         * 调用百度地图API计算两点间距离
         */

    }

}
