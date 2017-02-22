package cn.dataAnalysis.model;

import java.util.Date;

public class SecondhandhouseOriginal extends BaseEntity{

	/**
	 * 链家网原始二手房数据
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
	private String area ;
	
	/*
	 * 城区名
	 */
	private String regionName ;
	
	/*
	 * 综合信息
	 */
	private String comprehensiveInformation ;
	
	/*
	 * 交通位置
	 */
	private String trafficLocation ;
	
	/*
	 * 房屋总价（挂牌价）
	 */
	private String totalPrice ;
	
	/*
	 * 均价
	 */
	private String averagePrice ;

	/*
	 * 关注度
	 */
	private String attentionNumber ;
	
	/*
	 * 抓取时间
	 */
	private Date captureTime;

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

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
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

	public String getTrafficLocation() {
		return trafficLocation;
	}

	public void setTrafficLocation(String trafficLocation) {
		this.trafficLocation = trafficLocation;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}

	public String getAttentionNumber() {
		return attentionNumber;
	}

	public void setAttentionNumber(String attentionNumber) {
		this.attentionNumber = attentionNumber;
	}

	public Date getCaptureTime() {
		return captureTime;
	}

	public void setCaptureTime(Date captureTime) {
		this.captureTime = captureTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "SecondhandhouseOriginal [id=" + id + ", title=" + title + ", communityName=" + communityName
				+ ", roomType=" + roomType + ", area=" + area + ", regionName=" + regionName
				+ ", comprehensiveInformation=" + comprehensiveInformation + ", trafficLocation=" + trafficLocation
				+ ", totalPrice=" + totalPrice + ", averagePrice=" + averagePrice + ", attentionNumber="
				+ attentionNumber + ", captureTime=" + captureTime + "]";
	}
	

}
