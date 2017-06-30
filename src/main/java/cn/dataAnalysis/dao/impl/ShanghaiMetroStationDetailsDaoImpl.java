package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.ShanghaiMetroStationDetailsDao;
import cn.dataAnalysis.mapper.ShanghaiMetroStationDetailsMapper;
import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by feng on 2017/6/30.
 */
@Repository
public class ShanghaiMetroStationDetailsDaoImpl implements ShanghaiMetroStationDetailsDao{

    @Autowired
    private ShanghaiMetroStationDetailsMapper shanghaiMetroStationDetailsMapper;


    @Override
    public ShanghaiMetroStationDetails insert(ShanghaiMetroStationDetails shanghaiMetroStationDetails) {
        return shanghaiMetroStationDetailsMapper.insert(shanghaiMetroStationDetails);
    }

    @Override
    public List<ShanghaiMetroStationDetails> findAll() {
        return shanghaiMetroStationDetailsMapper.findAll();
    }


}
