package cn.info.platform.dao;

import java.util.List;

import cn.info.platform.entity.Project_User;
import cn.info.platform.mapper.ProjectUserMapper;

/**
 * Project_User实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface ProjectUserDao extends
		BaseDao<Project_User, ProjectUserMapper> {
	/**
	 * 项目绑定用户
	 * 
	 * @param project_User
	 */
	void add_user(Project_User project_User);

	/**
	 * 删除用户
	 * 
	 * @param project_User
	 */
	void del_user(int pro_id);

	/**
	 * 查询用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Project_User> findbound_user(int pro_id);
}
