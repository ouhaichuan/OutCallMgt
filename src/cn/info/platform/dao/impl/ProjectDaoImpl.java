package cn.info.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.info.platform.dao.ProjectDao;
import cn.info.platform.entity.Project;
import cn.info.platform.mapper.ProjectMapper;

/**
 * @author HCOU
 */
@Repository
public class ProjectDaoImpl extends BaseDaoImpl<Project, ProjectMapper>
		implements ProjectDao {
	public ProjectDaoImpl() {
		setMapperClass(ProjectMapper.class);
	}

	/**
	 * 查询所有项目
	 */
	public List<Project> findAllProject() {
		return this.getMapper().findAllProject();
	}

	/**
	 * 更新项目
	 */
	public void save_pro(Project project) {
		this.getMapper().save_pro(project);
	}

	/**
	 * 添加项目
	 */
	public void add_pro(Project project) {
		this.getMapper().add_pro(project);
	}

	/**
	 * 删除项目
	 */
	public void del_pro(int id) {
		this.getMapper().del_pro(id);
	}

	/**
	 * 查询相应用户名的项目
	 */
	public List<Project> findAllProjectByUserName(String user_name) {
		return this.getMapper().findAllProjectByUserName(user_name);
	}
}
