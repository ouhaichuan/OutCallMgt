package cn.info.platform.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
	@RequestMapping(value = "find_all_topic")
	public String findAllTopic(HttpServletRequest request) {
		String target = null;
		List<Topic> list = topicService.findAllTopic();
		request.setAttribute("topic_list", list);

		target = "/topics.jsp";

		return target;
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

		target = "/topic/find_all_topic.do";
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

		target = "/topic/find_all_topic.do";

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
	public String del_pro(HttpServletRequest request) {
		String target = null;
		topicService.del_topic(Integer.valueOf(request.getParameter("id")));

		target = "/topic/find_all_topic.do";
		return target;
	}
}
