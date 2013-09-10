package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

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
	public List<Project> findAllProject(String search_txt) {
		return this.getMapper().findAllProject(search_txt);
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
	public List<Project> findAllProjectByUserName(Map<String, Object> map) {
		return this.getMapper().findAllProjectByUserName(map);
	}

	/**
	 * 根据项目统计
	 */
	public List<Project> staticsData(Map<String, Object> map) {
		return this.getMapper().staticsData(map);
	}

	/**
	 * 更改项目状态
	 */
	public void changestatepro(Map<String, Object> map) {
		this.getMapper().changestatepro(map);
	}

	/**
	 * 检查是否导入题目和号码
	 */
	public int checkPro(String pro_id) {
		return this.getMapper().checkPro(pro_id);
	}
}
