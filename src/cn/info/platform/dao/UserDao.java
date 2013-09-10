package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.User;
import cn.info.platform.mapper.UserMapper;

/**
 * User实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface UserDao extends BaseDao<User, UserMapper> {
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
	 * @param search_txt 
	 * 
	 * @return 用户列表
	 */
	List<User> findAllUsers(String search_txt);

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

	/**
	 * 按员工统计外呼情况
	 * @param map 
	 * 
	 * @return
	 */
	List<User> staticsData(Map<String, Object> map);

	/**
	 * 统计个人数据
	 * 
	 * @param userName
	 * @return
	 */
	List<User> staticsDataForSign(String userName);

	/**
	 * 查询可以绑定的员工
	 * 
	 * @return
	 */
	List<User> findUserForPro();

	/**
	 * 导入用户
	 * 
	 * @param user
	 */
	void import_user(User user);
}
