package cn.info.platform.service.impl;

import java.io.Serializable;
import java.util.List;

import cn.info.platform.dao.BaseDao;
import cn.info.platform.mapper.BaseMapper;
import cn.info.platform.service.BaseService;
import cn.info.platform.util.Page;

/**
 * ҵ�񹫹���Service��ӿ�
 * 
 * @author HCOU
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	private BaseDao<T, ? extends BaseMapper<T>> baseDao;

	/**
	 * ����������ѯ��Ӧ�Ķ���
	 * 
	 * @param primaryKey
	 *            ���������
	 * @return ��ѯ��Ķ���
	 */
	public T findByID(Serializable primaryKey) {
		return baseDao.findByID(primaryKey);
	}

	/**
	 * ���ݶ�������ɾ����Ӧ�Ķ���
	 * 
	 * @param primaryKey
	 *            �����
	 */
	public void deleteByID(Serializable primaryKey) {
		baseDao.deleteByID(primaryKey);
	}

	/**
	 * ��ѯ���ж���ĳ���
	 * 
	 * @return ���ݵĳ���
	 */
	public int findAllObjLength() {
		return baseDao.findAllObjLength();
	}

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @param page
	 *            Page����
	 * @return ���ز�ѯ��������
	 */
	public List<T> findByPage(Page<T> page) {
		return baseDao.findByPage(page);
	}

	/**
	 * ����������ݿ����
	 * 
	 * @param t
	 *            Ҫ����Ķ���
	 */
	public void addObj(T t) {
		baseDao.addObj(t);
	}

	/**
	 * ���ݶ�����ֶν��в�ѯ
	 * 
	 * @param paramName
	 *            Ҫ��ѯ���ֶ�
	 * @param paramValue
	 *            ���ֶζ�Ӧ��ֵ
	 * @return ��ѯ��������
	 */
	public List<T> findByParam(String paramName, Serializable paramValue) {
		return baseDao.findByParam(paramName, paramValue);
	}

	public void setBaseDao(BaseDao<T, ? extends BaseMapper<T>> baseDao) {
		this.baseDao = baseDao;
	}
}
