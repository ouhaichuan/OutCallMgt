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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.info.platform.entity.CallObject;
import cn.info.platform.entity.User;
import cn.info.platform.service.CallObjectService;
import cn.info.platform.service.ObjectUserService;
import cn.info.platform.service.ProjectUserService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/callobject/*")
public class CallObjectController {
	@Autowired
	private CallObjectService callObjectService;
	@Autowired
	private ObjectUserService objectUserService;
	@Autowired
	private ProjectUserService projectUserService;

	/**
	 * �������ж���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "findCallObjectByProId")
	public void findCallObjectByProId(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		int pro_id = Integer.valueOf(request.getParameter("pro_id"));

		String search_txt = "";
		if (null != request.getParameter("search_txt")) {
			search_txt = request.getParameter("search_txt");
		}

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		map.put("search_txt", search_txt);

		List<CallObject> list = callObjectService
				.findCallObjectByProIdNoUser(map);
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���Ҹ�����Ŀ��״̬����
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "findCallObjectByProIdAndState")
	public void findCallObjectByProIdAndState(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		int pro_id = Integer.valueOf(request.getParameter("pro_id"));
		int state = Integer.valueOf(request.getParameter("state"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pro_id", pro_id);
		map.put("state", state);

		List<CallObject> list = callObjectService
				.findCallObjectByProIdAndState(map);// ����״̬����Ŀ��ѯ����
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������Ŀ���û���ѯ����
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "findCallObjectByUserAndState")
	public void findCallObjectByUserAndState(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		String user_name = request.getParameter("user_name");
		int state = Integer.valueOf(request.getParameter("state"));

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_name", user_name);
		map.put("state", state);

		List<CallObject> list = callObjectService
				.findCallObjectByUserAndState(map);// ����״̬���û���ѯ����
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
	public String add_obj(Model model, CallObject obj,
			HttpServletRequest request) {
		String target = null;
		callObjectService.add_obj(obj);
		try {
			target = "/callobjects.jsp?pro_id="
					+ obj.getPro_id()
					+ "&pro_name="
					+ new String(obj.getPro_name().getBytes("utf-8"),
							"iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
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

		try {
			target = "/callobjects.jsp?pro_id="
					+ obj.getPro_id()
					+ "&pro_name="
					+ new String(obj.getPro_name().getBytes("utf-8"),
							"iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	public String del_objByObjectid(HttpServletRequest request) {
		String target = null;

		String pro_id = request.getParameter("pro_id");
		String pro_name = request.getParameter("pro_name");
		int object_id = Integer.valueOf(request.getParameter("id"));

		String user_name = objectUserService.getUserNameByObjectId(object_id);// �õ�Ҫɾ������󶨵��û�
		callObjectService.del_obj(object_id);// ɾ�����������ĺ���
		objectUserService.delObjByObjectId(object_id);// ɾ��������ĺ���

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_name", user_name);
		map.put("pro_id", pro_id);
		int counts = objectUserService.getCountsByUserName(map);// �õ�ɾ����İ󶨺�������
		map.put("object_num", counts);

		// ������Ŀ�û��󶨱�
		if (counts == 0) {
			projectUserService.delBindByMap(map);// �����û�������Ŀ��ɾ���󶨼�¼
		} else {
			projectUserService.updateBindByMap(map);// �����û���Ŀ�󶨱�İ���Ŀ
		}

		try {
			target = "/callobjects.jsp?pro_id=" + pro_id + "&pro_name="
					+ pro_name;
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		String user_name = ((User) request.getSession().getAttribute("user"))
				.getUserName();

		response.setContentType("text/html; charset=utf-8");
		int object_id = Integer.valueOf((String) request
				.getParameter("object_id"));
		String object_state = (String) request.getParameter("object_state");
		String out_time = (String) request.getParameter("out_time");

		CallObject object = new CallObject();
		object.setObject_id(object_id);
		object.setObject_state(object_state);
		object.setOut_time(out_time);
		object.setCall_user(user_name);

		callObjectService.commitError(object);// �ύ�쳣

		try {
			response.getWriter().write("״̬�ύ���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
