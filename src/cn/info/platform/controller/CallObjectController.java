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
import cn.info.platform.entity.CallObject;
import cn.info.platform.service.CallObjectService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/callobject/*")
public class CallObjectController {
	@Autowired
	private CallObjectService callObjectService;

	/**
	 * 查找所有对象
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_all_callobject")
	public void findAllCallObject(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<CallObject> list = callObjectService.findAllCallObject();
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
	@RequestMapping(value = "add_obj", method = RequestMethod.POST)
	public String add_obj(CallObject obj, HttpServletRequest request) {
		String target = null;
		callObjectService.add_obj(obj);

		target = "/callobjects.jsp";
		return target;
	}

	/**
	 * 更新项目
	 * 
	 * @param map
	 *            ModelMap
	 * @param project
	 *            项目保存对象
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "save_obj", method = RequestMethod.POST)
	public String save_obj(CallObject obj, HttpServletRequest request) {
		String target = null;

		callObjectService.save_obj(obj);

		target = "/callobjects.jsp";
		return target;
	}

	/**
	 * 删除号码
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "del_obj", method = RequestMethod.GET)
	public String del_obj(HttpServletRequest request) {
		String target = null;
		callObjectService.del_obj(Integer.valueOf(request.getParameter("id")));
		target = "/callobjects.jsp";
		return target;
	}

	/**
	 * 提交异常
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "commitError", method = RequestMethod.POST)
	public void commitError(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		int object_id = Integer.valueOf((String) request
				.getParameter("object_id"));
		String object_state = (String) request.getParameter("object_state");

		CallObject object = new CallObject();
		object.setObject_id(object_id);
		object.setObject_state(object_state);

		callObjectService.commitError(object);// 提交异常

		try {
			response.getWriter().write("异常提交完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
