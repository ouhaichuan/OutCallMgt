package cn.info.platform.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.dao.DataAccessException;

import cn.info.platform.util.Page;

/**
 * ���ݿ⹫����Dao��ӿ�
 * 
 * @author HCOU
 * 
 * @param <T>
 * @param <E>
 */
public interface BaseDao<T, E> {
	/**
	 * ���ö�Ӧ��MapperClass
	 * 
	 * @param mapperClass
	 *            Ҫ���õ�MapperClass
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	void setMapperClass(Class<E> mapperClass) throws DataAccessException;

	/**
	 * ��ȡ��Ӧ��Mapper
	 * 
	 * @return Mapper����
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	E getMapper() throws DataAccessException;

	/**
	 * ����������ѯ��Ӧ�Ķ���
	 * 
	 * @param primaryKey
	 *            ���������
	 * @return ��ѯ��Ķ���
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	T findByID(Serializable primaryKey) throws DataAccessException;

	/**
	 * ���ݶ�������ɾ����Ӧ�Ķ���
	 * 
	 * @param primaryKey
	 *            �����
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	void deleteByID(Serializable primaryKey) throws DataAccessException;

	/**
	 * ��ѯ���ж���ĳ���
	 * 
	 * @return ���ݵĳ���
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	int findAllObjLength() throws DataAccessException;

	/**
	 * ��ҳ��ѯ����
	 * 
	 * @param page
	 *            Page����
	 * @return ���ز�ѯ��������
	 */
	List<T> findByPage(Page<T> page) throws DataAccessException;

	/**
	 * ����������ݿ����
	 * 
	 * @param t
	 *            Ҫ����Ķ���
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	void addObj(T t) throws DataAccessException;

	/**
	 * ���ݶ�����ֶν��в�ѯ
	 * 
	 * @param paramName
	 *            Ҫ��ѯ���ֶ�
	 * @param paramValue
	 *            ���ֶζ�Ӧ��ֵ
	 * @return ��ѯ��������
	 * @throws DataAccessException
	 *             DataAccessException
	 */
	List<T> findByParam(String paramName, Serializable paramValue)
			throws DataAccessException;
}
