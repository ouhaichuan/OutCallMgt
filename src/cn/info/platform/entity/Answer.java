package cn.info.platform.entity;

/**
 * 答案实体类
 * 
 * @author HCOU
 * 
 */
public class Answer {
	private int answer_id;
	private int topic_id;
	private String topic_content;
	private int object_id;
	private String object_pnumber;
	private String answer_content;
	private String answer_remark;
	private String answer_mark;

	public String getTopic_content() {
		return topic_content;
	}

	public void setTopic_content(String topic_content) {
		this.topic_content = topic_content;
	}

	public String getObject_pnumber() {
		return object_pnumber;
	}

	public void setObject_pnumber(String object_pnumber) {
		this.object_pnumber = object_pnumber;
	}

	public int getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(int answer_id) {
		this.answer_id = answer_id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public int getObject_id() {
		return object_id;
	}

	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}

	public String getAnswer_remark() {
		return answer_remark;
	}

	public void setAnswer_remark(String answer_remark) {
		this.answer_remark = answer_remark;
	}

	public String getAnswer_mark() {
		return answer_mark;
	}

	public void setAnswer_mark(String answer_mark) {
		this.answer_mark = answer_mark;
	}
}
