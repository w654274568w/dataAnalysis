package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.DataCountByRegionDao;
import cn.dataAnalysis.mapper.DataCountByRegionMapper;
import cn.dataAnalysis.model.DataCountByRegion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<DataCountByRegion> getByParams(Map<String, Object> params) {
        return dataCountByRegionMapper.getByParams(params);
    }

    @Override
    public int deleteByParams(Map<String, Object> map) {
        return dataCountByRegionMapper.deleteByParams(map);
    }
}
