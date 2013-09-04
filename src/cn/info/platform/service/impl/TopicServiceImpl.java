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
	 * 添加题目
	 */
	public void add_topic(Topic topic) {
		topicDao.add_topic(topic);
	}

	/**
	 * 更新题目
	 */
	public void save_topic(Topic topic) {
		topicDao.save_topic(topic);
	}

	/**
	 * 删除题目
	 */
	public void del_topic(int id) {
		topicDao.del_topic(id);
	}

	/**
	 * 得到所有的相关项目的题目
	 * 
	 * @return 题目列表
	 */
	public List<Topic> findAllTopic() {
		return topicDao.findAllTopic();
	}

	/**
	 * 查询相关项目的题目
	 */
	public List<Topic> findTopicByProId(int pro_id) {
		return topicDao.findTopicByProId(pro_id);
	}

	/**
	 * 导入
	 * 
	 * @param topic
	 */
	public void import_topic(Topic topic) {
		topicDao.import_topic(topic);
	}

	/**
	 * 清除关联的题目
	 */
	public void del_topicByProId(int pro_id) {
		topicDao.del_topicByProId(pro_id);
	}
}
