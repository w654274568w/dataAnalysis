package cn.dataAnalysis.model;

import java.util.Date;

public class SecondhandhouseNew extends BaseEntity{

	/**
	 * 链家网二手房数据(处理后)
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id ;
	
	/*
	 * 标题
	 */
	private String title ;
	
	/*
	 * 小区名
	 */
	private String communityName ;
	
	/*
	 * 房型
	 */
	private String roomType ;
	
	/*
	 * 面积（平方米）
	 */
	private Double area ;
	
	/*
	 * 城区名
	 */
	private String regionName ;
	
	/*
	 * 综合信息
	 */
	private String comprehensiveInformation ;
	
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
	private String trafficLocation ;
	
	/*
	 * 房屋总价（挂牌价）
	 */
	private Double totalPrice ;
	
	/*
	 * 均价
	 */
	private Double averagePrice ;

	/*
	 * 关注度
	 */
	private Integer attentionNumber ;
	
	/*
	 * 抓取时间
	 */
	private Date captureTime;
	
	/*
	 * 原始数据id
	 */
	private Integer originalId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Double getArea() {
		return area;
	}

	public void setArea(Double area) {
		this.area = area;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getComprehensiveInformation() {
		return comprehensiveInformation;
	}

	public void setComprehensiveInformation(String comprehensiveInformation) {
		this.comprehensiveInformation = comprehensiveInformation;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getHighLowArea() {
		return highLowArea;
	}

	public void setHighLowArea(String highLowArea) {
		this.highLowArea = highLowArea;
	}

	public Integer getConstructionYear() {
		return constructionYear;
	}

	public void setConstructionYear(Integer constructionYear) {
		this.constructionYear = constructionYear;
	}

	public String getTrafficLocation() {
		return trafficLocation;
	}

	public void setTrafficLocation(String trafficLocation) {
		this.trafficLocation = trafficLocation;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(Double averagePrice) {
		this.averagePrice = averagePrice;
	}

	public Integer getAttentionNumber() {
		return attentionNumber;
	}

	public void setAttentionNumber(Integer attentionNumber) {
		this.attentionNumber = attentionNumber;
	}

	public Date getCaptureTime() {
		return captureTime;
	}

	public void setCaptureTime(Date captureTime) {
		this.captureTime = captureTime;
	}

	public Integer getOriginalId() {
		return originalId;
	}

	public void setOriginalId(Integer originalId) {
		this.originalId = originalId;
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
