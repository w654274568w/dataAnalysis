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
	 *
	 */

}
