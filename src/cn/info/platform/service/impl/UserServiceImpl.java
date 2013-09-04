package cn.info.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.UserDao;
import cn.info.platform.entity.User;
import cn.info.platform.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	private UserDao userDao;

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
		setBaseDao(userDao);
	}

	public User getUserByID(int userID) {
		return userDao.getUserByID(userID);
	}

	/**
	 * �û���½
	 * 
	 * @param user
	 *            �û�����
	 * @return �û�����
	 */
	public User login(User user) {
		return userDao.login(user);
	}

	/**
	 * �õ����е��û�
	 * 
	 * @return �û��б�
	 */
	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

	/**
	 * �����û�
	 * 
	 * @param user
	 *            �û�����
	 */
	public void save_user(User user) {
		userDao.save_user(user);
	}

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 *            �û�ID
	 */
	public void del_user(int id) {
		userDao.del_user(id);
	}

	/**
	 * ����û�
	 * 
	 * @param user
	 *            �û�����
	 */
	public void add_user(User user) {
		userDao.add_user(user);
	}

	/**
	 * ��֤�û�
	 * 
	 * @param user_name
	 *            �û���
	 * @return �����û�����
	 */
	public User validate_user(String user_name) {
		return userDao.validate_user(user_name);
	}

	/**
	 * ��Ա��ͳ��������
	 */
	public List<User> staticsData() {
		return userDao.staticsData();
	}

	/**
	 * ͳ�Ƹ�������
	 */
	public List<User> staticsDataForSign(String userName) {
		return userDao.staticsDataForSign(userName);
	}
}
