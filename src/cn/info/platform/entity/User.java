package cn.info.platform.entity;

/**
 * �û�ʵ���
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