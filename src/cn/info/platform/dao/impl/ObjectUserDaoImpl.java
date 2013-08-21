package cn.info.platform.dao.impl;

import java.util.List;
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
	public void add_user(Object_User object_User) {
		this.getMapper().add_user(object_User);
	}

	/**
	 * ɾ���û�
	 */
	public void del_user(int object_id) {
		this.getMapper().del_user(object_id);
	}

	/**
	 * ��ѯ�û�
	 */
	public List<Object_User> findbound_user(int object_id) {
		return getMapper().findbound_user(object_id);
	}
}
