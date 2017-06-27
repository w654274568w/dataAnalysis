package cn.dataAnalysis.service;


import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseOriginal;



public interface SecondhandhouseOriginalService {
	
	public SecondhandhouseOriginal getById(Integer id);
	
	public List<SecondhandhouseOriginal> findByCaptureTime(Map<String,Object> map);
}
