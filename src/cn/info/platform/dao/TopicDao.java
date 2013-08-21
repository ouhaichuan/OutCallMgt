package cn.info.platform.dao;

import java.util.List;
import cn.info.platform.entity.Topic;
import cn.info.platform.mapper.TopicMapper;

/**
 * Topicʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface TopicDao extends BaseDao<Topic, TopicMapper> {

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
	 * ��ѯ������Ŀ
	 * 
	 * @return
	 */
	List<Topic> findAllTopic();

	/**
	 * ��ѯ�����Ŀ����Ŀ
	 * 
	 * @return
	 */
	List<Topic> findTopicByProId(int pro_id);
}
