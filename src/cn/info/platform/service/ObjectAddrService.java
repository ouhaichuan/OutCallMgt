package cn.info.platform.service;

import cn.info.platform.entity.Object_Addr;

/**
 * Object_Addr实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface ObjectAddrService extends BaseService<Object_Addr> {

	/**
	 * 查询地址
	 * 
	 * @param object_id
	 */
	Object_Addr findAddr(int object_id);

	/**
	 * 更新地址
	 */
	void saveAddr(Object_Addr object_Addr);

	/**
	 * 添加地址
	 * 
	 * @param obAddr
	 */
	void addAddr(Object_Addr obAddr);
}
