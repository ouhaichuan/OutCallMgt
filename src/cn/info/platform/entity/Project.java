package cn.info.platform.entity;

/**
 * 外呼项目实体类
 * 
 * @author HCOU
 * 
 */
public class Project {
	private int pro_id;
	private String pro_name;
	private String pro_type;
	private String pro_state;
	private String pro_remark;
	private String pro_mark;
	private String pro_date;
	private String pro_users;// 项目负责人
	private String pro_zpr;// 项目指派人

	private String calltotal;// 项目外呼总量
	private String callcomplete;// 外呼完成量
	private String callnotcomplete;// 外呼未完成量
	private String outCallNums; // 外呼号码数量

	public String getCalltotal() {
		return calltotal;
	}

	public void setCalltotal(String calltotal) {
		this.calltotal = calltotal;
	}

	public String getCallcomplete() {
		return callcomplete;
	}

	public void setCallcomplete(String callcomplete) {
		this.callcomplete = callcomplete;
	}

	public String getCallnotcomplete() {
		return callnotcomplete;
	}

	public void setCallnotcomplete(String callnotcomplete) {
		this.callnotcomplete = callnotcomplete;
	}

	public String getPro_users() {
		return pro_users;
	}

	public void setPro_users(String pro_users) {
		this.pro_users = pro_users;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getPro_type() {
		return pro_type;
	}

	public void setPro_type(String pro_type) {
		this.pro_type = pro_type;
	}

	public String getPro_state() {
		return pro_state;
	}

	public void setPro_state(String pro_state) {
		this.pro_state = pro_state;
	}

	public String getPro_remark() {
		return pro_remark;
	}

	public void setPro_remark(String pro_remark) {
		this.pro_remark = pro_remark;
	}

	public String getPro_mark() {
		return pro_mark;
	}

	public void setPro_mark(String pro_mark) {
		this.pro_mark = pro_mark;
	}

	public String getPro_date() {
		return pro_date;
	}

	public void setPro_date(String pro_date) {
		this.pro_date = pro_date;
	}

	public String getPro_zpr() {
		return pro_zpr;
	}

	public void setPro_zpr(String pro_zpr) {
		this.pro_zpr = pro_zpr;
	}

	public String getOutCallNums() {
		return outCallNums;
	}

	public void setOutCallNums(String outCallNums) {
		this.outCallNums = outCallNums;
	}
}
