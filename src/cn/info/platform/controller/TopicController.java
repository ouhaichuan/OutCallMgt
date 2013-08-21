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
	 * 查找相关项目的题目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
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
	 * 添加问题
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "add_topic")
	public String add_topic(Topic topic, HttpServletRequest request) {
		String target = null;
		topicService.add_topic(topic);

		target = "/topic/find_all_topic.do";
		return target;
	}

	/**
	 * 更新题目
	 * 
	 * @param map
	 *            ModelMap
	 * @param topic
	 *            题目对象
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "save_topic")
	public String save_topic(Topic topic, HttpServletRequest request) {
		String target = null;
		topicService.save_topic(topic);

		target = "/topic/find_all_topic.do";

		return target;
	}

	/**
	 * 删除题目
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "del_topic", method = RequestMethod.GET)
	public String del_pro(HttpServletRequest request) {
		String target = null;
		topicService.del_topic(Integer.valueOf(request.getParameter("id")));

		target = "/topic/find_all_topic.do";
		return target;
	}
}
