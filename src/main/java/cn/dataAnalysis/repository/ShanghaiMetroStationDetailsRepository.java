package cn.dataAnalysis.repository;

import cn.dataAnalysis.model.ShanghaiMetroStationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by admin on 2017/4/6.
 */
public interface ShanghaiMetroStationDetailsRepository extends JpaRepository<ShanghaiMetroStationDetails, Long>,JpaSpecificationExecutor<ShanghaiMetroStationDetails> {



}
