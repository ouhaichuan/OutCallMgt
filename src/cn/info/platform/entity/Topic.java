package cn.info.platform.entity;

/**
 * 外呼题目实体类
 * 
 * @author HCOU
 * 
 */
public class Topic {
	private int topic_id;
	private int pro_id;
	private String pro_name;
	private String topic_content;
	private String topic_type;
	private String topic_remark;
	private String topic_mark;

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getTopic_content() {
		return topic_content;
	}

	public void setTopic_content(String topic_content) {
		this.topic_content = topic_content;
	}

	public String getTopic_type() {
		return topic_type;
	}

	public void setTopic_type(String topic_type) {
		this.topic_type = topic_type;
	}

	public String getTopic_remark() {
		return topic_remark;
	}

	public void setTopic_remark(String topic_remark) {
		this.topic_remark = topic_remark;
	}

	public String getTopic_mark() {
		return topic_mark;
	}

	public void setTopic_mark(String topic_mark) {
		this.topic_mark = topic_mark;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
}
