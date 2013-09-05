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
	 * ��ѯ�����Ŀ���û����ĺ���
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

	/**
	 * ����
	 */
	public void import_obj(CallObject obj) {
		callObjectDao.import_obj(obj);
	}

	/**
	 * ��ѯ�����Ŀ�ĺ���
	 */
	public List<CallObject> findCallObjectByProIdNoUser(Map<String, Object> map) {
		return callObjectDao.findCallObjectByProIdNoUser(map);
	}

	/**
	 * ������ĿIDɾ������
	 */
	public void del_objByProId(int pro_id) {
		callObjectDao.del_objByProId(pro_id);
	}

	/**
	 * ����״̬����Ŀ��ѯ����
	 */
	public List<CallObject> findCallObjectByProIdAndState(
			Map<String, Object> map) {
		return callObjectDao.findCallObjectByProIdAndState(map);
	}

	/**
	 * ����״̬���û���ѯ����
	 */
	public List<CallObject> findCallObjectByUserAndState(Map<String, Object> map) {
		return callObjectDao.findCallObjectByUserAndState(map);
	}
}
