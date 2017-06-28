package cn.dataAnalysis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.dao.SecondhandhouseNewDao;
import cn.dataAnalysis.model.SecondhandhouseNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.dataAnalysis.service.SecondhandhouseNewService;

@Service
@Transactional
public class SecondhandhouseNewServiceImpl implements SecondhandhouseNewService{

	@Autowired
	private SecondhandhouseNewDao secondhandhouseNewDao;

	@Override
	public void insert(SecondhandhouseNew sn) {
		secondhandhouseNewDao.insert(sn);
	}

	@Override
	public List<SecondhandhouseNew> getByDate(Date begainDate, Date endDate) {
		return  null;
	}

	@Override
	public int countAllData(Map<String,Object> params) {
		return secondhandhouseNewDao.getTotalCount();
	}
	/**
	 * 通过时间及区域名查找
	 *
	 * @return
	 */
	@Override
	public List<SecondhandhouseNew> findByRegionNameAndDate(Map<String,Object> params) {
		return secondhandhouseNewDao.findByRegionNameAndDate(params);
	}

}
