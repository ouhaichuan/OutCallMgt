package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project;

/**
 * 
 * @author HCOU
 * 
 */
public interface ProjectMapper extends BaseMapper<Project> {
	/**
	 * ��ѯ����Project
	 * 
	 * @return Project ����
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
	void del_pro(int pro_id);

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
