package cn.dataAnalysis.dao.impl;

import cn.dataAnalysis.dao.DataCountByDateDao;
import cn.dataAnalysis.model.DataCountByDate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by feng on 2017/6/26.
 */
@Repository
public class DataCountByDateImple implements DataCountByDateDao{

    @Override
    public List<DataCountByDate> findForPage() {
        return null;
    }
}
