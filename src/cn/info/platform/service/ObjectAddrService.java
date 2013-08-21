package cn.info.platform.service;

import cn.info.platform.entity.Object_Addr;

/**
 * Object_Addrʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface ObjectAddrService extends BaseService<Object_Addr> {

	/**
	 * ��ѯ��ַ
	 * 
	 * @param object_id
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
