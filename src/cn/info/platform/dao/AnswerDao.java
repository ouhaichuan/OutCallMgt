package cn.info.platform.dao;

import java.util.List;

import cn.info.platform.entity.Answer;
import cn.info.platform.mapper.AnswerMapper;

/**
 * Answer实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface AnswerDao extends BaseDao<Answer, AnswerMapper> {

	/**
	 * 添加答案
	 * 
	 * @param answer
	 */
	void addAnswer(Answer answer);

	/**
	 * 查询所有答案
	 * 
	 * @param search_txt
	 * 
	 * @return
	 */
	List<Answer> findAllAnswer(String search_txt);
}
