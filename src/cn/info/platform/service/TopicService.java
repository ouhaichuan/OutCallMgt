package cn.info.platform.service;

import java.util.List;
import cn.info.platform.entity.Topic;

/**
 * Topicʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface TopicService extends BaseService<Topic> {
	/**
	 * �����Ŀ
	 * 
	 * @param topic
	 */
	void add_topic(Topic topic);

	/**
	 * ������Ŀ
	 * 
	 * @param topic
	 */
	void save_topic(Topic topic);

	/**
	 * ɾ����Ŀ
	 * 
	 * @param id
	 */
	void del_topic(int id);

	/**
	 * �õ����е������Ŀ����Ŀ
	 * 
	 * @return ��Ŀ�б�
	 */
	List<Topic> findAllTopic();

	/**
	 * ��ѯ�����Ŀ����Ŀ
	 * 
	 * @return
	 */
	List<Topic> findTopicByProId(int pro_id);

	/**
	 * ����
	 * 
	 * @param topic
	 */
	void import_topic(Topic topic);

	/**
	 * �����������Ŀ
	 * 
	 * @param pro_id
	 */
	void del_topicByProId(int pro_id);
}
