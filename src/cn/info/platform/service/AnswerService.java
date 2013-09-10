package cn.info.platform.service;

import java.util.List;

import cn.info.platform.entity.Answer;

/**
 * Topicʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface AnswerService extends BaseService<Answer> {

	/**
	 * ��Ӵ�
	 * 
	 * @param answer
	 */
	void addAnswer(Answer answer);

	/**
	 * ��ѯ����answer
	 * @param search_txt 
	 * 
	 * @return
	 */
	List<Answer> findAllAnswer(String search_txt);
}
