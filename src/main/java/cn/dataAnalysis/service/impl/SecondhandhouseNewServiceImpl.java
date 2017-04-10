package cn.dataAnalysis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.repository.SecondhandhouseNewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.dataAnalysis.service.SecondhandhouseNewService;

@Service
@Transactional
public class SecondhandhouseNewServiceImpl implements SecondhandhouseNewService{

	@Autowired
	private SecondhandhouseNewRepository secondhandhouseNewRepository;
	@Override
	public void insert(SecondhandhouseNew sn) {
		secondhandhouseNewRepository.save(sn);
	}

	@Override
	public List<SecondhandhouseNew> getByDate(Date begainDate, Date endDate) {
		return  secondhandhouseNewRepository.findByBegainDateAndEndDate(begainDate, endDate);
	}

	@Override
	public int countAllData() {
		return secondhandhouseNewRepository.countAllData();
	}

	/**
	 * 通过时间及区域名查找
	 *
	 * @param beginDate
	 * @param endDate
	 * @param regionName
	 * @return
	 */
	@Override
	public List<SecondhandhouseNew> findByRegionNameAndDate(Date beginDate, Date endDate, String regionName) {
		return secondhandhouseNewRepository.findByRegionNameAndDate(beginDate, endDate, regionName);
	}

}
