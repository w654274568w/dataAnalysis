package cn.dataAnalysis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dataAnalysis.mapper.SecondhandhouseOriginalMapper;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;

@Service
@Transactional
public class SecondhandhouseOriginalServiceImpl implements SecondhandhouseOriginalService{

	@Autowired
	private SecondhandhouseOriginalMapper secondhandhouseOriginalMapper;
	
	public SecondhandhouseOriginal getById(Integer id) {
		
		return secondhandhouseOriginalMapper.getById(id);
	}
	
//	处理先关的重复参数
	

}
