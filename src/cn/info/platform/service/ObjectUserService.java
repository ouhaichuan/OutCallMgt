package cn.info.platform.service;

import java.util.List;
import java.util.Map;
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
	void add_user(Map<String, Object> map2);

	/**
	 * 删除
	 */
	void del_user(Map<String, Object> map);

	/**
	 * 查询绑定用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Object_User> findbound_user(int object_id);

	/**
	 * 根据objectid删除号码
	 */
	void delObjByObjectId(int obj_id);

	/**
	 * 得到删除后某个用户的绑定号码数量
	 * 
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
