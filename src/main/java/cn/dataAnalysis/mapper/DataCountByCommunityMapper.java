package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.DataCountByCommunity;
import cn.dataAnalysis.model.DataCountByRegion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */
@Mapper
public interface DataCountByCommunityMapper {

    int insert(DataCountByCommunity dataCountByCommunity);

    List<DataCountByCommunity> getByParams(Map<String,Object> params);

    int countByParams(Map<String,Object> params);

    int insertList(List<DataCountByCommunity> dataCountByCommunityList);
}
