package cn.info.platform.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.info.platform.dao.TopicDao;
import cn.info.platform.entity.Topic;
import cn.info.platform.mapper.TopicMapper;

/**
 * @author HCOU
 */
@Repository
public class TopicDaoImpl extends BaseDaoImpl<Topic, TopicMapper> implements
		TopicDao {
	public TopicDaoImpl() {
		setMapperClass(TopicMapper.class);
	}

	/**
	 * �����Ŀ
	 */
	public void add_topic(Topic topic) {
		this.getMapper().add_topic(topic);
	}

	/**
	 * ������Ŀ
	 */
	public void save_topic(Topic topic) {
		this.getMapper().save_topic(topic);
	}

	/**
	 * ɾ����Ŀ
	 */
	public void del_topic(int id) {
		this.getMapper().del_topic(id);
	}

	/**
	 * ����������Ŀ
	 */
	public List<Topic> findAllTopic() {
		return this.getMapper().findAllTopic();
	}

	/**
	 * ������ĿID��ѯ��Ŀ
	 */
	public List<Topic> findTopicByProId(int pro_id) {
		return this.getMapper().findTopicByProId(pro_id);
	}

	/**
	 * ����
	 * 
	 * @param topic
	 */
	public void import_topic(Topic topic) {
		this.getMapper().import_topic(topic);
	}

	/**
	 * �����������Ŀ
	 */
	public void del_topicByProId(int pro_id) {
		this.getMapper().del_topicByProId(pro_id);
	}
}
