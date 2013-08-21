package cn.info.platform.mapper;

import java.util.List;

import cn.info.platform.entity.User;

/**
 * 
 * @author HCOU
 * 
 */
public interface UserMapper extends BaseMapper<User> {
	/**
	 * 根据用户ID查询出用户对象
	 * 
	 * @param userID
	 *            用户ID
	 * @return 用户对象
	 */
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
	 * @return
	 */
	List<User> findAllUsers();

	void save_user(User user);

	void del_user(int user_id);

	void add_user(User user);

	User validate_user(String user_name);
}
