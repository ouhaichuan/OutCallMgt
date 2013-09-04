package cn.info.platform.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.info.platform.entity.Project;
import cn.info.platform.service.CallObjectService;
import cn.info.platform.service.ObjectUserService;
import cn.info.platform.service.ProjectService;
import cn.info.platform.service.ProjectUserService;
import cn.info.platform.service.SaleTelNumberService;
import cn.info.platform.service.TopicService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/project/*")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectUserService projectUserService;
	@Autowired
	private ObjectUserService objectUserService;
	@Autowired
	private CallObjectService callObjectService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private SaleTelNumberService saleTelNumberService;

	/**
	 * 查找所有项目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_projects_pg")
	public void find_projects_pg(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<Project> list = projectService.findAllProject();
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据项目统计外呼情况
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "staticsData")
	public void staticsData(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<Project> list = projectService.staticsData();
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新项目
	 * 
	 * @param map
	 *            ModelMap
	 * @param project
	 *            项目保存对象
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "save_pro", method = RequestMethod.POST)
	public String save_pro(Project project, HttpServletRequest request) {
		String target = null;

		projectService.save_pro(project);

		target = "/projects.jsp";
		return target;
	}

	/**
	 * 添加项目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "add_pro", method = RequestMethod.POST)
	public String add_pro(Project project, HttpServletRequest request) {
		String target = null;
		projectService.add_pro(project);

		target = "/projects.jsp";
		return target;
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "del_pro", method = RequestMethod.GET)
	public String del_pro(HttpServletRequest request) {
		String target = null;
		int pro_id = Integer.valueOf(request.getParameter("id"));

		projectUserService.del_user(pro_id);// 清除关联的用户

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		objectUserService.del_user(map);// 清除分配的号码记录

		callObjectService.del_objByProId(pro_id);// 清除关联的号码

		topicService.del_topicByProId(pro_id);// 清除关联的题目

		saleTelNumberService.delNumByProId(pro_id);// 清除的关联销售号码

		projectService.del_pro(pro_id);// 清除项目

		target = "/projects.jsp";
		return target;
	}

	/**
	 * 启动项目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "changestatepro", method = RequestMethod.POST)
	public void changestatepro(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		String[] dataArray = request.getParameter("pro_id_list").split(",");
		String pro_state = request.getParameter("pro_state");
		
		for (int i = 0; i < dataArray.length; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pro_id", Integer.valueOf(dataArray[i]));
			map.put("pro_state", pro_state);
			projectService.changestatepro(map);
		}
		try {
			response.getWriter().write("操作完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
