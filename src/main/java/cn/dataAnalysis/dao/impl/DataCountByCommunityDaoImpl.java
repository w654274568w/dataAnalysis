package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.DataCountByCommunityDao;
import cn.dataAnalysis.mapper.DataCountByCommunityMapper;
import cn.dataAnalysis.model.DataCountByCommunity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/5.
 */
@Repository
public class DataCountByCommunityDaoImpl implements DataCountByCommunityDao{

    @Autowired
    private DataCountByCommunityMapper dataCountByCommunityMapper;

    @Override
    public int insert(DataCountByCommunity dataCountByCommunity) {
        return dataCountByCommunityMapper.insert(dataCountByCommunity);
    }

    @Override
    public List<DataCountByCommunity> getByParams(Map<String, Object> params) {
        return dataCountByCommunityMapper.getByParams(params);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return dataCountByCommunityMapper.countByParams(params);
    }

    @Override
    public int insertList(List<DataCountByCommunity> dataCountByCommunityList) {
        return dataCountByCommunityMapper.insertList(dataCountByCommunityList);
    }
}
