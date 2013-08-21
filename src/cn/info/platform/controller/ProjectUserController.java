package cn.info.platform.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.info.platform.entity.Project_User;
import cn.info.platform.service.ProjectUserService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/projectuser/*")
public class ProjectUserController {
	@Autowired
	ProjectUserService projectUserService;

	/**
	 * 醒目绑定用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "bound_user", method = RequestMethod.POST)
	public void bound_user(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int pro_id = Integer.valueOf(request.getParameter("pro_id"));
		String user_names = request.getParameter("user_names");
		String[] names = user_names.split(",");
		
		projectUserService.del_user(pro_id);
		for (String name : names) {
			Project_User project_User = new Project_User();
			project_User.setPro_id(pro_id);
			project_User.setUser_name(name);
			projectUserService.add_user(project_User);
		}
		try {
			response.getWriter().write("绑定成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 醒目绑定用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "findbound_user", method = RequestMethod.POST)
	public void findbound_user(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int pro_id = Integer.valueOf(request.getParameter("pro_id"));

		List<Project_User> list = projectUserService.findbound_user(pro_id);
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
