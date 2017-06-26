package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import cn.dataAnalysis.service.SecondhandhouseOriginalService;
import cn.dataAnalysis.service.ShanghaiMetroStationDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ShanghaiMetroStationDetailsServiceImpl implements ShanghaiMetroStationDetailsService {

	@Override
	public ShanghaiMetroStationDetails save(ShanghaiMetroStationDetails shanghaiMetroStationDetails) {
		return null;
	}

	@Override
	public List<ShanghaiMetroStationDetails> findAll() {
		return null;
	}
}
