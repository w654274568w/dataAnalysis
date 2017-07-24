package cn.dataAnalysis.mapper;

import cn.dataAnalysis.model.DataCountByDate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by feng on 2017/6/26.
 */
@Mapper
public interface DataCountByDateMapper {

    List<DataCountByDate> getForPage(Map<String,Object> map);

    int getForPageCountAll(Map<String,Object> map);

    int insert(DataCountByDate dataCountByDate);

}
