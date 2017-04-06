package cn.dataAnalysis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.repository.SecondhandhouseOriginalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;

@Service
@Transactional
public class SecondhandhouseOriginalServiceImpl implements SecondhandhouseOriginalService{

	@Autowired
	private SecondhandhouseOriginalRepository secondhandhouseOriginalRepository;
	
	public SecondhandhouseOriginal getById(Integer id) {
		
		return null;
	}

	@Override
	public List<SecondhandhouseOriginal> findByCaptureTime(Date beginDate, Date endDate) {
		
		return secondhandhouseOriginalRepository.findByCaptureTime(beginDate, endDate);
	}
	
//	处理先关的重复参数
	

}
