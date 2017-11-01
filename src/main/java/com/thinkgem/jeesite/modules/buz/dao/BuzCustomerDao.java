/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.buz.entity.BuzCustomer;

/**
 * 用户管理DAO接口
 * @author xiejun
 * @version 2017-11-01
 */
@MyBatisDao
public interface BuzCustomerDao extends CrudDao<BuzCustomer> {
	
}