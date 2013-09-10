package cn.info.platform.service;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project;

/**
 * Projectʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface ProjectService extends BaseService<Project> {
	/**
	 * �õ�����Project
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
	 * @param valueOf
	 */
	void del_pro(int id);

	/**
	 * ���ݵ�¼�û�����ѯ��Ӧ����Ŀ
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
	 * @param string
	 * @return
	 */
	int checkPro(String string);
}
