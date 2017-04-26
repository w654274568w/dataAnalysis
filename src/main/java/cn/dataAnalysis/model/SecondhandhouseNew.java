package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "secondhandhouse_new")
public class SecondhandhouseNew extends BaseEntity {

    /**
     * 链家网二手房数据(处理后)
     */
    private static final long serialVersionUID = 1L;

    private Integer id;

    /*
     * 标题
     */
    private String title;

    /*
     * 小区名
     */
    private String communityName;

    /*
     * 房型
     */
    private String roomType;

    /*
     * 面积（平方米）
     */
    private Double area;

    /*
     * 城区名
     */
    private String regionName;

    /*
     * 城区名(次级区域)
     */
    private String regionNameSecondary;

    /*
     * 综合信息
     */
    private String comprehensiveInformation;

    /*
     *朝向
     */
    private String orientation;

    /*
     * 高低区
     */
    private String highLowArea;

    /*
     * 建筑年限
     */
    private Integer constructionYear;

    /*
     * 交通位置
     */
    private String trafficLocation;

    /*
     * 房屋总价（挂牌价）
     */
    private Double totalPrice;

    /*
     * 均价
     */
    private Double averagePrice;

    /*
     * 关注度
     */
    private Integer attentionNumber;

    /*
     * 抓取时间
     */
    private Date captureTime;

    /*
     * 原始数据id
     */
    private Integer originalId;

    /*
     *链家ID
     */
    private Integer dataId;

    /*
     * 地铁站点名称
     */
    private String stationName;

    /*
     * 地铁站点距离
     */
    private Integer stationDistance;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title", length = 225)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "community_name", length = 225)
    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName;
    }

    @Column(name = "room_type", length = 225)
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    @Column(name = "area", length = 10, precision = 2)
    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Column(name = "region_name", length = 225)
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Column(name = "region_name_secondary", length = 225)
    public String getRegionNameSecondary() {
        return regionNameSecondary;
    }

    public void setRegionNameSecondary(String regionNameSecondary) {
        this.regionNameSecondary = regionNameSecondary;
    }

    @Column(name = "comprehensive_information", length = 225)
    public String getComprehensiveInformation() {
        return comprehensiveInformation;
    }

    public void setComprehensiveInformation(String comprehensiveInformation) {
        this.comprehensiveInformation = comprehensiveInformation;
    }

    @Column(name = "orientation", length = 225)
    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    @Column(name = "high_low_area", length = 225)
    public String getHighLowArea() {
        return highLowArea;
    }

    public void setHighLowArea(String highLowArea) {
        this.highLowArea = highLowArea;
    }

    @Column(name = "construction_year", length = 225)
    public Integer getConstructionYear() {
        return constructionYear;
    }

    public void setConstructionYear(Integer constructionYear) {
        this.constructionYear = constructionYear;
    }

    @Column(name = "traffic_location", length = 225)
    public String getTrafficLocation() {
        return trafficLocation;
    }

    public void setTrafficLocation(String trafficLocation) {
        this.trafficLocation = trafficLocation;
    }

    @Column(name = "total_price", length = 225)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Column(name = "average_price", length = 225)
    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    @Column(name = "attention_number", length = 11)
    public Integer getAttentionNumber() {
        return attentionNumber;
    }

    public void setAttentionNumber(Integer attentionNumber) {
        this.attentionNumber = attentionNumber;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "capture_time")
    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    @Column(name = "original_id", length = 11)
    public Integer getOriginalId() {
        return originalId;
    }

    public void setOriginalId(Integer originalId) {
        this.originalId = originalId;
    }

    @Column(name = "data_id", length = 11)
    public Integer getDataId() {
        return dataId;
    }

    public void setDataId(Integer dataId) {
        this.dataId = dataId;
    }

    @Column(name = "station_name", length = 50)
    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @Column(name = "station_distance", length = 10)
    public Integer getStationDistance() {
        return stationDistance;
    }

    public void setStationDistance(Integer stationDistance) {
        this.stationDistance = stationDistance;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "SecondhandhouseNew [id=" + id + ", title=" + title + ", communityName=" + communityName + ", roomType="
                + roomType + ", area=" + area + ", regionName=" + regionName + ", comprehensiveInformation="
                + comprehensiveInformation + ", orientation=" + orientation + ", highLowArea=" + highLowArea
                + ", constructionYear=" + constructionYear + ", trafficLocation=" + trafficLocation + ", totalPrice="
                + totalPrice + ", averagePrice=" + averagePrice + ", attentionNumber=" + attentionNumber
                + ", captureTime=" + captureTime + ", originalId=" + originalId + "]";
    }

}
