package cn.info.platform.dao;

import java.util.List;
import java.util.Map;

import cn.info.platform.entity.SaleTelNumber;
import cn.info.platform.mapper.SaleTelNumberMapper;

/**
 * User实体类对应的数据操作类接口
 * 
 * @author HCOU
 * 
 */
public interface SaleTelNumberDao extends
		BaseDao<SaleTelNumber, SaleTelNumberMapper> {

	/**
	 * 查询所有号码
	 * 
	 * @param map
	 * 
	 * @return
	 */
	List<SaleTelNumber> findAllNumbers(Map<String, Object> map);

	/**
	 * 添加号码
	 * 
	 * @param saleTelNumber
	 */
	void add_num(SaleTelNumber saleTelNumber);

	/**
	 * 更新号码
	 * 
	 * @param saleTelNumber
	 */
	void save_num(SaleTelNumber saleTelNumber);

	/**
	 * 删除号码
	 * 
	 * @param num_id
	 */
	void del_num(int num_id);

	/**
	 * 导入号码
	 * 
	 * @param saleTelNumber
	 */
	void import_num(SaleTelNumber saleTelNumber);

	/**
	 * 查询可以销售的号码
	 * 
	 * @param pro_id
	 * @return
	 */
	List<SaleTelNumber> find_cansale_numbers(int pro_id);

	/**
	 * 更新销售号码状态
	 * 
	 * @param map
	 */
	void updateSaleNum(Map<String, String> map);

	/**
	 * 清除的关联销售号码
	 * 
	 * @param pro_id
	 */
	void delNumByProId(int pro_id);

	/**
	 * 检查号码状态
	 * 
	 * @param saletelnum
	 * @return
	 */
	String checkNumState(String saletelnum);
}
