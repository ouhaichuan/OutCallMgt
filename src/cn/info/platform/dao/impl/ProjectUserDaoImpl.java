package cn.info.platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.ProjectUserDao;
import cn.info.platform.entity.Project_User;
import cn.info.platform.mapper.ProjectUserMapper;

/**
 * @author HCOU
 */
@Repository
public class ProjectUserDaoImpl extends
		BaseDaoImpl<Project_User, ProjectUserMapper> implements ProjectUserDao {
	public ProjectUserDaoImpl() {
		setMapperClass(ProjectUserMapper.class);
	}

	/**
	 * 绑定用户
	 */
	public void add_user(Project_User project_User) {
		this.getMapper().add_user(project_User);
	}

	/**
	 * 删除用户
	 */
	public void del_user(int pro_id) {
		this.getMapper().del_user(pro_id);
	}

	/**
	 * 查询用户
	 */
	public List<Project_User> findbound_user(int pro_id) {
		return getMapper().findbound_user(pro_id);
	}
}
