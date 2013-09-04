package cn.info.platform.dao.impl;

import java.util.List;

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
	 * 用户登陆
	 * 
	 * @param user
	 *            用户对象
	 * @return 用户详情
	 */
	public User login(User user) {
		return this.getMapper().login(user);
	}

	/**
	 * 得到所有的用户
	 * 
	 * @return 用户列表
	 */
	public List<User> findAllUsers() {
		return this.getMapper().findAllUsers();
	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 *            用户对象
	 */
	public void save_user(User user) {
		this.getMapper().save_user(user);
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            用户ID
	 */
	public void del_user(int id) {
		this.getMapper().del_user(id);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户对象
	 */
	public void add_user(User user) {
		this.getMapper().add_user(user);
	}

	/**
	 * 验证用户
	 * 
	 * @param user_name
	 *            用户名
	 * @return 返回用户对象
	 */
	public User validate_user(String user_name) {
		return this.getMapper().validate_user(user_name);
	}

	/**
	 * 按员工统计外呼情况
	 */
	public List<User> staticsData() {
		return this.getMapper().staticsData();
	}

	/**
	 * 统计个人数据
	 */
	public List<User> staticsDataForSign(String userName) {
		return this.getMapper().staticsDataForSign(userName);
	}
}
