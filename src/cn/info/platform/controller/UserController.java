package cn.info.platform.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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

	/**
	 * ��¼��֤������¼session
	 * 
	 * @param map
	 *            ModelMap
	 * @param user
	 *            �û���½����
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public void login(ModelMap map, User user, HttpServletRequest request,
			HttpServletResponse response) {
		String target = null;
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";

		if (null != userService.login(user)) {
			User newUser = userService.login(user);
			request.getSession().setAttribute("user", newUser);
			target = basePath + "index.jsp";
			// ��½�ɹ�
		} else {
			target = basePath + "login.jsp";
			request.getSession().setAttribute("failure", "�û������������");
		}
		try {
			response.sendRedirect(target);// ��ת�����ı��ַ��
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �˳����session
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().setAttribute("user", null);

		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
		String target = basePath + "login.jsp";

		try {
			response.sendRedirect(target);// ��ת�����ı��ַ��
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���������û�
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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
	 * ��ѯ��ַ
	 * 
	 * @param request
	 *            ����Ķ���
	 */
	@RequestMapping(value = "findUserForPro", method = RequestMethod.POST)
	public void findUserForPro(HttpServletRequest request,
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
	 * �����û�
	 * 
	 * @param map
	 *            ModelMap
	 * @param user
	 *            �û��������
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "save_user", method = RequestMethod.POST)
	public String save_user(ModelMap map, User user, HttpServletRequest request) {
		String target = null;
		userService.save_user(user);
		target = "/users.jsp";
		return target;
	}

	/**
	 * ɾ���û�
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "del_user", method = RequestMethod.GET)
	public String del_user(HttpServletRequest request) {
		String target = null;
		userService.del_user(Integer.valueOf(request.getParameter("id")));
		target = "/users.jsp";
		return target;
	}

	/**
	 * ����û�
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "add_user", method = RequestMethod.POST)
	public String add_user(ModelMap map, User user, HttpServletRequest request) {
		String target = null;
		userService.add_user(user);
		target = "/users.jsp";
		return target;
	}

	/**
	 * ��֤�û��Ƿ����
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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

	/**
	 * ����Ա��ͳ��������
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "staticsDataUser")
	public void staticsDataUser(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<User> list = null;
		User user = (User) request.getSession().getAttribute("user");

		if ("����Ա".equals(user.getRole_name())) {
			list = userService.staticsData();// ȫ������
		} else {
			list = userService.staticsDataForSign(user.getUserName());// ��������
		}
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
