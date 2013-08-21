package cn.info.platform.dao;

import java.util.List;
import cn.info.platform.entity.Topic;
import cn.info.platform.mapper.TopicMapper;

/**
 * Topic实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface TopicDao extends BaseDao<Topic, TopicMapper> {

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
	 * 查询所有题目
	 * 
	 * @return
	 */
	List<Topic> findAllTopic();

	/**
	 * 查询相关项目的题目
	 * 
	 * @return
	 */
	List<Topic> findTopicByProId(int pro_id);
}
