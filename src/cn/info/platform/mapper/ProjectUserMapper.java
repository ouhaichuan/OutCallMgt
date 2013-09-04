package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project_User;

/**
 * 
 * @author HCOU
 * 
 */
public interface ProjectUserMapper extends BaseMapper<Project_User> {
	/**
	 * 添加用户项目关联
	 * 
	 * @param project_User
	 */
	void add_user(Project_User project_User);

	/**
	 * 删除用户
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
