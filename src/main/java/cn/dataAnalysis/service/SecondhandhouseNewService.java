package cn.dataAnalysis.service;

import java.util.Date;
import java.util.List;

import cn.dataAnalysis.model.SecondhandhouseNew;

public interface SecondhandhouseNewService {
	
	public void insert(SecondhandhouseNew sn);
	
	public List<SecondhandhouseNew> getByDate(Date date);

}
