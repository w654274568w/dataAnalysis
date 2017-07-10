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

    List<SecondhandhouseNew> getByParams(Map<String,Object> params);

    int getCountByParams(Map<String,Object> map);

    List<String> getAllCommunityName();




}
