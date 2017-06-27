package cn.dataAnalysis.service;

import cn.dataAnalysis.model.DataCountByDate;
import org.springframework.data.domain.Pageable;

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
    DataCountByDate save(DataCountByDate dataCountByDate);

    /**
     * 后台分页查询
     * @param map
     * @return
     */
    List<DataCountByDate> findForPage(Map<String,Object> map);

    int findForPageCountAll(Map<String,Object> map);

}
