package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.ShCommunityInfoDao;
import cn.dataAnalysis.model.ShCommunityInfo;
import cn.dataAnalysis.service.ShCommunityInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
@Service
public class ShCommunityInfoServiceImpl implements ShCommunityInfoService {

    @Autowired
    private ShCommunityInfoDao shCommunityInfoDao;

    @Override
    public int insert(ShCommunityInfo shCommunityInfo) {
        return shCommunityInfoDao.insert(shCommunityInfo);
    }

    @Override
    public List<ShCommunityInfo> getByParams(Map<String, Object> params) {
        return shCommunityInfoDao.getByParams(params);
    }

    @Override
    public boolean update(ShCommunityInfo shCommunityInfo) {
        return shCommunityInfoDao.update(shCommunityInfo);
    }

}
