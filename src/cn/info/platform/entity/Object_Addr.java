package cn.info.platform.entity;

/**
 * 有地址的对象实体
 * 
 * @author HCOU
 * 
 */
public class Object_Addr {
	private int object_id;
	private String object_pnumber;
	private String object_addr;

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

	public String getObject_addr() {
		return object_addr;
	}

	public void setObject_addr(String object_addr) {
		this.object_addr = object_addr;
	}
}
