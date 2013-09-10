package cn.info.platform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.info.platform.dao.ProjectDao;
import cn.info.platform.entity.Project;
import cn.info.platform.service.ProjectService;

@Service
public class ProjectServiceImpl extends BaseServiceImpl<Project> implements
		ProjectService {
	private ProjectDao projectDao;

	@Autowired
	public ProjectServiceImpl(ProjectDao projectDao) {
		this.projectDao = projectDao;
		setBaseDao(projectDao);
	}

	/**
	 * 查询所有Project
	 */
	public List<Project> findAllProject(String search_txt) {
		return projectDao.findAllProject(search_txt);
	}

	/**
	 * 更新项目
	 * 
	 * @param project
	 */
	public void save_pro(Project project) {
		projectDao.save_pro(project);
	}

	/**
	 * 添加项目
	 */
	public void add_pro(Project project) {
		projectDao.add_pro(project);
	}

	/**
	 * 删除项目
	 * 
	 * @param id
	 */
	public void del_pro(int id) {
		projectDao.del_pro(id);
	}

	/**
	 * 查询相应用户名的项目
	 */
	public List<Project> findAllProjectByUserName(Map<String, Object> map) {
		return projectDao.findAllProjectByUserName(map);
	}

	/**
	 * 根据项目统计
	 */
	public List<Project> staticsData(Map<String, Object> map) {
		return projectDao.staticsData(map);
	}

	/**
	 * 更改项目状态
	 */
	public void changestatepro(Map<String, Object> map) {
		projectDao.changestatepro(map);
	}

	/**
	 * 检查是否导入题目和号码
	 */
	public int checkPro(String pro_id) {
		return projectDao.checkPro(pro_id);
	}
}
