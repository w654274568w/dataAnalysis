package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.SecondhandhouseNewDao;
import cn.dataAnalysis.mapper.SecondhandhouseNewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
