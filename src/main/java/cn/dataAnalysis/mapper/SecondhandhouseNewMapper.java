package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.SecondhandhouseNew;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecondhandhouseNewMapper {

    SecondhandhouseNew findById();

    int insert(SecondhandhouseNew sn);

    int countAllData();

}
