package cn.dataAnalysis.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.dataAnalysis.model.SecondhandhouseOriginal;

@Mapper
public interface SecondhandhouseOriginalMapper {

    public SecondhandhouseOriginal getById(Integer id);

    public List<SecondhandhouseOriginal> getByDate(Date date);
}
