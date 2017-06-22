package cn.dataAnalysis.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseNew;

public interface SecondhandhouseNewService {
	
	public void insert(SecondhandhouseNew sn);

	/**
	 * 根据时间查询数据量
	 * @param begainDate
	 * @param endDate
	 * @return
     */
	public List<SecondhandhouseNew> getByDate(Date begainDate, Date endDate);
	
	public int countAllData();

	/**
	 * 通过时间及区域名查找
	 * @param beginDate
	 * @param endDate
	 * @param regionName
     * @return
     */
	public List<SecondhandhouseNew> findByRegionNameAndDate(Date beginDate, Date endDate, String regionName);

	/**
	 * JDBC方式原生查询对象信息
	 * @param begainDate
	 * @param endDate
	 * @return
	 */
	public List<SecondhandhouseNew> findByJdbc(Date begainDate, Date endDate);

}
