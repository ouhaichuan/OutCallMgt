package cn.info.platform.dao;

import java.util.List;
import cn.info.platform.entity.Project;
import cn.info.platform.mapper.ProjectMapper;

/**
 * Project实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface ProjectDao extends BaseDao<Project, ProjectMapper> {
	/**
	 * 查询所有Project
	 * 
	 * @return project数组
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
	void del_pro(int id);

	/**
	 * 查询相应用户名的项目
	 * 
	 * @param user_name
	 * @return
	 */
	List<Project> findAllProjectByUserName(String user_name);
}
