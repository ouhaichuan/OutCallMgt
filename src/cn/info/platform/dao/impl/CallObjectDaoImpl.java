package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.CallObjectDao;
import cn.info.platform.entity.CallObject;
import cn.info.platform.mapper.CallObjectMapper;

/**
 * @author HCOU
 */
@Repository
public class CallObjectDaoImpl extends
		BaseDaoImpl<CallObject, CallObjectMapper> implements CallObjectDao {
	public CallObjectDaoImpl() {
		setMapperClass(CallObjectMapper.class);
	}

	/**
	 * ��Ӻ���
	 */
	public void add_obj(CallObject obj) {
		this.getMapper().add_obj(obj);
	}

	/**
	 * ���º���
	 */
	public void save_obj(CallObject obj) {
		this.getMapper().save_obj(obj);
	}

	/**
	 * ɾ������
	 */
	public void del_obj(int id) {
		this.getMapper().del_obj(id);
	}

	/**
	 * ��ѯ������Ŀ�������ĺ���
	 */
	public List<CallObject> findCallObjectByProId(Map<String, Object> map) {
		return this.getMapper().findCallObjectByProId(map);
	}

	/**
	 * �ύ�쳣
	 */
	public void commitError(CallObject object) {
		this.getMapper().commitError(object);
	}

	/**
	 * ����
	 */
	public void import_obj(CallObject obj) {
		this.getMapper().import_obj(obj);
	}

	/**
	 * ��ѯ������Ŀ�ĺ���
	 */
	public List<CallObject> findCallObjectByProIdNoUser(Map<String, Object> map) {
		return this.getMapper().findCallObjectByProIdNoUser(map);
	}

	/**
	 * ������ĿIDɾ������
	 */
	public void del_objByProId(int pro_id) {
		this.getMapper().del_objByProId(pro_id);
	}
}
