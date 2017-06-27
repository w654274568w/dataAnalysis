package cn.dataAnalysis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseNew;

public interface SecondhandhouseNewService {
	
	void insert(SecondhandhouseNew sn);

	/**
	 * 根据时间查询数据量
	 * @param begainDate
	 * @param endDate
	 * @return
     */
	List<SecondhandhouseNew> getByDate(Date begainDate, Date endDate);
	
	int countAllData(Map<String,Object> params);

	/**
	 * 通过时间及区域名查找
	 * @param beginDate
	 * @param endDate
	 * @param regionName
     * @return
     */
	List<SecondhandhouseNew> findByRegionNameAndDate(Date beginDate, Date endDate, String regionName);

}
