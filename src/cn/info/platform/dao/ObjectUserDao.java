package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

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
	 * @param map
	 */
	void add_user(Map<String, Object> map);

	/**
	 * 删除用户
	 * 
	 * @param map
	 */
	void del_user(Map<String, Object> map);

	/**
	 * 查询用户
	 * 
	 * @param object_id
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
