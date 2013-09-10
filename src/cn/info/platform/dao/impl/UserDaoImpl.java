package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.UserDao;
import cn.info.platform.entity.User;
import cn.info.platform.mapper.UserMapper;

/**
 * @author HCOU
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User, UserMapper> implements
		UserDao {
	public UserDaoImpl() {
		setMapperClass(UserMapper.class);
	}

	public User getUserByID(int userID) {
		return this.getMapper().getUserByID(userID);
	}

	/**
	 * �û���½
	 * 
	 * @param user
	 *            �û�����
	 * @return �û�����
	 */
	public User login(User user) {
		return this.getMapper().login(user);
	}

	/**
	 * �õ����е��û�
	 * 
	 * @return �û��б�
	 */
	public List<User> findAllUsers(String search_txt) {
		return this.getMapper().findAllUsers(search_txt);
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 *            �û�����
	 */
	public void save_user(User user) {
		this.getMapper().save_user(user);
	}

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 *            �û�ID
	 */
	public void del_user(int id) {
		this.getMapper().del_user(id);
	}

	/**
	 * ����û�
	 * 
	 * @param user
	 *            �û�����
	 */
	public void add_user(User user) {
		this.getMapper().add_user(user);
	}

	/**
	 * ��֤�û�
	 * 
	 * @param user_name
	 *            �û���
	 * @return �����û�����
	 */
	public User validate_user(String user_name) {
		return this.getMapper().validate_user(user_name);
	}

	/**
	 * ��Ա��ͳ��������
	 */
	public List<User> staticsData(Map<String, Object> map) {
		return this.getMapper().staticsData(map);
	}

	/**
	 * ͳ�Ƹ�������
	 */
	public List<User> staticsDataForSign(String userName) {
		return this.getMapper().staticsDataForSign(userName);
	}

	/**
	 * ��ѯ���԰󶨵�Ա��
	 */
	public List<User> findUserForPro() {
		return this.getMapper().findUserForPro();
	}

	/**
	 * �����û�
	 */
	public void import_user(User user) {
		this.getMapper().import_user(user);
	}
}
