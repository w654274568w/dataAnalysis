package cn.dataAnalysis.mapper;

import java.util.Date;
import java.util.List;

import cn.dataAnalysis.model.SecondhandhouseOriginal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecondhandhouseOriginalMapper {

    public SecondhandhouseOriginal getById(Integer id);

    public List<SecondhandhouseOriginal> getByDate(Date date);
}
