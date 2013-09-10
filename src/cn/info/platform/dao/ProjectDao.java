package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.Project;
import cn.info.platform.mapper.ProjectMapper;

/**
 * Project实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface ProjectDao extends BaseDao<Project, ProjectMapper> {
	/**
	 * 查询所有Project
	 * 
	 * @param search_txt
	 * 
	 * @return project数组
	 */
	List<Project> findAllProject(String search_txt);

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
	 * @param id
	 */
	void del_pro(int id);

	/**
	 * 查询相应用户名的项目
	 * 
	 * @param map
	 * @return
	 */
	List<Project> findAllProjectByUserName(Map<String, Object> map);

	/**
	 * 根据项目统计
	 * 
	 * @param map
	 * 
	 * @return
	 */
	List<Project> staticsData(Map<String, Object> map);

	/**
	 * 更改项目状态
	 * 
	 * @param map
	 */
	void changestatepro(Map<String, Object> map);

	/**
	 * 检查是否导入题目和号码
	 * 
	 * @param pro_id
	 * @return
	 */
	int checkPro(String pro_id);
}
