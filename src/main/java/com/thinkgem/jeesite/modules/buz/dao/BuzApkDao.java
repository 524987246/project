/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.buz.entity.BuzApk;

/**
 * apk管理DAO接口
 * @author xiejun
 * @version 2017-11-02
 */
@MyBatisDao
public interface BuzApkDao extends CrudDao<BuzApk> {
	
}