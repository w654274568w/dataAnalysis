package cn.dataAnalysis.service;

import cn.dataAnalysis.model.DataCountByCommunity;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/5.
 */
public interface DataCountByCommunityService {

    int insert(DataCountByCommunity dataCountByCommunity);

    List<DataCountByCommunity> getByParams(Map<String, Object> params);

    int countByParams(Map<String, Object> params);
}
