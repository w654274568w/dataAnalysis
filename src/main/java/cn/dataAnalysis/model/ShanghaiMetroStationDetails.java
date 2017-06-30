package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/11.
 */
public class ShanghaiMetroStationDetails extends BaseEntity{


    private static final long serialVersionUID = 1L;

    private Integer id;

    private String stationName;

    private String stationCode;

    private String transferSubway;

    /*经度*/
    private String coordinateLng;

    /*纬度*/
    private String coordinateLat;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getTransferSubway() {
        return transferSubway;
    }

    public void setTransferSubway(String transferSubway) {
        this.transferSubway = transferSubway;
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
