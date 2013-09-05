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
import cn.info.platform.entity.Project_User;
import cn.info.platform.service.ObjectUserService;
import cn.info.platform.service.ProjectUserService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/projectuser/*")
public class ProjectUserController {
	@Autowired
	ProjectUserService projectUserService;
	@Autowired
	ObjectUserService objectUserService;

	/**
	 * 查询项目所属号码个数
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "findObjectNumByProId", method = RequestMethod.POST)
	public void findObjectNumByProId(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int pro_id = Integer.valueOf(request.getParameter("pro_id"));
		int num = projectUserService.findObjectNumByProId(pro_id);
		try {
			response.getWriter().write(num + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 项目绑定用户
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
		String user_infos = request.getParameter("user_infos");
		String[] infos = user_infos.split(",");

		projectUserService.del_user(pro_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		objectUserService.del_user(map);// 先清空

		for (int i = 0; i < infos.length; i += 2) {
			Project_User project_User = new Project_User();
			project_User.setPro_id(pro_id);
			project_User.setUser_name(infos[i]);
			project_User.setObject_num(infos[i + 1]);
			projectUserService.add_user(project_User);

			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("pro_id", pro_id);
			map2.put("user_name", infos[i]);
			map2.put("object_num", Integer.valueOf(infos[i + 1]));
			objectUserService.add_user(map2);// 重新绑定
		}
		int num = projectUserService.findObjectNumByProId(pro_id);// 重新查询数量
		try {
			response.getWriter().write(num + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 项目绑定用户
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

	/**
	 * 清空绑定用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "cls_user", method = RequestMethod.POST)
	public void cls_user(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int pro_id = Integer.valueOf(request.getParameter("pro_id"));

		projectUserService.del_user(pro_id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		objectUserService.del_user(map);// 先清空

		int num = projectUserService.findObjectNumByProId(pro_id);// 重新查询数量
		try {
			response.getWriter().write(num + "");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
