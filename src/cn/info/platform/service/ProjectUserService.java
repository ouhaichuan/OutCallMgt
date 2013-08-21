package cn.info.platform.service;

import java.util.List;

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
}
