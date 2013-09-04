package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Object_User;

/**
 * 
 * @author HCOU
 * 
 */
public interface ObjectUserMapper extends BaseMapper<Object_User> {
	/**
	 * ����û��������
	 * 
	 * @param map
	 */
	void add_user(Map<String, Object> map);

	/**
	 * ɾ���û�
	 */
	void del_user(Map<String, Object> map);

	/**
	 * ��ѯ�û�
	 * 
	 * @param pro_id
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
