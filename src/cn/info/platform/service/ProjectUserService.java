package cn.info.platform.service;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project_User;

/**
 * Project_Userʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface ProjectUserService extends BaseService<Project_User> {
	/**
	 * ���û�
	 */
	void add_user(Project_User project_User);

	/**
	 * ���û�
	 */
	void del_user(int pro_id);

	/**
	 * ��ѯ���û�
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Project_User> findbound_user(int pro_id);

	/**
	 * ������Ŀ��ѯ������������
	 * 
	 * @param pro_id
	 * 
	 * @return
	 */
	int findObjectNumByProId(int pro_id);

	/**
	 * �����û�������Ŀ��ɾ���󶨼�¼
	 * 
	 * @param map
	 */
	void delBindByMap(Map<String, Object> map);

	/**
	 * �����û���Ŀ�󶨱�İ���Ŀ
	 * 
	 * @param map
	 */
	void updateBindByMap(Map<String, Object> map);
}
