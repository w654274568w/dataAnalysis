package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.dao.DataCountByRegionDao;
import cn.dataAnalysis.model.DataCountByRegion;
import cn.dataAnalysis.service.DataCountByRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/4/7.
 */
@Service
public class DataCountByRegionServiceImpl implements DataCountByRegionService{

    @Autowired
    private DataCountByRegionDao dataCountByRegionDao;

    /**
     * 保存
     *
     * @param dataCountByRegion
     */
    @Override
    public int save(DataCountByRegion dataCountByRegion) {
        return dataCountByRegionDao.insert(dataCountByRegion);
    }

    @Override
    public List<DataCountByRegion> getByParams(Map<String, Object> params) {
        List<DataCountByRegion> dataCountByRegionList = dataCountByRegionDao.getByParams(params);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd");
        for(DataCountByRegion dataCountByRegion : dataCountByRegionList){
            dataCountByRegion.getCaptureTime();
            System.out.println(dataCountByRegion.getCaptureTime());
        }
        return dataCountByRegionList;
    }
}
