package cn.dataAnalysis.model;

/**
 *
 * 上海小区信息
 *
 * Created by feng on 2017/6/28.
 */
public class ShCommunityInfo extends BaseEntity{

    private Integer id;

    /*小区名*/
    private String name;

    /*经度*/
    private String coordinateLng;

    /*纬度*/
    private  String coordinateLat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoordinateLng() {
        return coordinateLng;
    }

    public void setCoordinateLng(String coordinateLng) {
        this.coordinateLng = coordinateLng;
    }

    public String getCoordinateLat() {
        return coordinateLat;
    }

    public void setCoordinateLat(String coordinateLat) {
        this.coordinateLat = coordinateLat;
    }
}
