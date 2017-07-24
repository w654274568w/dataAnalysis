package cn.dataAnalysis.model;

/**
 *
 * 上海地理区块
 *
 * 默认lng1/lat1为区块西南角坐标系
 * 默认lng2/lat2为区块东北角坐标系
 *
 * Created by feng on 2017/7/11.
 */
public class ShGeographyBlock {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /*经度1*/
    private Double coordinateLng1;

    /*纬度1*/
    private Double coordinateLat1;

    /*经度2*/
    private Double coordinateLng2;

    /*经度2*/
    private Double coordinateLat2;

    /*地理尺度*/
    private Integer leval;

    /*上一层级ID*/
    private Integer SuperId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCoordinateLng1() {
        return coordinateLng1;
    }

    public void setCoordinateLng1(Double coordinateLng1) {
        this.coordinateLng1 = coordinateLng1;
    }

    public Double getCoordinateLat1() {
        return coordinateLat1;
    }

    public void setCoordinateLat1(Double coordinateLat1) {
        this.coordinateLat1 = coordinateLat1;
    }

    public Double getCoordinateLng2() {
        return coordinateLng2;
    }

    public void setCoordinateLng2(Double coordinateLng2) {
        this.coordinateLng2 = coordinateLng2;
    }

    public Double getCoordinateLat2() {
        return coordinateLat2;
    }

    public void setCoordinateLat2(Double coordinateLat2) {
        this.coordinateLat2 = coordinateLat2;
    }

    public Integer getLeval() {
        return leval;
    }

    public void setLeval(Integer leval) {
        this.leval = leval;
    }

    public Integer getSuperId() {
        return SuperId;
    }

    public void setSuperId(Integer superId) {
        SuperId = superId;
    }
}
