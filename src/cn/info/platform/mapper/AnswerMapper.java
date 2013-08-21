package cn.info.platform.mapper;

import java.util.List;

import cn.info.platform.entity.Answer;

/**
 * 
 * @author HCOU
 * 
 */
public interface AnswerMapper extends BaseMapper<Answer> {

	/**
	 * 添加答案
	 * 
	 * @param answer
	 */
	void addAnswer(Answer answer);

	/**
	 * 查询所有答案
	 * 
	 * @return
	 */
	List<Answer> findAllAnswer();
}
