package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/6.
 */
@Entity
@Table(name = "data_count_by_region")
public class DataCountByRegion extends BaseEntity{


    private static final long serialVersionUID = 1L;

    private Integer id;

    private String regionCode;

    private Date captureTime;

    private Long number;

    private Double averageTotalPrice;

    private Double averagePerPrice;

    private String regionName;

    private Long attentionNumber;

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

    @Column(name = "region_code",length = 2)
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "capture_time")
    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    @Column(name = "number",length = 11)
    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    @Column(name = "average_total_price",length = 10, precision = 2)
    public Double getAverageTotalPrice() {
        return averageTotalPrice;
    }

    public void setAverageTotalPrice(Double averageTotalPrice) {
        this.averageTotalPrice = averageTotalPrice;
    }

    @Column(name = "average_per_price",length = 10, precision = 2)
    public Double getAveragePerPrice() {
        return averagePerPrice;
    }

    public void setAveragePerPrice(Double averagePerPrice) {
        this.averagePerPrice = averagePerPrice;
    }

    @Column(name = "region_name",length = 11)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Column(name = "attention_number",length = 10)
    public Long getAttentionNumber() {
        return attentionNumber;
    }

    public void setAttentionNumber(Long attentionNumber) {
        this.attentionNumber = attentionNumber;
    }
}
