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
import cn.info.platform.entity.Object_User;
import cn.info.platform.service.ObjectUserService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/objectuser/*")
public class ObjectUserController {
	@Autowired
	ObjectUserService objectUserService;

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
		int object_id = Integer.valueOf(request.getParameter("object_id"));
		String user_names = request.getParameter("user_names");
		String[] names = user_names.split(",");

		objectUserService.del_user(object_id);
		for (String name : names) {
			Object_User object_User = new Object_User();
			object_User.setObject_id(object_id);
			object_User.setUser_name(name);
			objectUserService.add_user(object_User);
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
		int object_id = Integer.valueOf(request.getParameter("object_id"));

		List<Object_User> list = objectUserService.findbound_user(object_id);
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
