package cn.dataAnalysis.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;

@Service
@Transactional
public class SecondhandhouseOriginalServiceImpl implements SecondhandhouseOriginalService{

	
	public SecondhandhouseOriginal getById(Integer id) {
		
		return null;
	}

	@Override
	public List<SecondhandhouseOriginal> findByCaptureTime(Map<String,Object> map) {

		return null;
	}
	
//	处理先关的重复参数
	

}
