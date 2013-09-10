package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.mapper.SaleTelNumberMapper;

/**
 * Userʵ�����Ӧ�����ݲ�����ӿ�
 * 
 * @author HCOU
 * 
 */
public interface SaleTelNumberDao extends
		BaseDao<SaleTelNumber, SaleTelNumberMapper> {

	/**
	 * ��ѯ���к���
	 * 
	 * @param map
	 * 
	 * @return
	 */
	List<SaleTelNumber> findAllNumbers(Map<String, Object> map);

	/**
	 * ��Ӻ���
	 * 
	 * @param saleTelNumber
	 */
	void add_num(SaleTelNumber saleTelNumber);

	/**
	 * ���º���
	 * 
	 * @param saleTelNumber
	 */
	void save_num(SaleTelNumber saleTelNumber);

	/**
	 * ɾ������
	 * 
	 * @param num_id
	 */
	void del_num(int num_id);

	/**
	 * �������
	 * 
	 * @param saleTelNumber
	 */
	void import_num(SaleTelNumber saleTelNumber);

	/**
	 * ��ѯ�������۵ĺ���
	 * 
	 * @param pro_id
	 * @return
	 */
	List<SaleTelNumber> find_cansale_numbers(int pro_id);

	/**
	 * �������ۺ���״̬
	 * 
	 * @param map
	 */
	void updateSaleNum(Map<String, String> map);

	/**
	 * ����Ĺ������ۺ���
	 * 
	 * @param pro_id
	 */
	void delNumByProId(int pro_id);

	/**
	 * ������״̬
	 * 
	 * @param saletelnum
	 * @return
	 */
	String checkNumState(String saletelnum);
}
