/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.buz.entity.BuzCustomer;
import com.thinkgem.jeesite.modules.buz.dao.BuzCustomerDao;

/**
 * 用户管理Service
 * @author xiejun
 * @version 2017-11-01
 */
@Service
@Transactional(readOnly = true)
public class BuzCustomerService extends CrudService<BuzCustomerDao, BuzCustomer> {

	public BuzCustomer get(String id) {
		return super.get(id);
	}
	
	public List<BuzCustomer> findList(BuzCustomer buzCustomer) {
		return super.findList(buzCustomer);
	}
	
	public Page<BuzCustomer> findPage(Page<BuzCustomer> page, BuzCustomer buzCustomer) {
		return super.findPage(page, buzCustomer);
	}
	
	@Transactional(readOnly = false)
	public void save(BuzCustomer buzCustomer) {
		super.save(buzCustomer);
	}
	
	@Transactional(readOnly = false)
	public void delete(BuzCustomer buzCustomer) {
		super.delete(buzCustomer);
	}
	
}