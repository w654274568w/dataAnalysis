package cn.dataAnalysis.enums;

/**
 * 企业账户状态枚举
 * @author wn
 *
 */
public enum RegionShanghaiEnum {


	ENABLE("0", "启用"),

	UNENABLE("1", "禁用");


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
