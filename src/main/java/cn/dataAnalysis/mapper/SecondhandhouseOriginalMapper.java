package cn.dataAnalysis.mapper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseOriginal;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SecondhandhouseOriginalMapper {

    SecondhandhouseOriginal getById(Integer id);

    List<SecondhandhouseOriginal> getByDate(Date date);

    List<SecondhandhouseOriginal> findByCaptureTime(Map<String,Object> map);
}
