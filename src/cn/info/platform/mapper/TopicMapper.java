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

	/**
	 * 根据项目ID查询题目
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Topic> findTopicByProId(int pro_id);

	/**
	 * 导入
	 * 
	 * @param topic
	 */
	void import_topic(Topic topic);

	/**
	 * 清除关联的题目
	 * 
	 * @param pro_id
	 */
	void del_topicByProId(int pro_id);
}
