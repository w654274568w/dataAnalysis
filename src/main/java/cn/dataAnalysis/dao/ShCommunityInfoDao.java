package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.ShCommunityInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
public interface ShCommunityInfoDao extends BaseDao<ShCommunityInfo>{

    int insert(ShCommunityInfo shCommunityInfo);

    List<ShCommunityInfo> getByParams(Map<String,Object> params);

    boolean update(ShCommunityInfo shCommunityInfo);

    int getCountByParams(Map<String,Object> params);
}
