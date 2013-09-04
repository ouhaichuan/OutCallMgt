package cn.info.platform.service;

import java.util.List;
import java.util.Map;
import cn.info.platform.entity.Object_User;

/**
 * Object_Userʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface ObjectUserService extends BaseService<Object_User> {
	/**
	 * ���û�
	 */
	void add_user(Map<String, Object> map2);

	/**
	 * ɾ��
	 */
	void del_user(Map<String, Object> map);

	/**
	 * ��ѯ���û�
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);

	/**
	 * ����objectidɾ������
	 */
	void delObjByObjectId(int obj_id);

	/**
	 * �õ�ɾ����ĳ���û��İ󶨺�������
	 * 
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
