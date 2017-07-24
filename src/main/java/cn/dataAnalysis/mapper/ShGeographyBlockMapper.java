package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.ShGeographyBlock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by feng on 2017/7/11.
 */
@Mapper
public interface ShGeographyBlockMapper {

    int insertOne(ShGeographyBlock shGeographyBlock);

    int insertList(List<ShGeographyBlock> shGeographyBlocks);
}
