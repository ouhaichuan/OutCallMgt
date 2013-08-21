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
	 * 添加用户对象关联
	 * 
	 * @param project_User
	 */
	void add_user(Object_User object_User);

	/**
	 * 删除用户
	 */
	void del_user(int object_id);

	/**
	 * 查询用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);
}
