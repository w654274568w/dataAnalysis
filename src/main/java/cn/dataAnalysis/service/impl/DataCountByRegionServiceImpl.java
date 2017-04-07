package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.repository.DataCountByRegionRepository;
import cn.dataAnalysis.service.DataCountByRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/4/7.
 */
@Service
public class DataCountByRegionServiceImpl implements DataCountByRegionService{

    @Autowired
    private DataCountByRegionRepository dataCountByRegionRepository;

    /**
     * 保存
     *
     * @param dataCountByRegion
     */
    @Override
    public DataCountByRegion save(DataCountByRegion dataCountByRegion) {
        return dataCountByRegionRepository.save(dataCountByRegion);
    }
}
