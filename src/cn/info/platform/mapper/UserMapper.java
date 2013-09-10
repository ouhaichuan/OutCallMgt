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
	 * @param search_txt
	 * 
	 * @return
	 */
	List<User> findAllUsers(String search_txt);

	/**
	 * �����û�
	 * 
	 * @param user
	 */
	void save_user(User user);

	/**
	 * ɾ���û�
	 * 
	 * @param user_id
	 */
	void del_user(int user_id);

	/**
	 * ����û�
	 * 
	 * @param user
	 */
	void add_user(User user);

	/**
	 * ��֤�û�
	 * 
	 * @param user_name
	 * @return
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
