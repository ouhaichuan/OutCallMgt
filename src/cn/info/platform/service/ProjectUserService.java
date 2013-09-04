package cn.info.platform.service;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project_User;

/**
 * Project_User实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface ProjectUserService extends BaseService<Project_User> {
	/**
	 * 绑定用户
	 */
	void add_user(Project_User project_User);

	/**
	 * 绑定用户
	 */
	void del_user(int pro_id);

	/**
	 * 查询绑定用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Project_User> findbound_user(int pro_id);

	/**
	 * 根据项目查询所属号码数量
	 * 
	 * @param pro_id
	 * 
	 * @return
	 */
	int findObjectNumByProId(int pro_id);

	/**
	 * 根据用户名和项目号删除绑定记录
	 * 
	 * @param map
	 */
	void delBindByMap(Map<String, Object> map);

	/**
	 * 更新用户项目绑定表的绑定数目
	 * 
	 * @param map
	 */
	void updateBindByMap(Map<String, Object> map);
}
