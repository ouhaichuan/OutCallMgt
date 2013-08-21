package cn.info.platform.service;

import java.util.List;
import cn.info.platform.entity.Object_User;

/**
 * Object_User实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface ObjectUserService extends BaseService<Object_User> {
	/**
	 * 绑定用户
	 */
	void add_user(Object_User object_User);

	/**
	 * 绑定用户
	 */
	void del_user(int object_id);

	/**
	 * 查询绑定用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);
}
