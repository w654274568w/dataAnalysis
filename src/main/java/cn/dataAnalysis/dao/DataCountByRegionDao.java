package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.DataCountByRegion;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/28.
 */
public interface DataCountByRegionDao {

    int insert(DataCountByRegion dataCountByRegion);

    List<DataCountByRegion> getByParams(Map<String,Object> params);

}
