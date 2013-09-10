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

import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.service.SaleTelNumberService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/saletelnumber/*")
public class SaleTelNumberController {
	@Autowired
	private SaleTelNumberService saleTelNumberService;

	/**
	 * 查找所有号码
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_all_numbers")
	public void findAllNumbers(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		String search_txt = "";
		if (null != request.getParameter("search_txt")) {
			search_txt = request.getParameter("search_txt");
		}
		int pro_id = Integer.valueOf(request.getParameter("pro_id"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("search_txt", search_txt);
		map.put("pro_id", pro_id);

		List<SaleTelNumber> list = saleTelNumberService.findAllNumbers(map);
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查找所有可以销售的号码
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_cansale_numbers")
	public void find_cansale_numbers(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<SaleTelNumber> list = saleTelNumberService
				.find_cansale_numbers(Integer.valueOf(request
						.getParameter("pro_id")));
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加号码
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "add_num")
	public String add_num(SaleTelNumber saleTelNumber,
			HttpServletRequest request) {
		String target = null;
		saleTelNumberService.add_num(saleTelNumber);

		try {
			target = "/salenumbers.jsp?pro_id="
					+ saleTelNumber.getPro_id()
					+ "&pro_name="
					+ new String(saleTelNumber.getPro_name().getBytes("utf-8"),
							"iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	/**
	 * 更新号码
	 * 
	 * @param map
	 *            ModelMap
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "save_num")
	public String save_num(SaleTelNumber saleTelNumber,
			HttpServletRequest request) {
		String target = null;
		saleTelNumberService.save_num(saleTelNumber);

		try {
			target = "/salenumbers.jsp?pro_id="
					+ saleTelNumber.getPro_id()
					+ "&pro_name="
					+ new String(saleTelNumber.getPro_name().getBytes("utf-8"),
							"iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}

	/**
	 * 删除号码
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "del_num", method = RequestMethod.GET)
	public String del_topic(HttpServletRequest request) {
		String target = null;
		saleTelNumberService
				.del_num(Integer.valueOf(request.getParameter("id")));
		String pro_id = request.getParameter("pro_id");
		String pro_name = request.getParameter("pro_name");

		try {
			target = "/salenumbers.jsp?pro_id=" + pro_id + "&pro_name="
					+ pro_name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}
}
