package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.DataCountByCommunityDao;
import cn.dataAnalysis.model.DataCountByCommunity;
import cn.dataAnalysis.service.DataCountByCommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/5.
 */
@Service
public class DataCountByCommunityServiceImpl implements DataCountByCommunityService {

    @Autowired
    private DataCountByCommunityDao dataCountByCommunityDao;

    @Override
    public int insert(DataCountByCommunity dataCountByCommunity) {
        return dataCountByCommunityDao.insert(dataCountByCommunity);
    }

    @Override
    public List<DataCountByCommunity> getByParams(Map<String, Object> params) {
        return dataCountByCommunityDao.getByParams(params);
    }

    @Override
    public int countByParams(Map<String, Object> params) {
        return dataCountByCommunityDao.countByParams(params);
    }

    @Override
    public int insertList(List<DataCountByCommunity> dataCountByCommunityList) {
        return dataCountByCommunityDao.insertList(dataCountByCommunityList);
    }
}
