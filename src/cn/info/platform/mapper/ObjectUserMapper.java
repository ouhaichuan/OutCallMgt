package cn.info.platform.mapper;

import java.util.List;
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
	 * @param project_User
	 */
	void add_user(Object_User object_User);

	/**
	 * ɾ���û�
	 */
	void del_user(int object_id);

	/**
	 * ��ѯ�û�
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);
}
