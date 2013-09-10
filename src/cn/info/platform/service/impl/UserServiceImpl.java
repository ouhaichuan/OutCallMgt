package cn.info.platform.service.impl;

import java.util.List;
import java.util.Map;

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
	 * 用户登陆
	 * 
	 * @param user
	 *            用户对象
	 * @return 用户详情
	 */
	public User login(User user) {
		return userDao.login(user);
	}

	/**
	 * 得到所有的用户
	 * 
	 * @return 用户列表
	 */
	public List<User> findAllUsers(String search_txt) {
		return userDao.findAllUsers(search_txt);
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 *            用户对象
	 */
	public void save_user(User user) {
		userDao.save_user(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            用户ID
	 */
	public void del_user(int id) {
		userDao.del_user(id);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户对象
	 */
	public void add_user(User user) {
		userDao.add_user(user);
	}

	/**
	 * 验证用户
	 * 
	 * @param user_name
	 *            用户名
	 * @return 返回用户对象
	 */
	public User validate_user(String user_name) {
		return userDao.validate_user(user_name);
	}

	/**
	 * 按员工统计外呼情况
	 */
	public List<User> staticsData(Map<String, Object> map) {
		return userDao.staticsData(map);
	}

	/**
	 * 统计个人数据
	 */
	public List<User> staticsDataForSign(String userName) {
		return userDao.staticsDataForSign(userName);
	}

	/**
	 * 查询可以绑定的员工
	 */
	public List<User> findUserForPro() {
		return userDao.findUserForPro();
	}

	/**
	 * 导入用户
	 */
	public void import_user(User user) {
		userDao.import_user(user);
	}
}
