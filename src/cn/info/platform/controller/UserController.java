package cn.info.platform.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.info.platform.entity.User;
import cn.info.platform.service.UserService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/user/*")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "findByID", method = RequestMethod.GET)
	public String findByID(@PathVariable("userID") int userID) {
		User user = userService.getUserByID(userID);
		System.out.println(user.getPassWord());
		return "/index.jsp";
	}

	/**
	 * 登录验证，并记录session
	 * 
	 * @param map
	 *            ModelMap
	 * @param user
	 *            用户登陆对象
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(ModelMap map, User user, HttpServletRequest request) {
		String target = null;
		if (null != userService.login(user)) {
			request.getSession().setAttribute("user", user);
			target = "/index.jsp";
			// 登陆成功
		} else {
			map.put("failure", "用户名或密码有误!");
			target = "/login.jsp";
		}
		return target;
	}

	/**
	 * 退出清空session
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().setAttribute("user", null);

		String target = "/login.jsp";
		return target;
	}

	/**
	 * 查找所有用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_all_users")
	public void findAllUsers(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<User> list = userService.findAllUsers();
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询地址
	 * 
	 * @param request
	 *            请求的对象
	 */
	@RequestMapping(value = "findUserForPro", method = RequestMethod.POST)
	public void findAddr(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<User> list = userService.findAllUsers();
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新用户
	 * 
	 * @param map
	 *            ModelMap
	 * @param user
	 *            用户保存对象
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "save_user", method = RequestMethod.POST)
	public String save_user(ModelMap map, User user, HttpServletRequest request) {
		String target = null;
		userService.save_user(user);
		target = "/users.jsp";
		return target;
	}

	/**
	 * 删除用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "del_user", method = RequestMethod.GET)
	public String del_user(HttpServletRequest request) {
		String target = null;
		userService.del_user(Integer.valueOf(request.getParameter("id")));
		target = "/users.jsp";
		return target;
	}

	/**
	 * 添加用户
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "add_user", method = RequestMethod.POST)
	public String add_user(ModelMap map, User user, HttpServletRequest request) {
		String target = null;
		userService.add_user(user);
		target = "/users.jsp";
		return target;
	}

	/**
	 * 验证用户是否存在
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "validate_user", method = RequestMethod.POST)
	public void validate_user(HttpServletRequest request,
			HttpServletResponse response) {
		User user = null == userService.validate_user(request
				.getParameter("user_name")) ? new User() : userService
				.validate_user(request.getParameter("user_name"));
		String result = "";
		if (!"".equals(user.getUserName()) && null != user.getUserName()) {
			result = "false";
		} else {
			result = "true";
		}
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
