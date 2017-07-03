package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.DataCountByArea;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by feng on 2017/7/2.
 */
@Mapper
public interface DataCountByAreaMapper {

    DataCountByArea insert();
}
