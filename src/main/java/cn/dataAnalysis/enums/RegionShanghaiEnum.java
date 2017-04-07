package cn.dataAnalysis.enums;

/**
 * 企业账户状态枚举
 * @author wn
 *
 */
public enum RegionShanghaiEnum {


	HUANGPU("01", "黄埔"),
	JINGAN("02", "静安"),
    XUHUI("03", "徐汇"),
    CHANGNING("04", "长宁"),
    HONGKOU("05", "虹口"),
    PUTUO("06", "普陀"),
    ZHABEI("07", "闸北"),
    YANGPU("08", "杨浦"),
    MINHANG("09", "闵行"),
    BAOSHAN("10", "宝山"),
    JIADING("11", "嘉定"),
    PUDONG("12", "浦东"),
    JINGSHAN("13", "金山"),
    SONGJIANG("14", "松江"),
    QINGPU("15", "青浦"),
    NANHUI("16", "南汇"),
    FENGXIAN("17", "奉贤"),
    CHOMGMING("18", "崇明");


    private String code;

    private String desc;

    private RegionShanghaiEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static RegionShanghaiEnum getByCode(String code) {
        for (RegionShanghaiEnum enumObj : RegionShanghaiEnum.values()) {
            if (enumObj.getCode().equals(code)) {
                return enumObj;
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
