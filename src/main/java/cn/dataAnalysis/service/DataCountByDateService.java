package cn.dataAnalysis.service;

import cn.dataAnalysis.model.DataCountByDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
     * 后台分页查询数据
     * @param example
     * @param pageable
     * @return
     */
    Page<DataCountByDate> findForPage(DataCountByDate example, Pageable pageable);

}
