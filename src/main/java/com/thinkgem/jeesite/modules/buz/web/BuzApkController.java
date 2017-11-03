/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.buz.entity.BuzApk;
import com.thinkgem.jeesite.modules.buz.service.BuzApkService;

/**
 * apk管理Controller
 * @author xiejun
 * @version 2017-11-02
 */
@Controller
@RequestMapping(value = "${adminPath}/buz/buzApk")
public class BuzApkController extends BaseController {

	@Autowired
	private BuzApkService buzApkService;
	
	@ModelAttribute
	public BuzApk get(@RequestParam(required=false) String id) {
		BuzApk entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = buzApkService.get(id);
		}
		if (entity == null){
			entity = new BuzApk();
		}
		return entity;
	}
	
	@RequiresPermissions("buz:buzApk:view")
	@RequestMapping(value = {"list", ""})
	public String list(BuzApk buzApk, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BuzApk> page = buzApkService.findPage(new Page<BuzApk>(request, response), buzApk); 
		model.addAttribute("page", page);
		return "modules/buz/buzApkList";
	}

	@RequiresPermissions("buz:buzApk:view")
	@RequestMapping(value = "form")
	public String form(BuzApk buzApk, Model model) {
		model.addAttribute("buzApk", buzApk);
		return "modules/buz/buzApkForm";
	}

	@RequiresPermissions("buz:buzApk:edit")
	@RequestMapping(value = "save")
	public String save(BuzApk buzApk, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, buzApk)){
			return form(buzApk, model);
		}
		buzApkService.save(buzApk);
		addMessage(redirectAttributes, "保存apk信息成功");
		return "redirect:"+Global.getAdminPath()+"/buz/buzApk/?repage";
	}
	
	@RequiresPermissions("buz:buzApk:add")
	@RequestMapping(value = "add")
	public String add(BuzApk buzApk, Model model,
			RedirectAttributes redirectAttributes) {
		return save(buzApk, model, redirectAttributes);
	}
	@RequiresPermissions("buz:buzApk:delete")
	@RequestMapping(value = "delete")
	public String delete(BuzApk buzApk, RedirectAttributes redirectAttributes) {
		buzApkService.delete(buzApk);
		addMessage(redirectAttributes, "删除apk信息成功");
		return "redirect:"+Global.getAdminPath()+"/buz/buzApk/?repage";
	}

}