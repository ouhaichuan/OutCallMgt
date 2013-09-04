package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project_User;
import cn.info.platform.mapper.ProjectUserMapper;

/**
 * Project_Userʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface ProjectUserDao extends
		BaseDao<Project_User, ProjectUserMapper> {
	/**
	 * ��Ŀ���û�
	 * 
	 * @param project_User
	 */
	void add_user(Project_User project_User);

	/**
	 * ɾ���û�
	 * 
	 * @param project_User
	 */
	void del_user(int pro_id);

	/**
	 * ��ѯ�û�
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Project_User> findbound_user(int pro_id);

	/**
	 * ��ѯ��Ŀ�����������
	 * 
	 * @param pro_id
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
