package cn.dataAnalysis.repository;

import cn.dataAnalysis.model.SecondhandhouseNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SecondhandhouseNewRepository extends JpaRepository<SecondhandhouseNew, Long>,JpaSpecificationExecutor<SecondhandhouseNew> {

    @Query(value = "select * from secondhandhouse_new  t where  t.capture_time >= ?1 and t.capture_time <= ?2" , nativeQuery = true)
    List<SecondhandhouseNew> findByBegainDateAndEndDate(Date begainDate, Date endDate);

    @Query(value = "select count(*) from secondhandhouse_new  t where  t.capture_time >= ?1 and t.capture_time <= ?2" , nativeQuery = true)
    int countByBegainDateAndEndDate(Date begainDate, Date endDate);

    @Query(value = "select count(*) from secondhandhouse_new " , nativeQuery = true)
    int countAllData();

    @Query(value = "select * from secondhandhouse_new  t where  t.capture_time >= ?1 and t.capture_time <= ?2 and t.region_name = ?3" , nativeQuery = true)
    List<SecondhandhouseNew> findByRegionNameAndDate(Date beginDate, Date endDate, String regionName);



}
