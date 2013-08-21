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
	 * �����û�ID��ѯ���û�����
	 * 
	 * @param userID
	 *            �û�ID
	 * @return �û�����
	 */
	User getUserByID(int userID);

	/**
	 * �û���½
	 * 
	 * @param user
	 *            �û�����
	 * @return �û�����
	 */
	User login(User user);

	/**
	 * �õ����е��û�
	 * 
	 * @return
	 */
	List<User> findAllUsers();

	void save_user(User user);

	void del_user(int user_id);

	void add_user(User user);

	User validate_user(String user_name);
}
