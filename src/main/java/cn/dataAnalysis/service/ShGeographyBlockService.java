package cn.dataAnalysis.service;

import cn.dataAnalysis.model.ShGeographyBlock;

import java.util.List;

/**
 * Created by feng on 2017/7/11.
 */
public interface ShGeographyBlockService {

    int insertOne(ShGeographyBlock shGeographyBlock);

    int insertList(List<ShGeographyBlock> shGeographyBlocks);

}
