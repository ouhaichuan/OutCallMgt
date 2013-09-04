package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project_User;
import cn.info.platform.mapper.ProjectUserMapper;

/**
 * Project_User实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface ProjectUserDao extends
		BaseDao<Project_User, ProjectUserMapper> {
	/**
	 * 项目绑定用户
	 * 
	 * @param project_User
	 */
	void add_user(Project_User project_User);

	/**
	 * 删除用户
	 * 
	 * @param project_User
	 */
	void del_user(int pro_id);

	/**
	 * 查询用户
	 * 
	 * @param pro_id
	 * @return
	 */
	List<Project_User> findbound_user(int pro_id);

	/**
	 * 查询项目所属号码个数
	 * 
	 * @param pro_id
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
