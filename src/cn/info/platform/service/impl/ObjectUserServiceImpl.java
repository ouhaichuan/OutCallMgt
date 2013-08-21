package cn.info.platform.service.impl;

import java.util.List;
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
	public void add_user(Object_User object_User) {
		objectUserDao.add_user(object_User);
	}

	/**
	 * 删除用户
	 */
	public void del_user(int object_id) {
		objectUserDao.del_user(object_id);
	}

	/**
	 * 查询绑定用户
	 */
	public List<Object_User> findbound_user(int object_id) {
		return objectUserDao.findbound_user(object_id);
	}
}
