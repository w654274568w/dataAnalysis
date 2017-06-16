package cn.dataAnalysis.service.impl;

import cn.dataAnalysis.model.DataCountByDate;
import cn.dataAnalysis.repository.DataCountByDateRepository;
import cn.dataAnalysis.service.DataCountByDateService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/4/6.
 */
@Service
public class DataCountByDateServiceImpl implements DataCountByDateService{

    @Autowired
    private DataCountByDateRepository dataCountByDateRepository;

    /**
     * 保存
     *
     * @param dataCountByDate
     */
    @Override
    public DataCountByDate save(DataCountByDate dataCountByDate) {
        return dataCountByDateRepository.save(dataCountByDate);
    }

    /**
     * 后台分页查询数据
     *
     * @param example
     * @param pageable
     * @return
     */
    @Override
    public Page<DataCountByDate> findForPage(DataCountByDate example, Pageable pageable) {
        return dataCountByDateRepository.findAll(new Specification<DataCountByDate>() {
            @Override
            public Predicate toPredicate(Root<DataCountByDate> root, CriteriaQuery<?> criteriaQuery,
                                         CriteriaBuilder criteriaBuilder) {
                List<Predicate> params = new ArrayList<Predicate>();
                /*if (null != example.getLoanDealerId()) {
                    Path<String> loanDealerIdPath = root.get("loanDealerId");
                    params.add(criteriaBuilder.equal(loanDealerIdPath, example.getLoanDealerId()));
                }*/
                criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
                Predicate[] predicates = new Predicate[params.size()];
                criteriaQuery.where(params.toArray(predicates));
                return null;
            }
        }, pageable);
    }
}
