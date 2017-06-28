package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.SecondhandhouseNew;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SecondhandhouseNewMapper {

    /*SecondhandhouseNew findById();*/

    int insert(SecondhandhouseNew sn);

    int countAllData();

    List<SecondhandhouseNew> findByRegionNameAndDate(Map<String,Object> params);

}
