package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

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
	 * @param search_txt 
	 * 
	 * @return �û��б�
	 */
	List<User> findAllUsers(String search_txt);

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
	 * @param map 
	 * 
	 * @return
	 */
	List<User> staticsData(Map<String, Object> map);

	/**
	 * ͳ�Ƹ�������
	 * 
	 * @param userName
	 * @return
	 */
	List<User> staticsDataForSign(String userName);

	/**
	 * ��ѯ���԰󶨵�Ա��
	 * 
	 * @return
	 */
	List<User> findUserForPro();

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	void import_user(User user);
}
