package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.SecondhandhouseNewDao;
import cn.dataAnalysis.mapper.SecondhandhouseNewMapper;
import cn.dataAnalysis.model.SecondhandhouseNew;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by feng on 2017/6/26.
 */
public class SecondhandhouseNewDaoImpl implements SecondhandhouseNewDao{

    @Autowired
    private SecondhandhouseNewMapper secondhandhouseNewMapper;

    @Override
    public void insert(SecondhandhouseNew sn) {
        secondhandhouseNewMapper.insert(sn);
    }
}
