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
	 * ���û�
	 */
	public void add_user(Map<String, Object> map) {
		objectUserDao.add_user(map);
	}

	/**
	 * ɾ���û�
	 */
	public void del_user(Map<String, Object> map) {
		objectUserDao.del_user(map);
	}

	/**
	 * ��ѯ���û�
	 */
	public List<Object_User> findbound_user(int object_id) {
		return objectUserDao.findbound_user(object_id);
	}

	/**
	 * ����objectidɾ������
	 */
	public void delObjByObjectId(int obj_id) {
		objectUserDao.delObjByObjectId(obj_id);
	}

	/**
	 * �õ�ɾ����ĳ���û��İ󶨺�������
	 */
	public int getCountsByUserName(Map<String, Object> map) {
		return objectUserDao.getCountsByUserName(map);
	}

	/**
	 * �õ�Ҫɾ������󶨵��û�
	 */
	public String getUserNameByObjectId(int object_id) {
		return objectUserDao.getUserNameByObjectId(object_id);
	}
}
