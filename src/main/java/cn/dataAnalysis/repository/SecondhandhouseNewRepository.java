package cn.dataAnalysis.repository;

import cn.dataAnalysis.model.SecondhandhouseNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface SecondhandhouseNewRepository extends JpaRepository<SecondhandhouseNew, Long>,JpaSpecificationExecutor<SecondhandhouseNew> {

//    @Query(value = "select count(*) from secondhandhouse_new  t where  date_format(t.capture_time,\"%Y-%m-%d\") >= date_format(?1,\"%Y-%m-%d\") and date_format(t.capture_time,\"%Y-%m-%d\") <= date_format(?2,\"%Y-%m-%d\")" , nativeQuery = true)
    @Query(value = "select count(*) from secondhandhouse_new  t where  t.capture_time >= ?1 and t.capture_time <= ?2" , nativeQuery = true)
    List<SecondhandhouseNew> findByBegainDateAndEndDate(Date begainDate, Date endDate);

    @Query(value = "select count(*) from secondhandhouse_new  t where  t.capture_time >= ?1 and t.capture_time <= ?2" , nativeQuery = true)
    int countByBegainDateAndEndDate(Date begainDate, Date endDate);

    @Query(value = "select count(*) from secondhandhouse_new " , nativeQuery = true)
    int countAllData();


}
