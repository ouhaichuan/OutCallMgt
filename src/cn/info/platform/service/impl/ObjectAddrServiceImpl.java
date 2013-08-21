package cn.info.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.ObjectAddrDao;
import cn.info.platform.entity.Object_Addr;
import cn.info.platform.service.ObjectAddrService;

@Service
public class ObjectAddrServiceImpl extends BaseServiceImpl<Object_Addr>
		implements ObjectAddrService {
	private ObjectAddrDao objectAddDao;

	@Autowired
	public ObjectAddrServiceImpl(ObjectAddrDao objectAddDao) {
		this.objectAddDao = objectAddDao;
		setBaseDao(objectAddDao);
	}

	/**
	 * ��ѯ��ַ
	 */
	public Object_Addr findAddr(int object_id) {
		return objectAddDao.findAddr(object_id);
	}

	/**
	 * ���µ�ַ
	 */
	public void saveAddr(Object_Addr object_addr) {
		objectAddDao.saveAddr(object_addr);
	}

	/**
	 * ��ӵ�ַ
	 */
	public void addAddr(Object_Addr obAddr) {
		objectAddDao.addAddr(obAddr);
	}
}
