package cn.info.platform.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import cn.info.platform.entity.Answer;
import cn.info.platform.entity.CallObject;
import cn.info.platform.entity.User;
import cn.info.platform.service.AnswerService;
import cn.info.platform.service.CallObjectService;
import cn.info.platform.service.SaleTelNumberService;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/answer/*")
public class AnswerController {
	@Autowired
	private AnswerService answerService;
	@Autowired
	private CallObjectService callObjectService;
	@Autowired
	private SaleTelNumberService saleTelNumberService;

	/**
	 * 添加答案
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "addAnswer", method = RequestMethod.POST)
	public void addAnswer(HttpServletRequest request,
			HttpServletResponse response) {
		String user_name = ((User) request.getSession().getAttribute("user"))
				.getUserName();
		String out_time = request.getParameter("out_time");
		String saletelnum = request.getParameter("saletelnum");

		response.setContentType("text/html; charset=utf-8");
		String dataArry_str = request.getParameter("dataArray");

		String[] dataArray = dataArry_str.split("\\^");
		int object_id = 0;
		for (int i = 0; i < dataArray.length; i += 3) {
			object_id = Integer.valueOf(dataArray[i + 1]);

			Answer answer = new Answer();
			answer.setTopic_id(Integer.valueOf(dataArray[i]));
			answer.setObject_id(Integer.valueOf(dataArray[i + 1]));
			answer.setAnswer_content(dataArray[i + 2]);
			answerService.addAnswer(answer);// 提交答案
		}
		// 更新号码状态
		CallObject object = new CallObject();
		object.setObject_id(object_id);
		object.setObject_state("2");
		object.setCall_user(user_name);
		object.setOut_time(out_time);

		callObjectService.commitError(object);// 提交状态

		if (null != saletelnum && !"".equals(saletelnum)) {
			SimpleDateFormat format = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			String sale_time = format.format(new Date());

			Map<String, String> map = new HashMap<String, String>();
			map.put("telnumber", saletelnum);
			map.put("user_name", user_name);
			map.put("sale_time", sale_time);
			map.put("num_state", "已售");
			saleTelNumberService.updateSaleNum(map);// 更新号码状态
		}

		try {
			response.getWriter().write("提交完成");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加答案
	 * 
	 * @param request
	 *            请求的对象
	 * @return 要跳转的页面
	 */
	@RequestMapping(value = "find_all_answer")
	public void findAllAnswer(HttpServletRequest request,
			HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");

		List<Answer> list = answerService.findAllAnswer();
		JSONArray jsonArray = JSONArray.fromObject(list);
		try {
			response.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
