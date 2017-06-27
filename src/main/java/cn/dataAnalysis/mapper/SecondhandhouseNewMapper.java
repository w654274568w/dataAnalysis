package cn.dataAnalysis.mapper;


import org.apache.ibatis.annotations.Mapper;

import cn.dataAnalysis.model.SecondhandhouseNew;

@Mapper
public interface SecondhandhouseNewMapper {

    SecondhandhouseNew findById();

    int insert(SecondhandhouseNew sn);

    int countAllData();

}
