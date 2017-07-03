package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.SecondhandhouseNew;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */
public interface SecondhandhouseNewDao{

    int getTotalCount();

    void insert(SecondhandhouseNew sn);

    List<SecondhandhouseNew> findByRegionNameAndDate(Map<String,Object> params);

    List<String> getAllCommunityName();

}
