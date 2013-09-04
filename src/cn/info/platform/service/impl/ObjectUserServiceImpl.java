package cn.info.platform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.ObjectUserDao;
import cn.info.platform.entity.Object_User;
import cn.info.platform.service.ObjectUserService;

@Service
public class ObjectUserServiceImpl extends BaseServiceImpl<Object_User>
		implements ObjectUserService {
	private ObjectUserDao objectUserDao;

	@Autowired
	public ObjectUserServiceImpl(ObjectUserDao objectUserDao) {
		this.objectUserDao = objectUserDao;
		setBaseDao(objectUserDao);
	}

	/**
	 * 绑定用户
	 */
	public void add_user(Map<String, Object> map) {
		objectUserDao.add_user(map);
	}

	/**
	 * 删除用户
	 */
	public void del_user(Map<String, Object> map) {
		objectUserDao.del_user(map);
	}

	/**
	 * 查询绑定用户
	 */
	public List<Object_User> findbound_user(int object_id) {
		return objectUserDao.findbound_user(object_id);
	}

	/**
	 * 根据objectid删除号码
	 */
	public void delObjByObjectId(int obj_id) {
		objectUserDao.delObjByObjectId(obj_id);
	}

	/**
	 * 得到删除后某个用户的绑定号码数量
	 */
	public int getCountsByUserName(Map<String, Object> map) {
		return objectUserDao.getCountsByUserName(map);
	}

	/**
	 * 得到要删除号码绑定的用户
	 */
	public String getUserNameByObjectId(int object_id) {
		return objectUserDao.getUserNameByObjectId(object_id);
	}
}
