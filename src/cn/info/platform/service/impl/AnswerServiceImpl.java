package cn.info.platform.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.AnswerDao;
import cn.info.platform.entity.Answer;
import cn.info.platform.service.AnswerService;

@Service
public class AnswerServiceImpl extends BaseServiceImpl<Answer> implements
		AnswerService {
	private AnswerDao answerDao;

	@Autowired
	public AnswerServiceImpl(AnswerDao answerDao) {
		this.answerDao = answerDao;
		setBaseDao(answerDao);
	}

	/**
	 * ��Ӵ�
	 */
	public void addAnswer(Answer answer) {
		answerDao.addAnswer(answer);
	}

	/**
	 * ��ѯ����answer
	 */
	public List<Answer> findAllAnswer() {
		return answerDao.findAllAnswer();
	}
}
