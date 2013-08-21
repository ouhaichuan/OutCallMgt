package cn.info.platform.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import cn.info.platform.dao.BaseDao;
import cn.info.platform.mapper.BaseMapper;
import cn.info.platform.util.Page;

/**
 * ���ݿ⹫����Dao��ӿ�ʵ����
 * 
 * @author HCOU
 * 
 * @param <T>
 * @param <E>
 */
public class BaseDaoImpl<T, E> extends SqlSessionDaoSupport implements
		BaseDao<T, E> {
	private Class<E> mapperClass;

	@Autowired
	private SqlSessionFactory sessionFactory;

	/**
	 * ���ö�Ӧ��MapperClass
	 */
	public void setMapperClass(Class<E> mapperClass) {
		this.mapperClass = mapperClass;
	}

	/**
	 * �õ���Ӧ��Mapper����
	 */
	public E getMapper() {
		return sessionFactory.getConfiguration().getMapper(mapperClass,
				getSqlSession());
	}

	@SuppressWarnings("unchecked")
	public BaseMapper<T> getBaseMapper() {
		return (BaseMapper<T>) this.getMapper();
	}

	/**
	 * ����������ѯ��Ӧ�Ķ���
	 * 
	 * @param primaryKey
	 *            ���������
	 * @return ��ѯ��Ķ���
	 */
	public T findByID(Serializable primaryKey) {
		return this.getBaseMapper().findByID(primaryKey);
	}

	/**
	 * ���ݶ�������ɾ����Ӧ�Ķ���
	 * 
	 * @param primaryKey
	 *            �����
	 */
	public void deleteByID(Serializable primaryKey) {
		this.getBaseMapper().deleteByID(primaryKey);
	}

	/**
	 * ��ѯ���ж���ĳ���
	 * 
	 * @return ���ݵĳ���
	 */
	public int findAllObjLength() {
		return this.getBaseMapper().findAllObjLength();
	}

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @param page
	 *            Page����
	 * @return ���ز�ѯ��������
	 */
	public List<T> findByPage(Page<T> page) {
		return this.getBaseMapper().findByPage(page);
	}

	/**
	 * ����������ݿ����
	 * 
	 * @param t
	 *            Ҫ����Ķ���
	 */
	public void addObj(T t) {
		this.getBaseMapper().addObj(t);
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
		return this.getBaseMapper().findByParam(paramName, paramValue);
	}
}
