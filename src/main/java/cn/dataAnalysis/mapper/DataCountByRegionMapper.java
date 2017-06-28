package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.model.DataCountByRegion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */
@Mapper
public interface DataCountByRegionMapper {

    int insert(DataCountByRegion dataCountByRegion);

}
