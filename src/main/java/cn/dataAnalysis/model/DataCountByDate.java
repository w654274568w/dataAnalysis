package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by feng on 2017/4/6.
 */
public class DataCountByDate extends BaseEntity{

    /**
     * 每周数据汇总
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Date captureTime;

    private Long number;

    private Double averageTotalPrice;

    private Double averagePerPrice;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
