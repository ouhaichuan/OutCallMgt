package cn.info.platform.dao;

import cn.info.platform.entity.Object_Addr;
import cn.info.platform.mapper.ObjectAddrMapper;

/**
 * Object_Addrʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface ObjectAddrDao extends BaseDao<Object_Addr, ObjectAddrMapper> {

	/**
	 * ��ѯ��ַ
	 * 
	 * @param object_Addr
	 * @return
	 */
	Object_Addr findAddr(int object_id);

	/**
	 * ���µ�ַ
	 * 
	 */
	void saveAddr(Object_Addr object_Addr);

	/**
	 * ��ӵ�ַ
	 * 
	 * @param obAddr
	 */
	void addAddr(Object_Addr obAddr);
}
