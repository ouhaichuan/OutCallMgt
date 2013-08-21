package cn.info.platform.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.AnswerDao;
import cn.info.platform.entity.Answer;
import cn.info.platform.mapper.AnswerMapper;

/**
 * @author HCOU
 */
@Repository
public class AnswerDaoImpl extends BaseDaoImpl<Answer, AnswerMapper> implements
		AnswerDao {
	public AnswerDaoImpl() {
		setMapperClass(AnswerMapper.class);
	}

	/**
	 * 添加答案
	 */
	public void addAnswer(Answer answer) {
		this.getMapper().addAnswer(answer);
	}

	/**
	 * 查询所有答案
	 */
	public List<Answer> findAllAnswer() {
		return this.getMapper().findAllAnswer();
	}
}
