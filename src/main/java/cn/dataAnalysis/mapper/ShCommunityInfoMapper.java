package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.ShCommunityInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/7/3.
 */
@Mapper
public interface ShCommunityInfoMapper {

    int insert(ShCommunityInfo shCommunityInfo);

    List<ShCommunityInfo> getByParams(Map<String,Object> params);

    boolean updateByPrimaryKey(ShCommunityInfo shCommunityInfo);
}
