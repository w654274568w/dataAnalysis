package cn.dataAnalysis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.dao.SecondhandhouseOriginalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;

@Service
@Transactional
public class SecondhandhouseOriginalServiceImpl implements SecondhandhouseOriginalService{

	@Autowired
	private SecondhandhouseOriginalDao secondhandhouseOriginalDao;

	
	public SecondhandhouseOriginal getById(Integer id) {
		
		return null;
	}

	@Override
	public List<SecondhandhouseOriginal> findByCaptureTime(Map<String,Object> map) {

		return secondhandhouseOriginalDao.findByCaptureTime(map);
	}
	
//	处理先关的重复参数
	

}
