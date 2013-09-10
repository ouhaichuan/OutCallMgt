package cn.info.platform.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import cn.info.platform.entity.CallObject;
import cn.info.platform.entity.Project;
import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.entity.Topic;
import cn.info.platform.entity.User;
import cn.info.platform.service.CallObjectService;
import cn.info.platform.service.ProjectService;
import cn.info.platform.service.SaleTelNumberService;
import cn.info.platform.service.TopicService;
import cn.info.platform.service.UserService;
import cn.info.platform.util.FileUtil;

/**
 * @author HCOU
 */
@Controller
@RequestMapping("/file/*")
public class FileUploaderController {
	@Autowired
	private CallObjectService callObjectService;
	@Autowired
	private TopicService topicService;
	@Autowired
	private SaleTelNumberService saleTelNumberService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProjectService projectService;

	/**
	 * �����ϴ��ļ���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "object", method = RequestMethod.POST)
	public void objectUpload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String pro_id = "";
			if (null != request.getParameter("pro_id")) {
				pro_id = new String(request.getParameter("pro_id").getBytes(
						"iso-8859-1"), "utf-8");
			}
			FileUtil fileUtil = new FileUtil();
			fileUtil.uploadFile(request, response);// �ϴ��ļ�
			for (String fileName : fileUtil.fileNameList) {
				for (List<String> list : fileUtil.readExcel(fileName, 3)) {
					for (int i = 0; i < list.size(); i += 3) {// ѭ����Ӷ�����¼�����ݿ�
						CallObject obj = new CallObject();
						obj.setObject_pnumber(list.get(i));
						obj.setPro_id(pro_id);
						obj.setColumn1(list.get(i + 1));
						obj.setColumn2(list.get(i + 2));

						callObjectService.import_obj(obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �����ϴ��ļ���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "topic", method = RequestMethod.POST)
	public void topicUpload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String pro_id = "";
			if (null != request.getParameter("pro_id")) {
				pro_id = new String(request.getParameter("pro_id").getBytes(
						"iso-8859-1"), "utf-8");
			}
			FileUtil fileUtil = new FileUtil();
			fileUtil.uploadFile(request, response);// �ϴ��ļ�
			for (String fileName : fileUtil.fileNameList) {
				for (List<String> list : fileUtil.readExcel(fileName, 1)) {
					Topic topic = new Topic();
					topic.setPro_id(Integer.valueOf(pro_id));
					topic.setTopic_content(list.get(0));

					topicService.import_topic(topic);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ���ۺ��봦���ϴ��ļ���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "num", method = RequestMethod.POST)
	public void numUpload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String pro_id = "";
			if (null != request.getParameter("pro_id")) {
				pro_id = new String(request.getParameter("pro_id").getBytes(
						"iso-8859-1"), "utf-8");
			}
			FileUtil fileUtil = new FileUtil();
			fileUtil.uploadFile(request, response);// �ϴ��ļ�
			for (String fileName : fileUtil.fileNameList) {
				for (List<String> list : fileUtil.readExcel(fileName, 1)) {
					SaleTelNumber saleTelNumber = new SaleTelNumber();
					saleTelNumber.setPro_id(pro_id);
					saleTelNumber.setTelnumber(list.get(0));

					saleTelNumberService.import_num(saleTelNumber);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * �û����봦���ϴ��ļ���
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "user", method = RequestMethod.POST)
	public void userUpload(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			FileUtil fileUtil = new FileUtil();
			fileUtil.uploadFile(request, response);// �ϴ��ļ�
			for (String fileName : fileUtil.fileNameList) {
				for (List<String> list : fileUtil.readExcel(fileName, 4)) {
					for (int i = 0; i < list.size(); i += 4) {
						User user = new User();

						user.setUserName(list.get(i));
						user.setUser_phone(list.get(i + 1));
						user.setUser_channel(list.get(i + 2));
						user.setUser_xm(list.get(i + 3));

						userService.import_user(user);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������Ŀͳ��������
	 * 
	 * @param request
	 *            ����Ķ���
	 * @return Ҫ��ת��ҳ��
	 */
	@RequestMapping(value = "exportData")
	public void exportData(HttpServletRequest request,
			HttpServletResponse response) {
		String start_date = request.getParameter("start_date");
		String end_date = request.getParameter("end_date");

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start_date", start_date);
		map.put("end_date", end_date);

		List<Project> listPro = null;
		listPro = projectService.staticsData(map);

		List<User> listUser = null;
		listUser = userService.staticsData(map);

		try {
			request.setCharacterEncoding("utf-8");
			// ��ֹ���ݻ��档
			response.setHeader("Pragma", "no-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			// ������Ӧ�����͸�ʽΪ���ӱ���ʽ
			response.setContentType("application/vnd.ms-excel;charset=utf-8");

			// �����������Servlet������С�
			ServletOutputStream sos = response.getOutputStream();

			sos.flush();
			sos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
