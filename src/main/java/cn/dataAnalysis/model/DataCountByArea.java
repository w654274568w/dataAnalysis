package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/6.
 */
public class DataCountByArea extends BaseEntity{


    private static final long serialVersionUID = 1L;

    private Integer id;

    private Double area;

    private Date captureTime;

    private Long number;

    private Double averageTotalPrice;

    private Double averagePerPrice;

    private Long attentionNumber;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getAverageTotalPrice() {
        return averageTotalPrice;
    }

    public void setAverageTotalPrice(Double averageTotalPrice) {
        this.averageTotalPrice = averageTotalPrice;
    }

    public Double getAveragePerPrice() {
        return averagePerPrice;
    }

    public void setAveragePerPrice(Double averagePerPrice) {
        this.averagePerPrice = averagePerPrice;
    }

    public Long getAttentionNumber() {
        return attentionNumber;
    }

    public void setAttentionNumber(Long attentionNumber) {
        this.attentionNumber = attentionNumber;
    }
}
