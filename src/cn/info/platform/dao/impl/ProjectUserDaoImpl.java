package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

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

	/**
	 * 查询项目所属号码个数
	 */
	public int findObjectNumByProId(int pro_id) {
		return this.getMapper().findObjectNumByProId(pro_id);
	}

	/**
	 * 根据用户名和项目号删除绑定记录
	 */
	public void delBindByMap(Map<String, Object> map) {
		this.getMapper().delBindByMap(map);
	}

	/**
	 * 更新用户项目绑定表的绑定数目
	 */
	public void updateBindByMap(Map<String, Object> map) {
		this.getMapper().updateBindByMap(map);
	}
}
