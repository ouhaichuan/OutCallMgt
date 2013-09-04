package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Object_User;
import cn.info.platform.mapper.ObjectUserMapper;

/**
 * Object_Userʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface ObjectUserDao extends BaseDao<Object_User, ObjectUserMapper> {
	/**
	 * ��Ŀ���û�
	 * 
	 * @param map
	 */
	void add_user(Map<String, Object> map);

	/**
	 * ɾ���û�
	 * 
	 * @param map
	 */
	void del_user(Map<String, Object> map);

	/**
	 * ��ѯ�û�
	 * 
	 * @param object_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);

	/**
	 * ����objectidɾ������
	 * 
	 * @param obj_id
	 */
	void delObjByObjectId(int obj_id);

	/**
	 * �õ�ɾ����ĳ���û��İ󶨺�������
	 * 
	 * @param user_name
	 * @return
	 */
	int getCountsByUserName(Map<String, Object> map);

	/**
	 * �õ�Ҫɾ������󶨵��û�
	 * 
	 * @param object_id
	 * @return
	 */
	String getUserNameByObjectId(int object_id);
}
