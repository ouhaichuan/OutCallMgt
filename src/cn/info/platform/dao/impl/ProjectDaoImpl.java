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
	 * ��ѯ������Ŀ
	 */
	public List<Project> findAllProject() {
		return this.getMapper().findAllProject();
	}

	/**
	 * ������Ŀ
	 */
	public void save_pro(Project project) {
		this.getMapper().save_pro(project);
	}

	/**
	 * �����Ŀ
	 */
	public void add_pro(Project project) {
		this.getMapper().add_pro(project);
	}

	/**
	 * ɾ����Ŀ
	 */
	public void del_pro(int id) {
		this.getMapper().del_pro(id);
	}

	/**
	 * ��ѯ��Ӧ�û�������Ŀ
	 */
	public List<Project> findAllProjectByUserName(String user_name) {
		return this.getMapper().findAllProjectByUserName(user_name);
	}

	/**
	 * ������Ŀͳ��
	 */
	public List<Project> staticsData() {
		return this.getMapper().staticsData();
	}

	/**
	 * ������Ŀ״̬
	 */
	public void changestatepro(Map<String, Object> map) {
		this.getMapper().changestatepro(map);
	}
}
