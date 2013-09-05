package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.CallObjectDao;
import cn.info.platform.entity.CallObject;
import cn.info.platform.mapper.CallObjectMapper;

/**
 * @author HCOU
 */
@Repository
public class CallObjectDaoImpl extends
		BaseDaoImpl<CallObject, CallObjectMapper> implements CallObjectDao {
	public CallObjectDaoImpl() {
		setMapperClass(CallObjectMapper.class);
	}

	/**
	 * 添加号码
	 */
	public void add_obj(CallObject obj) {
		this.getMapper().add_obj(obj);
	}

	/**
	 * 更新号码
	 */
	public void save_obj(CallObject obj) {
		this.getMapper().save_obj(obj);
	}

	/**
	 * 删除号码
	 */
	public void del_obj(int id) {
		this.getMapper().del_obj(id);
	}

	/**
	 * 查询所属项目和姓名的号码
	 */
	public List<CallObject> findCallObjectByProId(Map<String, Object> map) {
		return this.getMapper().findCallObjectByProId(map);
	}

	/**
	 * 提交异常
	 */
	public void commitError(CallObject object) {
		this.getMapper().commitError(object);
	}

	/**
	 * 导入
	 */
	public void import_obj(CallObject obj) {
		this.getMapper().import_obj(obj);
	}

	/**
	 * 查询所属项目的号码
	 */
	public List<CallObject> findCallObjectByProIdNoUser(Map<String, Object> map) {
		return this.getMapper().findCallObjectByProIdNoUser(map);
	}

	/**
	 * 根据项目ID删除号码
	 */
	public void del_objByProId(int pro_id) {
		this.getMapper().del_objByProId(pro_id);
	}

	/**
	 * 根据状态和项目查询号码
	 */
	public List<CallObject> findCallObjectByProIdAndState(
			Map<String, Object> map) {
		int state = (Integer) map.get("state");
		List<CallObject> list = null;
		if (state == 1) {// 外呼总量
			list = this.getMapper().findCallObjectByProIdTotal(
					(Integer) map.get("pro_id"));
		} else if (state == 2) {// 完成
			list = this.getMapper().findCallObjectByProIdComplete(
					(Integer) map.get("pro_id"));
		} else if (state == 3) {// 未完成
			list = this.getMapper().findCallObjectByProIdNotComplete(
					(Integer) map.get("pro_id"));
		}
		return list;
	}

	/**
	 * 根据状态和用户查询号码
	 */
	public List<CallObject> findCallObjectByUserAndState(Map<String, Object> map) {
		int state = (Integer) map.get("state");
		List<CallObject> list = null;
		if (state == 1) {// 外呼总量
			list = this.getMapper().findCallObjectByUserTotal(
					(String) map.get("user_name"));
		} else if (state == 2) {// 完成
			list = this.getMapper().findCallObjectByUserComplete(
					(String) map.get("user_name"));
		} else if (state == 3) {// 未完成
			list = this.getMapper().findCallObjectByUserNotComplete(
					(String) map.get("user_name"));
		}
		return list;
	}
}
