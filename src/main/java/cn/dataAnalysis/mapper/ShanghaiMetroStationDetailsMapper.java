package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by feng on 2017/6/30.
 */
@Mapper
public interface ShanghaiMetroStationDetailsMapper {

    ShanghaiMetroStationDetails insert(ShanghaiMetroStationDetails shanghaiMetroStationDetails);

    List<ShanghaiMetroStationDetails> findAll();
}
