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
	 * ��ѯ����Project
	 */
	public List<Project> findAllProject() {
		return projectDao.findAllProject();
	}

	/**
	 * ������Ŀ
	 * 
	 * @param project
	 */
	public void save_pro(Project project) {
		projectDao.save_pro(project);
	}

	/**
	 * �����Ŀ
	 */
	public void add_pro(Project project) {
		projectDao.add_pro(project);
	}

	/**
	 * ɾ����Ŀ
	 * 
	 * @param id
	 */
	public void del_pro(int id) {
		projectDao.del_pro(id);
	}

	/**
	 * ��ѯ��Ӧ�û�������Ŀ
	 */
	public List<Project> findAllProjectByUserName(String user_name) {
		return projectDao.findAllProjectByUserName(user_name);
	}

	/**
	 * ������Ŀͳ��
	 */
	public List<Project> staticsData() {
		return projectDao.staticsData();
	}

	/**
	 * ������Ŀ״̬
	 */
	public void changestatepro(Map<String, Object> map) {
		projectDao.changestatepro(map);
	}

	/**
	 * ͳ�Ƹ�������
	 */
	public List<Project> staticsDataForSign(String userName) {
		return projectDao.staticsDataForSign(userName);
	}
}
