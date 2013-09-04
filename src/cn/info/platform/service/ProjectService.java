package cn.info.platform.service;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project;

/**
 * Project实体类对应的业务操作类接口
 * 
 * @author HCOU
 */
public interface ProjectService extends BaseService<Project> {
	/**
	 * 得到所有Project
	 * 
	 * @return project数组
	 */
	List<Project> findAllProject();

	/**
	 * 更新项目
	 * 
	 * @param project
	 */
	void save_pro(Project project);

	/**
	 * 添加项目
	 * 
	 * @param project
	 */
	void add_pro(Project project);

	/**
	 * 删除项目
	 * 
	 * @param valueOf
	 */
	void del_pro(int id);

	/**
	 * 根据登录用户名查询相应的项目
	 * 
	 * @param user_name
	 * @return
	 */
	List<Project> findAllProjectByUserName(String user_name);

	/**
	 * 根据项目统计
	 * 
	 * @return
	 */
	List<Project> staticsData();

	/**
	 * 更改项目状态
	 * 
	 * @param map
	 */
	void changestatepro(Map<String, Object> map);

	/**
	 * 统计个人数据
	 * 
	 * @param userName
	 * @return
	 */
	List<Project> staticsDataForSign(String userName);
}
