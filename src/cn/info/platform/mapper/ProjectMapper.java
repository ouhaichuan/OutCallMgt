package cn.info.platform.mapper;

import java.util.List;
import cn.info.platform.entity.Project;

/**
 * 
 * @author HCOU
 * 
 */
public interface ProjectMapper extends BaseMapper<Project> {
	/**
	 * 查询所有Project
	 * 
	 * @return Project 数组
	 */
	List<Project> findAllProject();

	/**
	 * 更新项目
	 * 
	 * @param project
	 */
	void save_pro(Project project);

	/**
	 * 添加项目
	 * 
	 * @param project
	 */
	void add_pro(Project project);

	/**
	 * 删除项目
	 * 
	 * @param id
	 */
	void del_pro(int pro_id);

	/**
	 * 查询相应用户名的项目
	 * 
	 * @param user_name
	 * @return
	 */
	List<Project> findAllProjectByUserName(String user_name);
}
