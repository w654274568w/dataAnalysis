package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.ShanghaiMetroStationDetails;

import java.util.List;

/**
 * Created by feng on 2017/6/30.
 */
public interface ShanghaiMetroStationDetailsDao {

    ShanghaiMetroStationDetails insert(ShanghaiMetroStationDetails shanghaiMetroStationDetails);

    List<ShanghaiMetroStationDetails> findAll();
}
