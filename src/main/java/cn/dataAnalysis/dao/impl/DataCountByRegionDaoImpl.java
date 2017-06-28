package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.DataCountByRegionDao;
import cn.dataAnalysis.mapper.DataCountByRegionMapper;
import cn.dataAnalysis.model.DataCountByRegion;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by feng on 2017/6/28.
 */
public class DataCountByRegionDaoImpl implements DataCountByRegionDao{

    @Autowired
    private DataCountByRegionMapper dataCountByRegionMapper;

    @Override
    public int insert(DataCountByRegion dataCountByRegion) {
        return dataCountByRegionMapper.insert(dataCountByRegion);
    }
}
