/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.buz.entity.BuzApk;
import com.thinkgem.jeesite.modules.buz.dao.BuzApkDao;

/**
 * apk管理Service
 * @author xiejun
 * @version 2017-11-02
 */
@Service
@Transactional(readOnly = true)
public class BuzApkService extends CrudService<BuzApkDao, BuzApk> {

	public BuzApk get(String id) {
		return super.get(id);
	}
	
	public List<BuzApk> findList(BuzApk buzApk) {
		return super.findList(buzApk);
	}
	
	public Page<BuzApk> findPage(Page<BuzApk> page, BuzApk buzApk) {
		return super.findPage(page, buzApk);
	}
	
	@Transactional(readOnly = false)
	public void save(BuzApk buzApk) {
		super.save(buzApk);
	}
	
	@Transactional(readOnly = false)
	public void delete(BuzApk buzApk) {
		super.delete(buzApk);
	}
	
}