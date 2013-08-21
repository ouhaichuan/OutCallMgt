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
	 * ����������Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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
	 * ������Ŀ
	 * 
	 * @param map
	 *            ModelMap
	 * @param project
	 *            ��Ŀ�������
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "save_pro", method = RequestMethod.POST)
	public String save_pro(Project project, HttpServletRequest request) {
		String target = null;

		projectService.save_pro(project);

		target = "/project/find_all_project.do";
		return target;
	}

	/**
	 * �����Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "add_pro", method = RequestMethod.POST)
	public String add_pro(Project project, HttpServletRequest request) {
		String target = null;
		projectService.add_pro(project);

		target = "/project/find_all_project.do";
		return target;
	}

	/**
	 * ɾ���û�
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "del_pro", method = RequestMethod.GET)
	public String del_pro(HttpServletRequest request) {
		String target = null;
		projectService.del_pro(Integer.valueOf(request.getParameter("id")));
		target = "/project/find_all_project.do";
		return target;
	}
}
