package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import cn.dataAnalysis.repository.ShanghaiMetroStationDetailsRepository;
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

	@Autowired
	private ShanghaiMetroStationDetailsRepository shanghaiMetroStationDetailsRepository;

	@Override
	public ShanghaiMetroStationDetails save(ShanghaiMetroStationDetails shanghaiMetroStationDetails) {
		return shanghaiMetroStationDetailsRepository.save(shanghaiMetroStationDetails);
	}
}
