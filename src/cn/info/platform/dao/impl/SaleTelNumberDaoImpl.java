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
	 * 查询所有号码
	 */
	public List<SaleTelNumber> findAllNumbers(int pro_id) {
		return this.getMapper().findAllNumbers(pro_id);
	}

	/**
	 * 添加号码
	 */
	public void add_num(SaleTelNumber saleTelNumber) {
		this.getMapper().add_num(saleTelNumber);
	}

	/**
	 * 更新号码
	 */
	public void save_num(SaleTelNumber saleTelNumber) {
		this.getMapper().save_num(saleTelNumber);
	}

	/**
	 * 删除号码
	 */
	public void del_num(int num_id) {
		this.getMapper().del_num(num_id);
	}

	/**
	 * 导入号码
	 */
	public void import_num(SaleTelNumber saleTelNumber) {
		this.getMapper().import_num(saleTelNumber);
	}

	/**
	 * 查询可以销售的号码
	 */
	public List<SaleTelNumber> find_cansale_numbers(int pro_id) {
		return this.getMapper().find_cansale_numbers(pro_id);
	}

	/**
	 * 更新销售号码状态
	 */
	public void updateSaleNum(Map<String, String> map) {
		this.getMapper().updateSaleNum(map);
	}

	/**
	 * 清除的关联销售号码
	 */
	public void delNumByProId(int pro_id) {
		this.getMapper().delNumByProId(pro_id);
	}
}
