package cn.info.platform.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.info.platform.entity.Project;
import cn.info.platform.service.ProjectService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/project/*")
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	/**
	 * 查找所有项目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_all_project")
	public String findAllProject(HttpServletRequest request) {
		String target = null;
		List<Project> list = projectService.findAllProject();
		request.setAttribute("project_list", list);
		target = "/projects.jsp";

		return target;
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

		target = "/project/find_all_project.do";
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

		target = "/project/find_all_project.do";
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
		projectService.del_pro(Integer.valueOf(request.getParameter("id")));
		target = "/project/find_all_project.do";
		return target;
	}
}
