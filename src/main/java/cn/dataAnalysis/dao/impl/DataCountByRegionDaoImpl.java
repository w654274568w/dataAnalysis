package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.DataCountByRegionDao;
import cn.dataAnalysis.mapper.DataCountByRegionMapper;
import cn.dataAnalysis.model.DataCountByRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by feng on 2017/6/28.
 */
@Repository
public class DataCountByRegionDaoImpl implements DataCountByRegionDao{

    @Autowired
    private DataCountByRegionMapper dataCountByRegionMapper;

    @Override
    public int insert(DataCountByRegion dataCountByRegion) {
        return dataCountByRegionMapper.insert(dataCountByRegion);
    }
}
