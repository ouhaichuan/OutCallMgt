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
	 * 查询所有号码
	 */
	public List<SaleTelNumber> findAllNumbers(int pro_id) {
		return saleTelNumberDao.findAllNumbers(pro_id);
	}

	/**
	 * 添加号码
	 */
	public void add_num(SaleTelNumber saleTelNumber) {
		saleTelNumberDao.add_num(saleTelNumber);
	}

	/**
	 * 更新号码
	 */
	public void save_num(SaleTelNumber saleTelNumber) {
		saleTelNumberDao.save_num(saleTelNumber);
	}

	/**
	 * 删除号码
	 */
	public void del_num(int num_id) {
		saleTelNumberDao.del_num(num_id);
	}

	/**
	 * 导入号码
	 */
	public void import_num(SaleTelNumber saleTelNumber) {
		saleTelNumberDao.import_num(saleTelNumber);
	}

	/**
	 * 查询可以销售的号码
	 */
	public List<SaleTelNumber> find_cansale_numbers(int pro_id) {
		return saleTelNumberDao.find_cansale_numbers(pro_id);
	}

	/**
	 * 更新销售号码状态
	 */
	public void updateSaleNum(Map<String, String> map) {
		saleTelNumberDao.updateSaleNum(map);
	}

	/**
	 * 清除的关联销售号码
	 */
	public void delNumByProId(int pro_id) {
		saleTelNumberDao.delNumByProId(pro_id);
	}
}
