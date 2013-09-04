package cn.info.platform.entity;

/**
 * 外呼对象（号码）实体类
 * 
 * @author HCOU
 * 
 */
public class CallObject {
	private int object_id;
	private String object_pnumber;
	private String object_remark;
	private String object_mark;
	private String pro_id;
	private String pro_name;
	private String column1;
	private String column2;
	private String object_state;
	private String state_name;
	private String out_time;
	private String out_time_length;
	private String call_user;// 外呼人
	private String call_user_name;// 外呼人姓名

	public String getCall_user() {
		return call_user;
	}

	public void setCall_user(String call_user) {
		this.call_user = call_user;
	}

	public String getPro_id() {
		return pro_id;
	}

	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public int getObject_id() {
		return object_id;
	}

	public void setObject_id(int object_id) {
		this.object_id = object_id;
	}

	public String getObject_pnumber() {
		return object_pnumber;
	}

	public void setObject_pnumber(String object_pnumber) {
		this.object_pnumber = object_pnumber;
	}

	public String getObject_remark() {
		return object_remark;
	}

	public void setObject_remark(String object_remark) {
		this.object_remark = object_remark;
	}

	public String getObject_mark() {
		return object_mark;
	}

	public void setObject_mark(String object_mark) {
		this.object_mark = object_mark;
	}

	public String getPro_name() {
		return pro_name;
	}

	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}

	public String getObject_state() {
		return object_state;
	}

	public void setObject_state(String object_state) {
		this.object_state = object_state;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getOut_time_length() {
		return out_time_length;
	}

	public void setOut_time_length(String out_time_length) {
		this.out_time_length = out_time_length;
	}

	public String getOut_time() {
		return out_time;
	}

	public void setOut_time(String out_time) {
		this.out_time = out_time;
	}

	public String getCall_user_name() {
		return call_user_name;
	}

	public void setCall_user_name(String call_user_name) {
		this.call_user_name = call_user_name;
	}
}
