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
	 * 添加用户对象关联
	 * 
	 * @param map
	 */
	void add_user(Map<String, Object> map);

	/**
	 * 删除用户
	 */
	void del_user(Map<String, Object> map);

	/**
	 * 查询用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);

	/**
	 * 根据objectid删除号码
	 * 
	 * @param obj_id
	 */
	void delObjByObjectId(int obj_id);

	/**
	 * 得到删除后某个用户的绑定号码数量
	 * 
	 * @param user_name
	 * @return
	 */
	int getCountsByUserName(Map<String, Object> map);

	/**
	 * 得到要删除号码绑定的用户
	 * 
	 * @param object_id
	 * @return
	 */
	String getUserNameByObjectId(int object_id);
}
