package cn.info.platform.entity;

/**
 * 对象用户实体
 * 
 * @author HCOU
 * 
 */
public class Object_User {
	private int ou_id;
	private int object_id;
	private String user_name;
	private String user_xm;

	public int getOu_id() {
		return ou_id;
	}

	public void setOu_id(int ou_id) {
		this.ou_id = ou_id;
	}

	public int getObject_id() {
		return object_id;
	}

	public void setObject_id(int object_id) {
		this.object_id = object_id;
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
