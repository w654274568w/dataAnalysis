package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.DataCountByDate;

import java.util.List;

/**
 * Created by feng on 2017/6/26.
 */
public interface DataCountByDateDao{

    public List<DataCountByDate> findForPage();
}
