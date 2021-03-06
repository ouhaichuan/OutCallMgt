package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.CallObject;

/**
 * 
 * @author HCOU
 * 
 */
public interface CallObjectMapper extends BaseMapper<CallObject> {
	/**
	 * 得到所有的外呼对象
	 * 
	 * @return
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
	 * 查询所属项目的号码
	 * 
	 * @param pro_id
	 * @param user_name
	 * @return
	 */
	List<CallObject> findCallObjectByProId(Map<String, Object> map);

	/**
	 * 提交异常
	 * 
	 * @param object
	 */
	void commitError(CallObject object);

	/**
	 * 导入
	 * 
	 * @param obj
	 */
	void import_obj(CallObject obj);

	/**
	 * 查询所属项目的号码
	 * 
	 * @param map
	 * @return
	 */
	List<CallObject> findCallObjectByProIdNoUser(Map<String, Object> map);

	/**
	 * 根据项目ID删除号码
	 * 
	 * @param pro_id
	 */
	void del_objByProId(int pro_id);

	/**
	 * 查询外呼总量
	 * 
	 * @param integer
	 * @return
	 */
	List<CallObject> findCallObjectByProIdTotal(Integer integer);

	/**
	 * 查询外呼完成
	 * 
	 * @param integer
	 * @return
	 */
	List<CallObject> findCallObjectByProIdComplete(Integer integer);

	/**
	 * 查询外呼未完成
	 * 
	 * @param integer
	 * @return
	 */
	List<CallObject> findCallObjectByProIdNotComplete(Integer integer);

	/**
	 * 查询外呼总量根据用户
	 * 
	 * @param integer
	 * @return
	 */
	List<CallObject> findCallObjectByUserTotal(String user_name);

	/**
	 * 查询外呼完成量根据用户
	 * 
	 * @param integer
	 * @return
	 */
	List<CallObject> findCallObjectByUserComplete(String user_name);

	/**
	 * 查询外呼未完成量根据用户
	 * 
	 * @param integer
	 * @return
	 */
	List<CallObject> findCallObjectByUserNotComplete(String user_name);
}
