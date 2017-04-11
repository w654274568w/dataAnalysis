package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/11.
 */
@Entity
@Table(name = "shanghai_metro_station_details")
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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "station_name",length = 225)
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Column(name = "station_code",length = 10)
    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    @Column(name = "transfer_subway",length = 20)
    public String getTransferSubway() {
        return transferSubway;
    }

    public void setTransferSubway(String transferSubway) {
        this.transferSubway = transferSubway;
    }

    @Column(name = "station_coordinate",length = 100)
    public String getStationCoordinate() {
        return stationCoordinate;
    }

    public void setStationCoordinate(String stationCoordinate) {
        this.stationCoordinate = stationCoordinate;
    }
}
