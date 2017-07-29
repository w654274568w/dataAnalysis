package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.DataCountByDate;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */
public interface DataCountByDateDao{

    List<DataCountByDate> getForPage(Map<String,Object> map);

    int getForPageCountAll(Map<String,Object> map);

    int save(DataCountByDate dataCountByDate);

    int deleteByParams(Map<String,Object> map);
}
