package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.DataCountByArea;
import cn.dataAnalysis.model.DataCountByMetroStation;
import cn.dataAnalysis.repository.DataCountByAreaRepository;
import cn.dataAnalysis.repository.DataCountByMetroStationRepository;
import cn.dataAnalysis.service.DataCountByAreaService;
import cn.dataAnalysis.service.DataCountByMetroStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/4/18.
 */
@Service
public class DataCountByMetroStationServiceImpl implements DataCountByMetroStationService{

    @Autowired
    private DataCountByMetroStationRepository dataCountByMetroStationRepository;
    /**
     * 保存
     *
     * @param dataCountByMetroStation
     */
    @Override
    public DataCountByMetroStation save(DataCountByMetroStation dataCountByMetroStation) {
        return dataCountByMetroStationRepository.save(dataCountByMetroStation);
    }
}
