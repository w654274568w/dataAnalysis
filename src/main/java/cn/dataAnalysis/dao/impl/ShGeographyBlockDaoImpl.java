package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.ShGeographyBlockDao;
import cn.dataAnalysis.mapper.ShGeographyBlockMapper;
import cn.dataAnalysis.model.ShGeographyBlock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by feng on 2017/7/11.
 */

@Repository
public class ShGeographyBlockDaoImpl implements ShGeographyBlockDao{

    @Autowired
    private ShGeographyBlockMapper shGeographyBlockMapper;

    @Override
    public int insertOne(ShGeographyBlock shGeographyBlock) {
        return shGeographyBlockMapper.insertOne(shGeographyBlock);
    }

    @Override
    public int insertList(List<ShGeographyBlock> shGeographyBlocks) {
        return shGeographyBlockMapper.insertList(shGeographyBlocks);
    }
}
