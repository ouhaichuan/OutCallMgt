package cn.info.platform.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.TopicDao;
import cn.info.platform.entity.Topic;
import cn.info.platform.service.TopicService;

@Service
public class TopicServiceImpl extends BaseServiceImpl<Topic> implements
		TopicService {
	private TopicDao topicDao;

	@Autowired
	public TopicServiceImpl(TopicDao topicDao) {
		this.topicDao = topicDao;
		setBaseDao(topicDao);
	}

	/**
	 * �����Ŀ
	 */
	public void add_topic(Topic topic) {
		topicDao.add_topic(topic);
	}

	/**
	 * ������Ŀ
	 */
	public void save_topic(Topic topic) {
		topicDao.save_topic(topic);
	}

	/**
	 * ɾ����Ŀ
	 */
	public void del_topic(int id) {
		topicDao.del_topic(id);
	}

	/**
	 * �õ����е������Ŀ����Ŀ
	 * 
	 * @return ��Ŀ�б�
	 */
	public List<Topic> findAllTopic() {
		return topicDao.findAllTopic();
	}

	/**
	 * ��ѯ�����Ŀ����Ŀ
	 */
	public List<Topic> findTopicByProId(int pro_id) {
		return topicDao.findTopicByProId(pro_id);
	}

	/**
	 * ����
	 * 
	 * @param topic
	 */
	public void import_topic(Topic topic) {
		topicDao.import_topic(topic);
	}

	/**
	 * �����������Ŀ
	 */
	public void del_topicByProId(int pro_id) {
		topicDao.del_topicByProId(pro_id);
	}
}
