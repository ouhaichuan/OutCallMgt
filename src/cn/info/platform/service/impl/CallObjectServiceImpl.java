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
	 * 得到所有的外呼对象
	 * 
	 * @return 对象列表
	 */
	public List<CallObject> findAllCallObject() {
		return callObjectDao.findAllCallObject();
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
	 * 查询相关项目的号码
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
}
