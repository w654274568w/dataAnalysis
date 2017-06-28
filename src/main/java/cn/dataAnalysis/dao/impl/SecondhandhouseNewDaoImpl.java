package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.SecondhandhouseNewDao;
import cn.dataAnalysis.mapper.SecondhandhouseNewMapper;
import cn.dataAnalysis.model.SecondhandhouseNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */

@Repository
public class SecondhandhouseNewDaoImpl implements SecondhandhouseNewDao{

    @Autowired
    private SecondhandhouseNewMapper secondhandhouseNewMapper;

    @Override
    public int getTotalCount() {
        return secondhandhouseNewMapper.countAllData();
    }

    @Override
    public void insert(SecondhandhouseNew sn) {
        secondhandhouseNewMapper.insert(sn);
    }

    @Override
    public List<SecondhandhouseNew> findByRegionNameAndDate(Map<String, Object> params) {
        return secondhandhouseNewMapper.findByRegionNameAndDate(params);
    }
}
