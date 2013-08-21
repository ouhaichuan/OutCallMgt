package cn.info.platform.dao.impl;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.ObjectAddrDao;
import cn.info.platform.entity.Object_Addr;
import cn.info.platform.mapper.ObjectAddrMapper;

/**
 * @author HCOU
 */
@Repository
public class ObjectAddrDaoImpl extends
		BaseDaoImpl<Object_Addr, ObjectAddrMapper> implements ObjectAddrDao {
	public ObjectAddrDaoImpl() {
		setMapperClass(ObjectAddrMapper.class);
	}

	/**
	 * ��ѯ��ַ
	 */
	public Object_Addr findAddr(int object_id) {
		return this.getMapper().findAddr(object_id);
	}

	/**
	 * ���µ�ַ
	 */
	public void saveAddr(Object_Addr object_addr) {
		this.getMapper().saveAddr(object_addr);
	}

	/**
	 * ��ӵ�ַ
	 */
	public void addAddr(Object_Addr obAddr) {
		this.getMapper().addAddr(obAddr);
	}
}
