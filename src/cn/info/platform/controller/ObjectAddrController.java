package cn.info.platform.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.info.platform.entity.Object_Addr;
import cn.info.platform.service.ObjectAddrService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/addr/*")
public class ObjectAddrController {
	@Autowired
	private ObjectAddrService objectAddrService;

	/**
	 * 查询地址
	 * 
	 * @param request
	 *            请求的对象
	 */
	@RequestMapping(value = "findAddr", method = RequestMethod.POST)
	public void findAddr(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int object_id = Integer.valueOf((String) request
				.getParameter("object_id"));

		Object_Addr object_Addr = objectAddrService.findAddr(object_id);
		String addr = object_Addr == null ? "" : object_Addr.getObject_addr();
		int objectFlag = object_Addr == null ? 1 : 2;

		try {
			response.getWriter().write(addr + "&" + objectFlag);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新地址
	 * 
	 * @param request
	 *            请求的对象
	 */
	@RequestMapping(value = "saveAddr", method = RequestMethod.POST)
	public void saveAddr(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		Object_Addr obAddr = new Object_Addr();
		obAddr.setObject_addr((String) request.getParameter("object_addr"));
		obAddr.setObject_id(Integer.valueOf((String) request
				.getParameter("object_id")));
		obAddr.setObject_pnumber((String) request
				.getParameter("object_pnumber"));

		objectAddrService.saveAddr(obAddr);
		try {
			response.getWriter().write("更新成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加地址
	 * 
	 * @param request
	 *            请求的对象
	 */
	@RequestMapping(value = "addAddr", method = RequestMethod.POST)
	public void addAddr(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		Object_Addr obAddr = new Object_Addr();
		obAddr.setObject_addr((String) request.getParameter("object_addr"));
		obAddr.setObject_id(Integer.valueOf((String) request
				.getParameter("object_id")));
		obAddr.setObject_pnumber((String) request
				.getParameter("object_pnumber"));

		objectAddrService.addAddr(obAddr);
		try {
			response.getWriter().write("更新成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
