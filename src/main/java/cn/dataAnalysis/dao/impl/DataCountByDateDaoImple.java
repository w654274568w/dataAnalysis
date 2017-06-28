package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.DataCountByDateDao;
import cn.dataAnalysis.mapper.DataCountByDateMapper;
import cn.dataAnalysis.model.DataCountByDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */
@Repository
public class DataCountByDateDaoImple implements DataCountByDateDao{

    @Autowired
    private DataCountByDateMapper dataCountByDateMapper;

    @Override
    public List<DataCountByDate> getForPage(Map<String, Object> map) {
        return dataCountByDateMapper.getForPage(map);
    }

    @Override
    public int getForPageCountAll(Map<String, Object> map) {
        return dataCountByDateMapper.getForPageCountAll(map);
    }
}
