package cn.dataAnalysis.common;


/**
 * 系统全局常量类
 *
 * @author feng
 */
public class Constants {

    /**
     * 百度开发者API认证ak
     */
    public static final String AK = "XFrWVCveolSMIXvgB5aQm4aoQd10quWr";
    /**
     * 百度地图API（通过地名获取坐标轴）
     */
    public static final String BAIDU_COORDINATE_URL = "http://api.map.baidu.com/geocoder/v2/";

    /**
     * 上海默认的坐标范围
     */
    public static final double BAIDU_SH_MAX_LNG = 122.00000;
    public static final double BAIDU_SH_MIN_LNG = 120.87600;
    public static final double BAIDU_SH_MAX_LAT = 31.865527;
    public static final double BAIDU_SH_MIN_LAT = 30.692052;


    /**
     * 单位距离百度坐标系纬度差
     */
    public static final double BAIDU_LAT_10KM = 0.09;
    public static final double BAIDU_LAT_5KM = 0.045;
    public static final double BAIDU_LAT_1KM = 0.009;


    /**
     * 单位距离百度坐标系経度差
     */
    public static final double BAIDU_LNG_10KM = 0.1059;
    public static final double BAIDU_LNG_5KM = 0.05295;
    public static final double BAIDU_LNG_1KM = 0.01059;

    /**
     * 查询路径前缀V
     */
    public static final String PRE_PATH_VIEW = "v_";

    public static final String HTML_Quotes_Double = "&quot;";// 双引号
    public static final String HTML_Quotes_Single = "&apos;";// 单引号
    /**
     * 更新路径前缀o
     */
    public static final String PRE_PATH_EDIT = "o_";

    public static final String PAGED_CURPAGE = "pageNum"; // 当前第几页
    public static final String PAGED_NUM_PERPAGE = "numPerPage";// 每页显示多少条
    public static final String PAGED_NUM = "10";//每页显示的条数

    /**
     * UTF-8编码
     */
    public static final String UTF8 = "UTF-8";
    /**
     * 提示信息
     */
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    /**
     * cookie中的JSESSIONID名称
     */
    public static final String JSESSION_COOKIE = "JSESSIONID";
    /**
     * url中的jsessionid名称
     */
    public static final String JSESSION_URL = "jsessionid";
    /**
     * 附件路径
     */
    public static final String FILEPATH = "files";
    /**
     * HTTP POST请求
     */
    public static final String POST = "POST";
    /**
     * HTTP GET请求
     */
    public static final String GET = "GET";

}
