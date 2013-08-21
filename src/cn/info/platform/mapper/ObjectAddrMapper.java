package cn.info.platform.mapper;

import cn.info.platform.entity.Object_Addr;

/**
 * 
 * @author HCOU
 * 
 */
public interface ObjectAddrMapper extends BaseMapper<Object_Addr> {

	/**
	 * 查询地址
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
