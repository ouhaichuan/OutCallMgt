package cn.info.platform.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.info.platform.entity.CallObject;
import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.entity.Topic;
import cn.info.platform.service.CallObjectService;
import cn.info.platform.service.SaleTelNumberService;
import cn.info.platform.service.TopicService;
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
				for (List<String> list : fileUtil.readExcel(fileName)) {
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
				for (List<String> list : fileUtil.readExcel(fileName)) {
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
				for (List<String> list : fileUtil.readExcel(fileName)) {
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
}
