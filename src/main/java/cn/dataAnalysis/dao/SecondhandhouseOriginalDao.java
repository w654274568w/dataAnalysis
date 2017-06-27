package cn.dataAnalysis.dao;

import cn.dataAnalysis.model.SecondhandhouseOriginal;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/27.
 */
public interface SecondhandhouseOriginalDao {

    List<SecondhandhouseOriginal> findByCaptureTime(Map<String,Object> map);

}
