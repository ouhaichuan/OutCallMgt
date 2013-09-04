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
	 * ���û�
	 */
	public void add_user(Map<String, Object> map) {
		this.getMapper().add_user(map);
	}

	/**
	 * ɾ���û�
	 */
	public void del_user(Map<String, Object> map) {
		this.getMapper().del_user(map);
	}

	/**
	 * ��ѯ�û�
	 */
	public List<Object_User> findbound_user(int object_id) {
		return this.getMapper().findbound_user(object_id);
	}

	/**
	 * ����objectidɾ������
	 */
	public void delObjByObjectId(int obj_id) {
		this.getMapper().delObjByObjectId(obj_id);
	}

	/**
	 * �õ�ɾ����ĳ���û��İ󶨺�������
	 */
	public int getCountsByUserName(Map<String, Object> map) {
		return this.getMapper().getCountsByUserName(map);
	}

	/**
	 * �õ�Ҫɾ������󶨵��û�
	 */
	public String getUserNameByObjectId(int object_id) {
		return this.getMapper().getUserNameByObjectId(object_id);
	}
}
