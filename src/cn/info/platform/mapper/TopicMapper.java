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
	 * 添加题目
	 * 
	 * @param topic
	 */
	void add_topic(Topic topic);

	/**
	 * 更新题目
	 * 
	 * @param topic
	 */
	void save_topic(Topic topic);

	/**
	 * 删除题目
	 * 
	 * @param id
	 */
	void del_topic(int id);

	/**
	 * 返回所有题目
	 * 
	 * @return
	 */
	List<Topic> findAllTopic();

	List<Topic> findTopicByProId(int pro_id);
}
