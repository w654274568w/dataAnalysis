package cn.dataAnalysis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.dataAnalysis.mapper.SecondhandhouseNewMapper;
import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.service.SecondhandhouseNewService;

@Service
@Transactional
public class SecondhandhouseNewServiceImpl implements SecondhandhouseNewService{
	@Autowired
	private SecondhandhouseNewMapper secondhandhouseNewMapper;

	@Override
	public void insert(SecondhandhouseNew sn) {
		secondhandhouseNewMapper.insert(sn);
	}

	@Override
	public List<SecondhandhouseNew> getByDate(Date date) {
		return null;
	}

}
