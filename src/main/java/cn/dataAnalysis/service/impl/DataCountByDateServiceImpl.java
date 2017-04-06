package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.repository.DataCountByDateRepository;
import cn.dataAnalysis.service.DataCountByDateService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by admin on 2017/4/6.
 */
public class DataCountByDateServiceImpl implements DataCountByDateService{

    @Autowired
    private DataCountByDateRepository dataCountByDateRepository;

    /**
     * 保存
     *
     * @param dataCountByDate
     */
    @Override
    public DataCountByDate save(DataCountByDate dataCountByDate) {
        return dataCountByDateRepository.save(dataCountByDate);
    }


}
