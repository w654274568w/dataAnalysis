package cn.dataAnalysis.enums;

/**
 * 企业账户状态枚举
 * @author wn
 *
 */
public enum AreaEnums {


	HUANGPU(0, "黄浦");


    private Integer code;

    private String desc;

    private AreaEnums(Integer code, String desc) {
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

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
