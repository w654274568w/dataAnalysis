package cn.dataAnalysis.enums;

/**
 * Created by feng on 2017/7/10.
 */
public enum ResponseMapStatueEnums {

    SUCCESS("0000", "成功"),
    FAILED("4000","失败");

    private String code;

    private String desc;

    private ResponseMapStatueEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AreaEnums getByCode(String code) {
        for (AreaEnums enumObj : AreaEnums.values()) {
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
