package cn.info.platform.dao;

import java.util.List;

import cn.info.platform.entity.User;
import cn.info.platform.mapper.UserMapper;

/**
 * Userʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface UserDao extends BaseDao<User, UserMapper> {
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
	 * @return �û��б�
	 */
	List<User> findAllUsers();

	/**
	 * �����û�
	 * 
	 * @param user
	 *            �û�����
	 */
	void save_user(User user);

	/**
	 * ɾ���û�
	 * 
	 * @param id
	 *            �û�ID
	 */
	void del_user(int id);

	/**
	 * ����û�
	 * 
	 * @param user
	 *            �û�����
	 */
	void add_user(User user);

	/**
	 * ��֤�û�
	 * 
	 * @param user_name
	 *            �û���
	 * @return �����û�����
	 */
	User validate_user(String user_name);

	/**
	 * ��Ա��ͳ��������
	 * 
	 * @return
	 */
	List<User> staticsData();

	/**
	 * ͳ�Ƹ�������
	 * 
	 * @param userName
	 * @return
	 */
	List<User> staticsDataForSign(String userName);
}
