package cn.info.platform.service;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.CallObject;

/**
 * CallObjectʵ�����Ӧ��ҵ�������ӿ�
 * 
 * @author HCOU
 */
public interface CallObjectService extends BaseService<CallObject> {
	/**
	 * �õ����е��������
	 * 
	 * @return �����б�
	 */
	List<CallObject> findAllCallObject();

	/**
	 * ���Ӻ���
	 * 
	 * @param obj
	 */
	void add_obj(CallObject obj);

	/**
	 * ���º���
	 * 
	 * @param obj
	 */
	void save_obj(CallObject obj);

	/**
	 * ɾ������
	 * 
	 * @param id
	 */
	void del_obj(int id);

	/**
	 * ��ѯ�����Ŀ�ĺ���
	 * 
	 * @param pro_id
	 * @param user_name
	 * 
	 * @return
	 */
	List<CallObject> findCallObjectByProId(Map<String, Object> map);

	/**
	 * �ύ�쳣
	 * 
	 * @param object
	 */
	void commitError(CallObject object);
}