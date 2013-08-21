package cn.info.platform.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.info.platform.dao.BaseDao;
import cn.info.platform.mapper.BaseMapper;
import cn.info.platform.service.BaseService;
import cn.info.platform.util.Page;

/**
 * 业务公共类Service类接口
 * 
 * @author HCOU
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T, ? extends BaseMapper<T>> baseDao;

	/**
	 * 根据主键查询对应的对象
	 * 
	 * @param primaryKey
	 *            对象的主键
	 * @return 查询后的对象
	 */
	public T findByID(Serializable primaryKey) {
		return baseDao.findByID(primaryKey);
	}

	/**
	 * 根据对象主键删除对应的对象
	 * 
	 * @param primaryKey
	 *            对象的
	 */
	public void deleteByID(Serializable primaryKey) {
		baseDao.deleteByID(primaryKey);
	}

	/**
	 * 查询所有对象的长度
	 * 
	 * @return 数据的长度
	 */
	public int findAllObjLength() {
		return baseDao.findAllObjLength();
	}

	/**
	 * 分页查询对象
	 * 
	 * @param page
	 *            Page对象
	 * @return 返回查询出的数据
	 */
	public List<T> findByPage(Page<T> page) {
		return baseDao.findByPage(page);
	}

	/**
	 * 保存对象到数据库表中
	 * 
	 * @param t
	 *            要保存的对象
	 */
	public void addObj(T t) {
		baseDao.addObj(t);
	}

	/**
	 * 根据对象的字段进行查询
	 * 
	 * @param paramName
	 *            要查询的字段
	 * @param paramValue
	 *            该字段对应的值
	 * @return 查询到的数据
	 */
	public List<T> findByParam(String paramName, Serializable paramValue) {
		return baseDao.findByParam(paramName, paramValue);
	}

	public void setBaseDao(BaseDao<T, ? extends BaseMapper<T>> baseDao) {
		this.baseDao = baseDao;
	}
}
