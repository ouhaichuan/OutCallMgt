package cn.info.platform.mapper;

import java.util.List;
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
	 * @param pro_id
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
