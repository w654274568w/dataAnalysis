package cn.dataAnalysis.repository;

import cn.dataAnalysis.model.SecondhandhouseOriginal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SecondhandhouseOriginalRepository extends JpaRepository<SecondhandhouseOriginal, Long>,JpaSpecificationExecutor<SecondhandhouseOriginal> {


    @Query(value = "select * from secondhandhouse_original  t where  t.capture_time >= ?1 and t.capture_time <= ?2" , nativeQuery = true)
    List<SecondhandhouseOriginal> findByCaptureTime(Date begainDate, Date endDate);
}
