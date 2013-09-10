package cn.info.platform.service;

import java.util.List;

import cn.info.platform.entity.Answer;

/**
 * Topic实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface AnswerService extends BaseService<Answer> {

	/**
	 * 添加答案
	 * 
	 * @param answer
	 */
	void addAnswer(Answer answer);

	/**
	 * 查询所有answer
	 * @param search_txt 
	 * 
	 * @return
	 */
	List<Answer> findAllAnswer(String search_txt);
}
