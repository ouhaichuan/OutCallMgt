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
	 * ����������Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "find_projects_pg")
	public void find_projects_pg(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		String search_txt = "";
		if (null != request.getParameter("search_txt")) {
			search_txt = request.getParameter("search_txt");
		}
		List<Project> list = projectService.findAllProject(search_txt);
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������Ŀͳ��������
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "staticsDataPro")
	public void staticsDataPro(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start_date", start_date);
		map.put("end_date", end_date);

		List<Project> list = null;
		list = projectService.staticsData(map);

		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
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

		target = "/projects.jsp";
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

		target = "/projects.jsp";
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
		int pro_id = Integer.valueOf(request.getParameter("id"));

		projectUserService.del_user(pro_id);// ����������û�

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		objectUserService.del_user(map);// �������ĺ����¼

		callObjectService.del_objByProId(pro_id);// ��������ĺ���

		topicService.del_topicByProId(pro_id);// �����������Ŀ

		saleTelNumberService.delNumByProId(pro_id);// ����Ĺ������ۺ���

		projectService.del_pro(pro_id);// �����Ŀ

		target = "/projects.jsp";
		return target;
	}

	/**
	 * ������Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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
			response.getWriter().write("�������");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����������Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "checkPro")
	public void checkPro(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		String[] dataArray = request.getParameter("list").split(",");
		String flag = "true";
		for (int i = 0; i < dataArray.length; i++) {
			if (projectService.checkPro(dataArray[i]) == 0) {
				flag = "false";
				break;
			}
		}

		try {
			response.getWriter().write(flag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
