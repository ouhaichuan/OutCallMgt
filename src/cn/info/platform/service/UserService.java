package cn.info.platform.service;

import java.util.List;

import cn.info.platform.entity.User;

/**
 * User实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface UserService extends BaseService<User> {
	User getUserByID(int userID);

	/**
	 * 用户登陆
	 * 
	 * @param user
	 *            用户对象
	 * @return 用户详情
	 */
	User login(User user);

	/**
	 * 得到所有的用户
	 * 
	 * @return 用户列表
	 */
	List<User> findAllUsers();

	/**
	 * 更新用户
	 * 
	 * @param user
	 *            用户对象
	 */
	void save_user(User user);

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            用户ID
	 */
	void del_user(int id);

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            用户对象
	 */
	void add_user(User user);

	/**
	 * 验证用户
	 * 
	 * @param user_name
	 *            用户名
	 * @return 返回用户对象
	 */
	User validate_user(String user_name);
}
