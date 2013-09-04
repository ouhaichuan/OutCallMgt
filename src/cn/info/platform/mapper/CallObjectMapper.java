package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.CallObject;

/**
 * 
 * @author HCOU
 * 
 */
public interface CallObjectMapper extends BaseMapper<CallObject> {
	/**
	 * �õ����е��������
	 * 
	 * @return
	 */
	List<CallObject> findAllCallObject();

	/**
	 * ��Ӻ���
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
	 * ��ѯ������Ŀ�ĺ���
	 * 
	 * @param pro_id
	 * @param user_name
	 * @return
	 */
	List<CallObject> findCallObjectByProId(Map<String, Object> map);

	/**
	 * �ύ�쳣
	 * 
	 * @param object
	 */
	void commitError(CallObject object);

	/**
	 * ����
	 * 
	 * @param obj
	 */
	void import_obj(CallObject obj);

	/**
	 * ��ѯ������Ŀ�ĺ���
	 * 
	 * @param map
	 * @return
	 */
	List<CallObject> findCallObjectByProIdNoUser(Map<String, Object> map);

	/**
	 * ������ĿIDɾ������
	 * 
	 * @param pro_id
	 */
	void del_objByProId(int pro_id);
}
