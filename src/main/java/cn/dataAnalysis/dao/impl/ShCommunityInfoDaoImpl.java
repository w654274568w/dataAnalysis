package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.ShCommunityInfoDao;
import cn.dataAnalysis.mapper.ShCommunityInfoMapper;
import cn.dataAnalysis.model.ShCommunityInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
@Repository
public class ShCommunityInfoDaoImpl extends BaseDaoImpl<ShCommunityInfo> implements ShCommunityInfoDao{

    @Autowired
    private ShCommunityInfoMapper shCommunityInfoMapper;

    @Override
    public int insert(ShCommunityInfo shCommunityInfo) {
        return shCommunityInfoMapper.insert(shCommunityInfo);
    }

    @Override
    public List<ShCommunityInfo> getByParams(Map<String, Object> params) {
        return shCommunityInfoMapper.getByParams(params);
    }

    @Override
    public boolean update(ShCommunityInfo shCommunityInfo) {
        return shCommunityInfoMapper.update(shCommunityInfo);
    }


}
