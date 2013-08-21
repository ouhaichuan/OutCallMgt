package cn.info.platform.dao;

import java.util.List;
import cn.info.platform.entity.Object_User;
import cn.info.platform.mapper.ObjectUserMapper;

/**
 * Object_User实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface ObjectUserDao extends BaseDao<Object_User, ObjectUserMapper> {
	/**
	 * 项目绑定用户
	 * 
	 * @param object_User
	 */
	void add_user(Object_User object_User);

	/**
	 * 删除用户
	 * 
	 * @param object_id
	 */
	void del_user(int object_id);

	/**
	 * 查询用户
	 * 
	 * @param object_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);
}
