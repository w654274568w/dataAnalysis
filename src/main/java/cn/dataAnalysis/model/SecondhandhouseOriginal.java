package cn.dataAnalysis.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "secondhandhouse_original")
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
	private String comprehensiveInformation1 ;

	/*
	 * 综合信息
	 */
	private String comprehensiveInformation2 ;
	
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "title",length = 225)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "community_name",length = 225)
	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	@Column(name = "room_type",length = 225)
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	@Column(name = "area", length = 10, precision = 2)
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Column(name = "region_name", length = 225)
	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	@Column(name = "comprehensive_information_1",length = 225)
	public String getComprehensiveInformation1() {
		return comprehensiveInformation1;
	}

	public void setComprehensiveInformation1(String comprehensiveInformation1) {
		this.comprehensiveInformation1 = comprehensiveInformation1;
	}

	@Column(name = "comprehensive_information_2",length = 225)
	public String getComprehensiveInformation2() {
		return comprehensiveInformation2;
	}

	public void setComprehensiveInformation2(String comprehensiveInformation2) {
		this.comprehensiveInformation2 = comprehensiveInformation2;
	}

	@Column(name = "traffic_location",length = 225)
	public String getTrafficLocation() {
		return trafficLocation;
	}

	public void setTrafficLocation(String trafficLocation) {
		this.trafficLocation = trafficLocation;
	}

	@Column(name = "total_price",length = 225)
	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Column(name = "average_price",length = 225)
	public String getAveragePrice() {
		return averagePrice;
	}

	public void setAveragePrice(String averagePrice) {
		this.averagePrice = averagePrice;
	}

	@Column(name = "attention_number",length = 225)
	public String getAttentionNumber() {
		return attentionNumber;
	}

	public void setAttentionNumber(String attentionNumber) {
		this.attentionNumber = attentionNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "capture_time",length = 225)
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
				+ ", comprehensiveInformation=" + comprehensiveInformation1 + ", trafficLocation=" + trafficLocation
				+ ", totalPrice=" + totalPrice + ", averagePrice=" + averagePrice + ", attentionNumber="
				+ attentionNumber + ", captureTime=" + captureTime + "]";
	}
	

}
