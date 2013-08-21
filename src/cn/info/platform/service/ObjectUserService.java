package cn.info.platform.service;

import java.util.List;
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
	void add_user(Object_User object_User);

	/**
	 * ���û�
	 */
	void del_user(int object_id);

	/**
	 * ��ѯ���û�
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);
}
