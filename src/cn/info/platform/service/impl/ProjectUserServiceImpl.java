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
	 * ���û�
	 */
	public void add_user(Project_User project_User) {
		projectUserDao.add_user(project_User);
	}

	/**
	 * ɾ���û�
	 */
	public void del_user(int pro_id) {
		projectUserDao.del_user(pro_id);
	}

	/**
	 * ��ѯ���û�
	 */
	public List<Project_User> findbound_user(int pro_id) {
		return projectUserDao.findbound_user(pro_id);
	}

	/**
	 * ��ѯ��Ŀ�����������
	 */
	public int findObjectNumByProId(int pro_id) {
		return projectUserDao.findObjectNumByProId(pro_id);
	}

	/**
	 * �����û�������Ŀ��ɾ���󶨼�¼
	 */
	public void delBindByMap(Map<String, Object> map) {
		projectUserDao.delBindByMap(map);
	}

	/**
	 * �����û���Ŀ�󶨱�İ���Ŀ
	 */
	public void updateBindByMap(Map<String, Object> map) {
		projectUserDao.updateBindByMap(map);
	}
}
