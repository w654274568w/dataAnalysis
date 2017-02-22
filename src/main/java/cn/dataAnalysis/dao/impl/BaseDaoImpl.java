package cn.dataAnalysis.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.OptimisticLockingFailureException;

import cn.dataAnalysis.dao.BaseDao;
import cn.dataAnalysis.model.BaseEntity;

@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
public class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport
		implements BaseDao<T> {

	private Class<T> entityClass;
	private String mapperNamespace;

	public BaseDaoImpl() {
		setEntityClass((Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0]);
	}

	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public List<T> selectAll() throws DataAccessException {
		List<T> result = new ArrayList<T>();
		try {
			result = this.getSqlSession().selectList(
					getMapperNamespace() + "." + "selectAll");
		} catch (DataAccessException e) {
			throw e;
		}
		return result;
	}

	public Integer getTotalCount(Object params) throws DataAccessException {
		return getSqlSession().selectOne(
				getMapperNamespace() + "." + "getTotalCount", params);
	}

	@Override
	public boolean insertSelective(T entity) throws DataAccessException {
		return insert("insertSelective", entity);
	}

	@Override
	public boolean deleteByPrimaryKey(Integer pk) throws DataAccessException {
		boolean flag = false;
		try {
			flag = this.getSqlSession().delete(
					getMapperNamespace() + "." + "deleteByPrimaryKey", pk) > 0 ? true
					: false;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	@Override
	public T selectByPrimaryKey(Integer pk) throws DataAccessException {
		T result = null;
		try {
			result = (T) this.getSqlSession().selectOne(
					getMapperNamespace() + "." + "selectByPrimaryKey", pk);
		} catch (DataAccessException e) {
			throw e;
		}
		return result;
	}

	@Override
	public List<T> selectByEntity(T entity) throws DataAccessException {

		return select("selectByEntity", entity);
	}

	@Override
	public boolean delete(String id, T entity) throws DataAccessException {
		boolean flag = false;
		try {
			flag = this.getSqlSession().delete(getMapperNamespace() + "." + id,
					entity) > 0 ? true : false;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	public Integer getTotalCount(String id, Object params)
			throws DataAccessException {
		return getSqlSession().selectOne(getMapperNamespace() + "." + id,
				params);
	}

	@Override
	public boolean update(String id, T entity) throws DataAccessException {
		int rows = this.getSqlSession().update(getMapperNamespace() + "." + id,
					entity);
		if(rows == 0){//没有更新到数据，抛出乐观锁异常
			throw new OptimisticLockingFailureException("update "+id+" error;entity:"+entity);
		}
		return true;
	}
	@Override
	public boolean updateByEntity(String id, T entity) throws Exception {
		boolean flag = true;
		try {
			this.getSqlSession().update(getMapperNamespace() + "." + id,
					entity) ;
		} catch (Exception e) {
			flag = false;
			throw e;
		}
		return flag;
	}
	@Override
	public List<T> select(String id, Object params) throws DataAccessException {
		List<T> result = new ArrayList<T>();
		try {
			result = this.getSqlSession().selectList(
					getMapperNamespace() + "." + id, params);
		} catch (DataAccessException e) {
			throw e;
		}
		return result;
	}

	@Override
	public boolean updateByPrimaryKeySelective(T entity)
			throws DataAccessException {

		return update("updateByPrimaryKeySelective", entity);
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
		setMapperNamespace(entityClass.getName().substring(
				entityClass.getName().lastIndexOf(".") + 1));
	}

	public String getMapperNamespace() {
		return mapperNamespace;
	}

	public void setMapperNamespace(String className) {
		this.mapperNamespace = "com.rbao.east.mapper." + className + "Mapper";
	}

	@Override
	public boolean saveOrUpdate(T entity) throws DataAccessException {
		return saveOrUpdate("insertSelective", "updateByPrimaryKeySelective",
				entity);
	}

	@Override
	public boolean saveOrUpdate(String insertId, String updateId, T entity)
			throws DataAccessException {
		BeanWrapper beanWrapper = new BeanWrapperImpl(entity);
		Integer id = (Integer) beanWrapper.getPropertyValue("id");
		if (id == null || id <= 0) { // 添加
			return insert(insertId, entity);
		} else {
			return update(updateId, entity);
		}
	}

	@Override
	public boolean insert(String id, T entity) throws DataAccessException {
		return insertObj(id, entity);
	}

	

	@Override
	public boolean insertObj(String id, Object params)
			throws DataAccessException {
		boolean flag = false;
		try {
			flag = this.getSqlSession().insert(getMapperNamespace() + "." + id,
					params) > 0 ? true : false;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	@Override
	public T selectEntity(String id, Object params) throws DataAccessException {
		List<T> list = select(id, params);
		if (list != null && list.size() > 0)
			return (T) list.get(0);
		return null;
	}

	@Override
	public List selects(String id, Object params) throws DataAccessException {
		List result = new ArrayList();
		try {
			result = this.getSqlSession().selectList(
					getMapperNamespace() + "." + id, params);
		} catch (DataAccessException e) {
			throw e;
		}
		return result;
	}

	@Override
	public boolean deletes(String id, Object object) throws DataAccessException {
		boolean flag = false;
		try {
			flag = this.getSqlSession().delete(getMapperNamespace() + "." + id,
					object) > 0 ? true : false;
		} catch (DataAccessException e) {
			flag = false;
			throw e;
		}
		return flag;
	}

	@Override
	public Object getObject(String id, Object object) {
		return this.getSqlSession().selectOne(getMapperNamespace() + "." + id,
				object);
	}

	@Override
	public boolean updateByParam(String id, Object obj) throws DataAccessException {
		int rows = this.getSqlSession().update(getMapperNamespace() + "." + id, obj);
		if(rows == 0){//没有更新到数据，抛出乐观锁异常
			throw new OptimisticLockingFailureException("update "+id+" error;obj:"+obj);
		}
		return true;
	}

}
