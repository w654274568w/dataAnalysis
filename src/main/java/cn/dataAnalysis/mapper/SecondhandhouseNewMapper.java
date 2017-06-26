package cn.dataAnalysis.mapper;


import org.apache.ibatis.annotations.Mapper;

import cn.dataAnalysis.model.SecondhandhouseNew;

@Mapper
public interface SecondhandhouseNewMapper {

    public SecondhandhouseNew findById();

    public int insert(SecondhandhouseNew sn);

}
