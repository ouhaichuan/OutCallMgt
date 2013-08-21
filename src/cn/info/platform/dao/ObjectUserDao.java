package cn.info.platform.dao;

import java.util.List;
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
	 * @param object_User
	 */
	void add_user(Object_User object_User);

	/**
	 * ɾ���û�
	 * 
	 * @param object_id
	 */
	void del_user(int object_id);

	/**
	 * ��ѯ�û�
	 * 
	 * @param object_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);
}
