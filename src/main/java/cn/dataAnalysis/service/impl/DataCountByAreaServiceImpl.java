package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.DataCountByArea;
import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.repository.DataCountByAreaRepository;
import cn.dataAnalysis.service.DataCountByAreaService;
import cn.dataAnalysis.service.DataCountByDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 2017/4/18.
 */
@Service
public class DataCountByAreaServiceImpl implements DataCountByAreaService{

    @Autowired
    private DataCountByAreaRepository dataCountByAreaRepository;
    /**
     * 保存
     *
     * @param dataCountByArea
     */
    @Override
    public DataCountByArea save(DataCountByArea dataCountByArea) {
        return dataCountByAreaRepository.save(dataCountByArea);
    }
}
