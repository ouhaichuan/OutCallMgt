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
import cn.info.platform.entity.Topic;
import cn.info.platform.service.TopicService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/topic/*")
public class TopicController {
	@Autowired
	private TopicService topicService;

	/**
	 * ���������Ŀ����Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "findTopicByProId")
	public void findalltopicByproId(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<Topic> list = topicService.findTopicByProId(Integer
				.valueOf(request.getParameter("pro_id")));
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * �������
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "add_topic")
	public String add_topic(Topic topic, HttpServletRequest request) {
		String target = null;
		topicService.add_topic(topic);

		try {
			target = "/topics.jsp?pro_id="
					+ topic.getPro_id()
					+ "&pro_name="
					+ new String(topic.getPro_name().getBytes("utf-8"),
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
	 * @param topic
	 *            ��Ŀ����
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "save_topic")
	public String save_topic(Topic topic, HttpServletRequest request) {
		String target = null;
		topicService.save_topic(topic);

		try {
			target = "/topics.jsp?pro_id="
					+ topic.getPro_id()
					+ "&pro_name="
					+ new String(topic.getPro_name().getBytes("utf-8"),
							"iso-8859-1");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return target;
	}

	/**
	 * ɾ����Ŀ
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "del_topic", method = RequestMethod.GET)
	public String del_topic(HttpServletRequest request) {
		String target = null;
		topicService.del_topic(Integer.valueOf(request.getParameter("id")));
		String pro_id = request.getParameter("pro_id");
		String pro_name = request.getParameter("pro_name");

		try {
			target = "/topics.jsp?pro_id=" + pro_id + "&pro_name=" + pro_name;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return target;
	}
}
