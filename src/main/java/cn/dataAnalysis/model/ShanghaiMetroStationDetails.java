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

    private String stationCoordinate;

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

    public String getStationCoordinate() {
        return stationCoordinate;
    }

    public void setStationCoordinate(String stationCoordinate) {
        this.stationCoordinate = stationCoordinate;
    }
}
