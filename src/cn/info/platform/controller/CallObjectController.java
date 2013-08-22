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
	 * �������ж���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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
	 * ��Ӻ���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "add_obj", method = RequestMethod.POST)
	public String add_obj(CallObject obj, HttpServletRequest request) {
		String target = null;
		callObjectService.add_obj(obj);

		target = "/callobjects.jsp";
		return target;
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
	@RequestMapping(value = "save_obj", method = RequestMethod.POST)
	public String save_obj(CallObject obj, HttpServletRequest request) {
		String target = null;

		callObjectService.save_obj(obj);

		target = "/callobjects.jsp";
		return target;
	}

	/**
	 * ɾ������
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "del_obj", method = RequestMethod.GET)
	public String del_obj(HttpServletRequest request) {
		String target = null;
		callObjectService.del_obj(Integer.valueOf(request.getParameter("id")));
		target = "/callobjects.jsp";
		return target;
	}

	/**
	 * �ύ�쳣
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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

		callObjectService.commitError(object);// �ύ�쳣

		try {
			response.getWriter().write("�쳣�ύ���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
