package cn.info.platform.service;

import java.util.List;
import cn.info.platform.entity.Topic;

/**
 * Topic实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface TopicService extends BaseService<Topic> {
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
	 * 得到所有的相关项目的题目
	 * 
	 * @return 题目列表
	 */
	List<Topic> findAllTopic();

	/**
	 * 查询相关项目的题目
	 * 
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
