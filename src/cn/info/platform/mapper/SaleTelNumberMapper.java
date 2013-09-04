package cn.info.platform.mapper;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.SaleTelNumber;

/**
 * 
 * @author HCOU
 * 
 */
public interface SaleTelNumberMapper extends BaseMapper<SaleTelNumber> {

	/**
	 * ��ѯ���к���
	 * 
	 * @param pro_id
	 * 
	 * @return
	 */
	List<SaleTelNumber> findAllNumbers(int pro_id);

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
}
