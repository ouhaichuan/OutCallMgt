package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Topic;

/**
 * 
 * @author HCOU
 * 
 */
public interface TopicMapper extends BaseMapper<Topic> {
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
	 * ����������Ŀ
	 * 
	 * @return
	 */
	List<Topic> findAllTopic();

	/**
	 * ������ĿID��ѯ��Ŀ
	 * 
	 * @param map
	 * @return
	 */
	List<Topic> findTopicByProId(Map<String, Object> map);

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
