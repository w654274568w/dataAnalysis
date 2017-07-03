package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.DataCountByAreaDao;
import cn.dataAnalysis.mapper.DataCountByAreaMapper;
import cn.dataAnalysis.model.DataCountByArea;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.service.DataCountByAreaService;
import cn.dataAnalysis.service.DataCountByDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/4/18.
 */
@Service
public class DataCountByAreaServiceImpl implements DataCountByAreaService{

    @Autowired
    private DataCountByAreaDao dataCountByAreaDao;

    /**
     * 保存
     *
     * @param dataCountByArea
     */
    @Override
    public DataCountByArea save(DataCountByArea dataCountByArea) {
        return dataCountByAreaDao.insert(dataCountByArea);
    }
}
