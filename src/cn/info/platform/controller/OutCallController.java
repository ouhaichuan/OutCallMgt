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
import cn.info.platform.entity.CallObject;
import cn.info.platform.entity.Project;
import cn.info.platform.entity.Topic;
import cn.info.platform.entity.User;
import cn.info.platform.service.CallObjectService;
import cn.info.platform.service.ProjectService;
import cn.info.platform.service.TopicService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/outcall/*")
public class OutCallController {
	@Autowired
	private CallObjectService callObjectService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private TopicService topicService;

	/**
	 * 开始外呼答题
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "outcall")
	public String outcall(HttpServletRequest request) {
		String target = null;
		List<Topic> list = topicService.findTopicByProId(Integer
				.valueOf(request.getParameter("pro_id")));

		request.setAttribute("topic_list", list);
		request.setAttribute("object_id", request.getParameter("object_id"));
		request.setAttribute("pro_id", request.getParameter("pro_id"));
		request.setAttribute("pnumber", request.getParameter("pnumber"));
		target = "/outcall_answer.jsp";
		return target;
	}

	/**
	 * 查找所有项目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_all_project")
	public void findAllProject(HttpServletRequest request,
			HttpServletResponse response) {
		String user_name = ((User) request.getSession().getAttribute("user"))
				.getUserName();
		response.setContentType("text/html; charset=utf-8");

		List<Project> list = projectService.findAllProjectByUserName(user_name);
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找相关项目的题目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "findTopicByProId")
	public void findTopicByProId(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<Topic> list = topicService.findTopicByProId(Integer
				.valueOf(request.getParameter("pro_id")));
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找相关项目的号码Ajax
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "findCallObjectByProId")
	public void findCallObjectByProIdAjax(HttpServletRequest request,
			HttpServletResponse response) {
		String user_name = ((User) request.getSession().getAttribute("user"))
				.getUserName();
		int pro_id = Integer.valueOf(request.getParameter("pro_id"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		map.put("user_name", user_name);

		List<CallObject> list = callObjectService.findCallObjectByProId(map);
		response.setContentType("text/html; charset=utf-8");
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
