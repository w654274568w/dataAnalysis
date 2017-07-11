package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.ShGeographyBlockDao;
import cn.dataAnalysis.model.ShGeographyBlock;
import cn.dataAnalysis.service.ShGeographyBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by feng on 2017/7/11.
 */
@Service
public class ShGeographyBlockServiceImpl implements ShGeographyBlockService{

    @Autowired
    private ShGeographyBlockDao shGeographyBlockDao;

    @Override
    public int insertOne(ShGeographyBlock shGeographyBlock) {
        return shGeographyBlockDao.insertOne(shGeographyBlock);
    }

    @Override
    public int insertList(List<ShGeographyBlock> shGeographyBlocks) {
        return shGeographyBlockDao.insertList(shGeographyBlocks);
    }
}
