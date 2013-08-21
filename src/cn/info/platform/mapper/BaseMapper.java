package cn.info.platform.mapper;

import java.io.Serializable;
import java.util.List;
import org.springframework.dao.DataAccessException;
import cn.info.platform.util.Page;

/**
 * ���ݿ⹫���ӿ���
 * 
 * @author HCOU
 * 
 * @param <T>
 */
public interface BaseMapper<T> {
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
	 * @throws DataAccessException
	 *             DataAccessException
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
