package cn.info.platform.mapper;

import cn.info.platform.entity.Object_Addr;

/**
 * 
 * @author HCOU
 * 
 */
public interface ObjectAddrMapper extends BaseMapper<Object_Addr> {

	/**
	 * ��ѯ��ַ
	 */
	Object_Addr findAddr(int object_id);

	/**
	 * ���µ�ַ
	 */
	void saveAddr(Object_Addr object_Addr);

	/**
	 * ��ӵ�ַ
	 * 
	 * @param obAddr
	 */
	void addAddr(Object_Addr obAddr);
}
