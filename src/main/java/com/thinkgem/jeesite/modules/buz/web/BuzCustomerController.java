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
import com.thinkgem.jeesite.modules.buz.entity.BuzCustomer;
import com.thinkgem.jeesite.modules.buz.service.BuzCustomerService;

/**
 * 用户管理Controller
 * 
 * @author xiejun
 * @version 2017-11-01
 */
@Controller
@RequestMapping(value = "${adminPath}/buz/buzCustomer")
public class BuzCustomerController extends BaseController {

	@Autowired
	private BuzCustomerService buzCustomerService;

	@ModelAttribute
	public BuzCustomer get(@RequestParam(required = false) String id) {
		BuzCustomer entity = null;
		if (StringUtils.isNotBlank(id)) {
			entity = buzCustomerService.get(id);
		}
		if (entity == null) {
			entity = new BuzCustomer();
		}
		return entity;
	}

	@RequiresPermissions("buz:buzCustomer:view")
	@RequestMapping(value = { "list", "" })
	public String list(BuzCustomer buzCustomer, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<BuzCustomer> page = buzCustomerService.findPage(new Page<BuzCustomer>(request, response), buzCustomer);
		model.addAttribute("page", page);
		return "modules/buz/buzCustomerList";
	}

	@RequiresPermissions("buz:buzCustomer:view")
	@RequestMapping(value = "form")
	public String form(BuzCustomer buzCustomer, Model model) {
		model.addAttribute("buzCustomer", buzCustomer);
		return "modules/buz/buzCustomerForm";
	}

	@RequiresPermissions("buz:buzCustomer:edit")
	@RequestMapping(value = "save")
	public String save(BuzCustomer buzCustomer, Model model, RedirectAttributes redirectAttributes) {
		
		if (!beanValidator(model, buzCustomer)) {
			return form(buzCustomer, model);
		}
		buzCustomerService.save(buzCustomer);
		addMessage(redirectAttributes, "保存用户信息成功");
		return "redirect:" + Global.getAdminPath() + "/buz/buzCustomer/?repage";
	}

	@RequiresPermissions("buz:buzCustomer:add")
	@RequestMapping(value = "add")
	public String add(BuzCustomer buzCustomer, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, buzCustomer)) {
			return form(buzCustomer, model);
		}
		return save(buzCustomer, model, redirectAttributes);
	}

	@RequiresPermissions("buz:buzCustomer:delete")
	@RequestMapping(value = "delete")
	public String delete(BuzCustomer buzCustomer, RedirectAttributes redirectAttributes) {
		buzCustomerService.delete(buzCustomer);
		addMessage(redirectAttributes, "删除用户信息成功");
		return "redirect:" + Global.getAdminPath() + "/buz/buzCustomer/?repage";
	}

}