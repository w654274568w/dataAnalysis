package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.ShanghaiMetroStationDetailsDao;
import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import cn.dataAnalysis.service.ShanghaiMetroStationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ShanghaiMetroStationDetailsServiceImpl implements ShanghaiMetroStationDetailsService {

	@Autowired
	private ShanghaiMetroStationDetailsDao shanghaiMetroStationDetailsDao;

	@Override
	public ShanghaiMetroStationDetails save(ShanghaiMetroStationDetails shanghaiMetroStationDetails) {
		return null;
	}

	@Override
	public List<ShanghaiMetroStationDetails> findAll() {
		return shanghaiMetroStationDetailsDao.findAll();
	}

	@Override
	public List<ShanghaiMetroStationDetails> findByMap(Map<String, Object> map) {
		return null;
	}
}
