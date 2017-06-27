package cn.dataAnalysis.dao;

import cn.dataAnalysis.common.page.PageModel;
import org.springframework.dao.DataAccessException;

import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public interface BaseDao<T>
{

	public Object getObject(String id, Object object);

	public boolean delete(String id, T entity) throws DataAccessException;

	public boolean deletes(String id, Object object) throws DataAccessException;

	public List<T> select(String id, Object params) throws DataAccessException;

	public List selects(String id, Object params) throws DataAccessException;

	public T selectEntity(String id, Object params) throws DataAccessException;

	public Integer getTotalCount(String id, Object params)
			throws DataAccessException;

	public PageModel getPage(String listId, String countId, Object params,
							 PageModel pageModel);

	public PageModel getPage(String listId, String countId, Map paramsMap);

	public PageModel getPage(String listId, Map paramsMap);

	public PageModel getPage(String listId, Object params, PageModel pageModel);

	public boolean insertSelective(T entity) throws DataAccessException;

	public boolean insert(String id, T entity) throws DataAccessException;

	public boolean insertObj(String id, Object params)
			throws DataAccessException;

	public boolean updateByPrimaryKeySelective(T entity)
			throws DataAccessException;

	public boolean update(String id, T entity) throws DataAccessException;

	public boolean deleteByPrimaryKey(Integer pk) throws DataAccessException;

	public T selectByPrimaryKey(Integer pk) throws DataAccessException;

	public List<T> selectAll() throws DataAccessException;

	public List<T> selectByEntity(T entity) throws DataAccessException;

	public boolean saveOrUpdate(T entity) throws DataAccessException;

	public boolean saveOrUpdate(String insertId, String updateId, T entity)
			throws DataAccessException;
	/**
	 * 根据实体类更新数据,只要语句成功执行(无论是否更新到行)即返回true,否则返回false
	 * 
	 * @param id
	 * @param entity
	 * @return
	 * @throws DataAccessException
	 */
	boolean updateByEntity(String id, T entity) throws Exception;
}
