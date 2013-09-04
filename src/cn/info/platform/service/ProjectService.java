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
	 * @param valueOf
	 */
	void del_pro(int id);

	/**
	 * ���ݵ�¼�û�����ѯ��Ӧ����Ŀ
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

	/**
	 * ͳ�Ƹ�������
	 * 
	 * @param userName
	 * @return
	 */
	List<Project> staticsDataForSign(String userName);
}
