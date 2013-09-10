package cn.info.platform.dao;

import java.util.List;

import cn.info.platform.entity.Answer;
import cn.info.platform.mapper.AnswerMapper;

/**
 * Answerʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface AnswerDao extends BaseDao<Answer, AnswerMapper> {

	/**
	 * ��Ӵ�
	 * 
	 * @param answer
	 */
	void addAnswer(Answer answer);

	/**
	 * ��ѯ���д�
	 * 
	 * @param search_txt
	 * 
	 * @return
	 */
	List<Answer> findAllAnswer(String search_txt);
}
