package cn.dataAnalysis.service;


import cn.dataAnalysis.model.ShanghaiMetroStationDetails;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/6.
 */
public interface ShanghaiMetroStationDetailsService {

    ShanghaiMetroStationDetails save(ShanghaiMetroStationDetails shanghaiMetroStationDetails);

    List<ShanghaiMetroStationDetails> findAll();

    List<ShanghaiMetroStationDetails> findByMap(Map<String,Object> map);

}
