package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

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
	 * @param search_txt
	 * 
	 * @return
	 */
	List<User> findAllUsers(String search_txt);

	/**
	 * 保存用户
	 * 
	 * @param user
	 */
	void save_user(User user);

	/**
	 * 删除用户
	 * 
	 * @param user_id
	 */
	void del_user(int user_id);

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	void add_user(User user);

	/**
	 * 验证用户
	 * 
	 * @param user_name
	 * @return
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
