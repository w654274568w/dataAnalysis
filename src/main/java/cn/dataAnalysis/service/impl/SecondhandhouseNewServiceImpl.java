package cn.dataAnalysis.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.dataAnalysis.model.SecondhandhouseNew;
import cn.dataAnalysis.repository.SecondhandhouseNewRepository;
import cn.dataAnalysis.utils.DateUtils;
import cn.dataAnalysis.utils.JdbcQueryUtils;
import cn.dataAnalysis.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.dataAnalysis.service.SecondhandhouseNewService;

@Service
@Transactional
public class SecondhandhouseNewServiceImpl implements SecondhandhouseNewService {

    @Autowired
    private SecondhandhouseNewRepository secondhandhouseNewRepository;

    @Override
    public void insert(SecondhandhouseNew sn) {
        secondhandhouseNewRepository.save(sn);
    }

    @Override
    public List<SecondhandhouseNew> getByDate(Date begainDate, Date endDate) {
        return secondhandhouseNewRepository.findByBegainDateAndEndDate(begainDate, endDate);
    }

    @Override
    public int countAllData() {
        return secondhandhouseNewRepository.countAllData();
    }

    /**
     * 通过时间及区域名查找
     *
     * @param beginDate
     * @param endDate
     * @param regionName
     * @return
     */
    @Override
    public List<SecondhandhouseNew> findByRegionNameAndDate(Date beginDate, Date endDate, String regionName) {
        return secondhandhouseNewRepository.findByRegionNameAndDate(beginDate, endDate, regionName);
    }

    /**
     * JDBC方式原生查询对象信息
     *
     * @param begainDate
     * @param endDate
     * @return
     */
    @Override
    public List<SecondhandhouseNew> findByJdbc(Date begainDate, Date endDate) {
        try {
            //新建数据库连接
            Connection con = JdbcQueryUtils.getConnection();
            Statement statement = con.createStatement();
            //将输入的begainDate及endDate进行分析
            //先判断begainDate及endDate是否属于同一个月
            /*int compareMonth = DateUtils.getMonthSpace(begainDate, endDate);
            if (compareMonth > 0) {
            }*/
            String sql = "select * from secondhandhouse_new where capture_time > \"2017-06-01\"";
            ResultSet resultSet = statement.executeQuery(sql);
            //用于存储数据的列表
            List<SecondhandhouseNew> secondhandhouseNewList = new ArrayList<SecondhandhouseNew>();
            SecondhandhouseNew secondhandhouseNew = new SecondhandhouseNew();
            while (resultSet.next()){
                secondhandhouseNew.setId(resultSet.getInt("id"));
                if(StringUtils.isNotBlank(resultSet.getString("community_name"))){
                    secondhandhouseNew.setCommunityName(resultSet.getString("community_name"));
                }
                secondhandhouseNew.setDataId(resultSet.getLong("data_id"));
                secondhandhouseNewList.add(secondhandhouseNew);
            }
            return secondhandhouseNewList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
