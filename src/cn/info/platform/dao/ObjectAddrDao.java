package cn.info.platform.dao;

import cn.info.platform.entity.Object_Addr;
import cn.info.platform.mapper.ObjectAddrMapper;

/**
 * Object_Addr实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface ObjectAddrDao extends BaseDao<Object_Addr, ObjectAddrMapper> {

	/**
	 * 查询地址
	 * 
	 * @param object_Addr
	 * @return
	 */
	Object_Addr findAddr(int object_id);

	/**
	 * 更新地址
	 * 
	 */
	void saveAddr(Object_Addr object_Addr);

	/**
	 * 添加地址
	 * 
	 * @param obAddr
	 */
	void addAddr(Object_Addr obAddr);
}
