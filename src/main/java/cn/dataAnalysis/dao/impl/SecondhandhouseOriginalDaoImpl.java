package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.SecondhandhouseOriginalDao;
import cn.dataAnalysis.mapper.SecondhandhouseOriginalMapper;
import cn.dataAnalysis.model.SecondhandhouseOriginal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/27.
 */

@Repository
public class SecondhandhouseOriginalDaoImpl implements SecondhandhouseOriginalDao{

    @Autowired
    private SecondhandhouseOriginalMapper secondhandhouseOriginalMapper;

    @Override
    public List<SecondhandhouseOriginal> findByCaptureTime(Map<String,Object> map) {
        return secondhandhouseOriginalMapper.findByCaptureTime(map);
    }
}
