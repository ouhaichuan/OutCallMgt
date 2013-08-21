package cn.info.platform.mapper;

import java.util.List;

import cn.info.platform.entity.Project_User;

/**
 * 
 * @author HCOU
 * 
 */
public interface ProjectUserMapper extends BaseMapper<Project_User> {
	/**
	 * ����û���Ŀ����
	 * 
	 * @param project_User
	 */
	void add_user(Project_User project_User);

	/**
	 * ɾ���û�
	 */
	void del_user(int pro_id);

	/**
	 * ��ѯ�û�
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Project_User> findbound_user(int pro_id);
}
