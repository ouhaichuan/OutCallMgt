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
	 * @param search_txt
	 * 
	 * @return project����
	 */
	List<Project> findAllProject(String search_txt);

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
	 * @param map
	 * @return
	 */
	List<Project> findAllProjectByUserName(Map<String, Object> map);

	/**
	 * ������Ŀͳ��
	 * 
	 * @param map
	 * 
	 * @return
	 */
	List<Project> staticsData(Map<String, Object> map);

	/**
	 * ������Ŀ״̬
	 * 
	 * @param map
	 */
	void changestatepro(Map<String, Object> map);

	/**
	 * ����Ƿ�����Ŀ�ͺ���
	 * 
	 * @param pro_id
	 * @return
	 */
	int checkPro(String pro_id);
}
