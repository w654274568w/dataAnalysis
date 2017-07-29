package cn.dataAnalysis.service;

import cn.dataAnalysis.model.DataCountByDate;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/6.
 */
public interface DataCountByDateService {

    /**
     * 保存
     * @param dataCountByDate
     */
    int save(DataCountByDate dataCountByDate);


    /**
     * 后台分页查询
     * @param map
     * @return
     */
    List<DataCountByDate> findForPage(Map<String,Object> map);

    int findForPageCountAll(Map<String,Object> map);

    int deleteByParams(Map<String,Object> map);
}
