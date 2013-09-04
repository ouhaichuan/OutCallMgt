package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project;
import cn.info.platform.mapper.ProjectMapper;

/**
 * Projectʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface ProjectDao extends BaseDao<Project, ProjectMapper> {
	/**
	 * ��ѯ����Project
	 * 
	 * @return project����
	 */
	List<Project> findAllProject();

	/**
	 * ������Ŀ
	 * 
	 * @param project
	 */
	void save_pro(Project project);

	/**
	 * �����Ŀ
	 * 
	 * @param project
	 */
	void add_pro(Project project);

	/**
	 * ɾ����Ŀ
	 * 
	 * @param id
	 */
	void del_pro(int id);

	/**
	 * ��ѯ��Ӧ�û�������Ŀ
	 * 
	 * @param user_name
	 * @return
	 */
	List<Project> findAllProjectByUserName(String user_name);

	/**
	 * ������Ŀͳ��
	 * 
	 * @return
	 */
	List<Project> staticsData();

	/**
	 * ������Ŀ״̬
	 * 
	 * @param map
	 */
	void changestatepro(Map<String, Object> map);
}
