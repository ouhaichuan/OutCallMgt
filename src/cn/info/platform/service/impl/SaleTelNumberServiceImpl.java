package cn.info.platform.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.info.platform.dao.SaleTelNumberDao;
import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.service.SaleTelNumberService;

@Service
public class SaleTelNumberServiceImpl extends BaseServiceImpl<SaleTelNumber>
		implements SaleTelNumberService {
	private SaleTelNumberDao saleTelNumberDao;

	@Autowired
	public SaleTelNumberServiceImpl(SaleTelNumberDao saleTelNumberDao) {
		this.saleTelNumberDao = saleTelNumberDao;
		setBaseDao(saleTelNumberDao);
	}

	/**
	 * ��ѯ���к���
	 */
	public List<SaleTelNumber> findAllNumbers(int pro_id) {
		return saleTelNumberDao.findAllNumbers(pro_id);
	}

	/**
	 * ��Ӻ���
	 */
	public void add_num(SaleTelNumber saleTelNumber) {
		saleTelNumberDao.add_num(saleTelNumber);
	}

	/**
	 * ���º���
	 */
	public void save_num(SaleTelNumber saleTelNumber) {
		saleTelNumberDao.save_num(saleTelNumber);
	}

	/**
	 * ɾ������
	 */
	public void del_num(int num_id) {
		saleTelNumberDao.del_num(num_id);
	}

	/**
	 * �������
	 */
	public void import_num(SaleTelNumber saleTelNumber) {
		saleTelNumberDao.import_num(saleTelNumber);
	}

	/**
	 * ��ѯ�������۵ĺ���
	 */
	public List<SaleTelNumber> find_cansale_numbers(int pro_id) {
		return saleTelNumberDao.find_cansale_numbers(pro_id);
	}

	/**
	 * �������ۺ���״̬
	 */
	public void updateSaleNum(Map<String, String> map) {
		saleTelNumberDao.updateSaleNum(map);
	}

	/**
	 * ����Ĺ������ۺ���
	 */
	public void delNumByProId(int pro_id) {
		saleTelNumberDao.delNumByProId(pro_id);
	}
}
