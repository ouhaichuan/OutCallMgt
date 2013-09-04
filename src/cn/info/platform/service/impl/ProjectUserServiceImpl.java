package cn.info.platform.service.impl;

import java.util.List;
import java.util.Map;

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

	/**
	 * 查询项目所属号码个数
	 */
	public int findObjectNumByProId(int pro_id) {
		return projectUserDao.findObjectNumByProId(pro_id);
	}

	/**
	 * 根据用户名和项目号删除绑定记录
	 */
	public void delBindByMap(Map<String, Object> map) {
		projectUserDao.delBindByMap(map);
	}

	/**
	 * 更新用户项目绑定表的绑定数目
	 */
	public void updateBindByMap(Map<String, Object> map) {
		projectUserDao.updateBindByMap(map);
	}
}
