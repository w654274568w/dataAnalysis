package cn.dataAnalysis.enums;

/**
 * 企业账户状态枚举
 * @author wn
 *
 */
public enum MetroEnums {


	LINE01("01", "一号线"),
    LINE02("02", "二号线"),
    LINE03("03", "三号线"),
    LINE04("04", "四号线"),
    LINE05("05", "五号线"),
    LINE06("06", "六号线"),
    LINE07("07", "七号线"),
    LINE08("08", "八号线"),
    LINE09("09", "九号线"),
    LINE10("10", "十号线"),
    LINE11("11", "十一号线"),
    LINE12("12", "十二号线"),
    LINE13("13", "十三号线"),
    LINE14("14", "十四号线"),
    LINE15("15", "十五号线"),
    LINE16("16", "十六号线"),
    LINE17("17", "十七号线")
    ;


    private String code;

    private String desc;

    private MetroEnums(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static MetroEnums getByCode(String code) {
        for (MetroEnums enumObj : MetroEnums.values()) {
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
