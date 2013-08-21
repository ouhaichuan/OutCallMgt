package cn.info.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.ProjectUserDao;
import cn.info.platform.entity.Project_User;
import cn.info.platform.service.ProjectUserService;

@Service
public class ProjectUserServiceImpl extends BaseServiceImpl<Project_User>
		implements ProjectUserService {
	private ProjectUserDao projectUserDao;

	@Autowired
	public ProjectUserServiceImpl(ProjectUserDao projectUserDao) {
		this.projectUserDao = projectUserDao;
		setBaseDao(projectUserDao);
	}

	/**
	 * 绑定用户
	 */
	public void add_user(Project_User project_User) {
		projectUserDao.add_user(project_User);
	}

	/**
	 * 删除用户
	 */
	public void del_user(int pro_id) {
		projectUserDao.del_user(pro_id);
	}

	/**
	 * 查询绑定用户
	 */
	public List<Project_User> findbound_user(int pro_id) {
		return projectUserDao.findbound_user(pro_id);
	}
}
