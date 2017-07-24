package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.DataCountByDateDao;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.service.DataCountByDateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/6.
 */
@Service
public class DataCountByDateServiceImpl implements DataCountByDateService{

    @Autowired
    private DataCountByDateDao dataCountByDateDao;

    /**
     * 保存
     *
     * @param dataCountByDate
     */
    @Override
    public int save(DataCountByDate dataCountByDate) {
        return dataCountByDateDao.save(dataCountByDate);
    }

    /**
     * 后台分页查询
     *
     * @param map
     * @return
     */
    @Override
    public List<DataCountByDate> findForPage(Map<String, Object> map) {
        return dataCountByDateDao.getForPage(map);
    }

    @Override
    public int findForPageCountAll(Map<String, Object> map) {
        return dataCountByDateDao.getForPageCountAll(map);
    }


}
