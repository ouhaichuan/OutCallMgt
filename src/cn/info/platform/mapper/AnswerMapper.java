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
	 * ��Ӵ�
	 * 
	 * @param answer
	 */
	void addAnswer(Answer answer);

	/**
	 * ��ѯ���д�
	 * 
	 * @return
	 */
	List<Answer> findAllAnswer();
}
