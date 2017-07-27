package cn.dataAnalysis.service;


import cn.dataAnalysis.model.DataCountByRegion;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/6.
 */
public interface DataCountByRegionService {

    /**
     * 保存
     * @param dataCountByRegion
     */
    int save(DataCountByRegion dataCountByRegion);

    /**
     * 参数获取集合
     * @param params
     * @return
     */
    List<DataCountByRegion> getByParams(Map<String,Object> params);
}
