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
import cn.info.platform.entity.Answer;
import cn.info.platform.entity.CallObject;
import cn.info.platform.service.AnswerService;
import cn.info.platform.service.CallObjectService;

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

	/**
	 * ��Ӵ�
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "addAnswer", method = RequestMethod.POST)
	public void addAnswer(HttpServletRequest request,
			HttpServletResponse response) {
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
			answerService.addAnswer(answer);// �ύ��
		}
		// ���º���״̬
		CallObject object = new CallObject();
		object.setObject_id(object_id);
		object.setObject_state("2");

		callObjectService.commitError(object);// �ύ״̬
		try {
			response.getWriter().write("�ύ���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��Ӵ�
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
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
