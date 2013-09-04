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
	 * ���û�
	 */
	public void add_user(Project_User project_User) {
		this.getMapper().add_user(project_User);
	}

	/**
	 * ɾ���û�
	 */
	public void del_user(int pro_id) {
		this.getMapper().del_user(pro_id);
	}

	/**
	 * ��ѯ�û�
	 */
	public List<Project_User> findbound_user(int pro_id) {
		return getMapper().findbound_user(pro_id);
	}

	/**
	 * ��ѯ��Ŀ�����������
	 */
	public int findObjectNumByProId(int pro_id) {
		return this.getMapper().findObjectNumByProId(pro_id);
	}

	/**
	 * �����û�������Ŀ��ɾ���󶨼�¼
	 */
	public void delBindByMap(Map<String, Object> map) {
		this.getMapper().delBindByMap(map);
	}

	/**
	 * �����û���Ŀ�󶨱�İ���Ŀ
	 */
	public void updateBindByMap(Map<String, Object> map) {
		this.getMapper().updateBindByMap(map);
	}
}
