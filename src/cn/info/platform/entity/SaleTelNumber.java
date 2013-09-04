package cn.info.platform.entity;

/**
 * 需要销售的号码实体类
 * 
 * @author HCOU
 * 
 */
public class SaleTelNumber {
	private int num_id;
	private String telnumber;
	private String num_state;
	private String sale_time;
	private String pro_id;
	private String pro_name;
	private String user_name;
	private String user_xm;

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getUser_xm() {
		return user_xm;
	}

	public void setUser_xm(String user_xm) {
		this.user_xm = user_xm;
	}

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getNum_state() {
		return num_state;
	}

	public void setNum_state(String num_state) {
		this.num_state = num_state;
	}

	public String getSale_time() {
		return sale_time;
	}

	public void setSale_time(String sale_time) {
		this.sale_time = sale_time;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
