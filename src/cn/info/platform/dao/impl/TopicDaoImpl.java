package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

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
	 * 添加题目
	 */
	public void add_topic(Topic topic) {
		this.getMapper().add_topic(topic);
	}

	/**
	 * 更新题目
	 */
	public void save_topic(Topic topic) {
		this.getMapper().save_topic(topic);
	}

	/**
	 * 删除题目
	 */
	public void del_topic(int id) {
		this.getMapper().del_topic(id);
	}

	/**
	 * 返回所有题目
	 */
	public List<Topic> findAllTopic() {
		return this.getMapper().findAllTopic();
	}

	/**
	 * 根据项目ID查询题目
	 */
	public List<Topic> findTopicByProId(Map<String, Object> map) {
		return this.getMapper().findTopicByProId(map);
	}

	/**
	 * 导入
	 * 
	 * @param topic
	 */
	public void import_topic(Topic topic) {
		this.getMapper().import_topic(topic);
	}

	/**
	 * 清除关联的题目
	 */
	public void del_topicByProId(int pro_id) {
		this.getMapper().del_topicByProId(pro_id);
	}
}
