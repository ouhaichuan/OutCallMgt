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
	 * 添加用户项目关联
	 * 
	 * @param project_User
	 */
	void add_user(Project_User project_User);

	/**
	 * 删除用户
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
