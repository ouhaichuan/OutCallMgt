package cn.info.platform.entity;

/**
 * 用户实体表
 * 
 * @author HCOU
 * 
 */
public class User {
	private int userID;
	private String userName;
	private String passWord;
	private String role_id;
	private String role_name;
	private String remark;
	private String mark;
	private String user_phone;
	private String user_xm;
	private String user_channel;// 通道号

	private String outcall_times;// 外呼次数
	private String outcall_complete;// 外呼完成数
	private String outcall_notcomplete;// 外呼未完成数；
	private String outcall_timelength;// 外乎时长

	public String getOutcall_times() {
		return outcall_times;
	}

	public void setOutcall_times(String outcall_times) {
		this.outcall_times = outcall_times;
	}

	public String getOutcall_complete() {
		return outcall_complete;
	}

	public void setOutcall_complete(String outcall_complete) {
		this.outcall_complete = outcall_complete;
	}

	public String getOutcall_notcomplete() {
		return outcall_notcomplete;
	}

	public void setOutcall_notcomplete(String outcall_notcomplete) {
		this.outcall_notcomplete = outcall_notcomplete;
	}

	public String getOutcall_timelength() {
		return outcall_timelength;
	}

	public void setOutcall_timelength(String outcall_timelength) {
		this.outcall_timelength = outcall_timelength;
	}

	public String getUser_channel() {
		return user_channel;
	}

	public void setUser_channel(String user_channel) {
		this.user_channel = user_channel;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getUser_xm() {
		return user_xm;
	}

	public void setUser_xm(String user_xm) {
		this.user_xm = user_xm;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public User() {
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
}
