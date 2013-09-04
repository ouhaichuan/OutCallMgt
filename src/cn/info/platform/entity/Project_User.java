package cn.info.platform.entity;

/**
 * 用户项目关联实体
 * 
 * @author HCOU
 * 
 */
public class Project_User {
	private int pu_id;
	private int pro_id;
	private String user_name;
	private String user_xm;
	private String object_num;

	public String getObject_num() {
		return object_num;
	}

	public void setObject_num(String object_num) {
		this.object_num = object_num;
	}

	public int getPu_id() {
		return pu_id;
	}

	public void setPu_id(int pu_id) {
		this.pu_id = pu_id;
	}

	public int getPro_id() {
		return pro_id;
	}

	public void setPro_id(int pro_id) {
		this.pro_id = pro_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_xm() {
		return user_xm;
	}

	public void setUser_xm(String user_xm) {
		this.user_xm = user_xm;
	}
}
