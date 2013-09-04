package cn.info.platform.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import cn.info.platform.dao.SaleTelNumberDao;
import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.mapper.SaleTelNumberMapper;

/**
 * @author HCOU
 */
@Repository
public class SaleTelNumberDaoImpl extends
		BaseDaoImpl<SaleTelNumber, SaleTelNumberMapper> implements
		SaleTelNumberDao {
	public SaleTelNumberDaoImpl() {
		setMapperClass(SaleTelNumberMapper.class);
	}

	/**
	 * ��ѯ���к���
	 */
	public List<SaleTelNumber> findAllNumbers(int pro_id) {
		return this.getMapper().findAllNumbers(pro_id);
	}

	/**
	 * ��Ӻ���
	 */
	public void add_num(SaleTelNumber saleTelNumber) {
		this.getMapper().add_num(saleTelNumber);
	}

	/**
	 * ���º���
	 */
	public void save_num(SaleTelNumber saleTelNumber) {
		this.getMapper().save_num(saleTelNumber);
	}

	/**
	 * ɾ������
	 */
	public void del_num(int num_id) {
		this.getMapper().del_num(num_id);
	}

	/**
	 * �������
	 */
	public void import_num(SaleTelNumber saleTelNumber) {
		this.getMapper().import_num(saleTelNumber);
	}

	/**
	 * ��ѯ�������۵ĺ���
	 */
	public List<SaleTelNumber> find_cansale_numbers(int pro_id) {
		return this.getMapper().find_cansale_numbers(pro_id);
	}

	/**
	 * �������ۺ���״̬
	 */
	public void updateSaleNum(Map<String, String> map) {
		this.getMapper().updateSaleNum(map);
	}

	/**
	 * ����Ĺ������ۺ���
	 */
	public void delNumByProId(int pro_id) {
		this.getMapper().delNumByProId(pro_id);
	}
}
