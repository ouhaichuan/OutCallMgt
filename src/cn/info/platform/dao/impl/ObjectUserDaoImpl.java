package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.ObjectUserDao;
import cn.info.platform.entity.Object_User;
import cn.info.platform.mapper.ObjectUserMapper;

/**
 * @author HCOU
 */
@Repository
public class ObjectUserDaoImpl extends
		BaseDaoImpl<Object_User, ObjectUserMapper> implements ObjectUserDao {
	public ObjectUserDaoImpl() {
		setMapperClass(ObjectUserMapper.class);
	}

	/**
	 * 绑定用户
	 */
	public void add_user(Map<String, Object> map) {
		this.getMapper().add_user(map);
	}

	/**
	 * 删除用户
	 */
	public void del_user(Map<String, Object> map) {
		this.getMapper().del_user(map);
	}

	/**
	 * 查询用户
	 */
	public List<Object_User> findbound_user(int object_id) {
		return this.getMapper().findbound_user(object_id);
	}

	/**
	 * 根据objectid删除号码
	 */
	public void delObjByObjectId(int obj_id) {
		this.getMapper().delObjByObjectId(obj_id);
	}

	/**
	 * 得到删除后某个用户的绑定号码数量
	 */
	public int getCountsByUserName(Map<String, Object> map) {
		return this.getMapper().getCountsByUserName(map);
	}

	/**
	 * 得到要删除号码绑定的用户
	 */
	public String getUserNameByObjectId(int object_id) {
		return this.getMapper().getUserNameByObjectId(object_id);
	}
}
