package cn.dataAnalysis.repository;

import cn.dataAnalysis.model.DataCountByArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by admin on 2017/4/6.
 */
public interface DataCountByAreaRepository extends JpaRepository<DataCountByArea, Long>,JpaSpecificationExecutor<DataCountByArea> {


}
