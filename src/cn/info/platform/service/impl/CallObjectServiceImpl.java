package cn.info.platform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.CallObjectDao;
import cn.info.platform.entity.CallObject;
import cn.info.platform.service.CallObjectService;

@Service
public class CallObjectServiceImpl extends BaseServiceImpl<CallObject>
		implements CallObjectService {
	private CallObjectDao callObjectDao;

	@Autowired
	public CallObjectServiceImpl(CallObjectDao callObjectDao) {
		this.callObjectDao = callObjectDao;
		setBaseDao(callObjectDao);
	}

	/**
	 * �õ����е��������
	 * 
	 * @return �����б�
	 */
	public List<CallObject> findAllCallObject() {
		return callObjectDao.findAllCallObject();
	}

	/**
	 * ��Ӻ���
	 */
	public void add_obj(CallObject obj) {
		callObjectDao.add_obj(obj);
	}

	/**
	 * ���º���
	 */
	public void save_obj(CallObject obj) {
		callObjectDao.save_obj(obj);
	}

	/**
	 * ɾ������
	 */
	public void del_obj(int id) {
		callObjectDao.del_obj(id);
	}

	/**
	 * ��ѯ�����Ŀ�ĺ���
	 */
	public List<CallObject> findCallObjectByProId(Map<String, Object> map) {
		return callObjectDao.findCallObjectByProId(map);
	}

	/**
	 * �ύ�쳣
	 */
	public void commitError(CallObject object) {
		callObjectDao.commitError(object);
	}
}
