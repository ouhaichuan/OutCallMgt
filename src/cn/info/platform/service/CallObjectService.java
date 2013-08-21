package cn.info.platform.service;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.CallObject;

/**
 * CallObject实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface CallObjectService extends BaseService<CallObject> {
	/**
	 * 得到所有的外呼对象
	 * 
	 * @return 对象列表
	 */
	List<CallObject> findAllCallObject();

	/**
	 * 添加号码
	 * 
	 * @param obj
	 */
	void add_obj(CallObject obj);

	/**
	 * 更新号码
	 * 
	 * @param obj
	 */
	void save_obj(CallObject obj);

	/**
	 * 删除号码
	 * 
	 * @param id
	 */
	void del_obj(int id);

	/**
	 * 查询相关项目的号码
	 * 
	 * @param pro_id
	 * @param user_name
	 * 
	 * @return
	 */
	List<CallObject> findCallObjectByProId(Map<String, Object> map);

	/**
	 * 提交异常
	 * 
	 * @param object
	 */
	void commitError(CallObject object);
}
