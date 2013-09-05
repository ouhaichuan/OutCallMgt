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
	 * 添加号码
	 */
	public void add_obj(CallObject obj) {
		callObjectDao.add_obj(obj);
	}

	/**
	 * 更新号码
	 */
	public void save_obj(CallObject obj) {
		callObjectDao.save_obj(obj);
	}

	/**
	 * 删除号码
	 */
	public void del_obj(int id) {
		callObjectDao.del_obj(id);
	}

	/**
	 * 查询相关项目和用户名的号码
	 */
	public List<CallObject> findCallObjectByProId(Map<String, Object> map) {
		return callObjectDao.findCallObjectByProId(map);
	}

	/**
	 * 提交异常
	 */
	public void commitError(CallObject object) {
		callObjectDao.commitError(object);
	}

	/**
	 * 导入
	 */
	public void import_obj(CallObject obj) {
		callObjectDao.import_obj(obj);
	}

	/**
	 * 查询相关项目的号码
	 */
	public List<CallObject> findCallObjectByProIdNoUser(Map<String, Object> map) {
		return callObjectDao.findCallObjectByProIdNoUser(map);
	}

	/**
	 * 根据项目ID删除号码
	 */
	public void del_objByProId(int pro_id) {
		callObjectDao.del_objByProId(pro_id);
	}

	/**
	 * 根据状态和项目查询号码
	 */
	public List<CallObject> findCallObjectByProIdAndState(
			Map<String, Object> map) {
		return callObjectDao.findCallObjectByProIdAndState(map);
	}

	/**
	 * 根据状态和用户查询号码
	 */
	public List<CallObject> findCallObjectByUserAndState(Map<String, Object> map) {
		return callObjectDao.findCallObjectByUserAndState(map);
	}
}
