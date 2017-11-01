/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 用户管理Entity
 * 
 * @author xiejun
 * @version 2017-11-01
 */
public class BuzCustomer extends DataEntity<BuzCustomer> {

	private static final long serialVersionUID = 1L;
	private String phone; // 手机号
	private String name; // 姓名
	private String password; // 密码
	private String newpassword; // 新密码
	private String position; // 职位
	private String email; // 邮箱

	public BuzCustomer() {
		super();
	}

	public BuzCustomer(String id) {
		super(id);
	}

	@Length(min = 1, max = 64, message = "手机号长度必须介于 1 和 64 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Length(min = 0, max = 200, message = "姓名长度必须介于 0 和 200 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Length(min = 0, max = 64, message = "职位长度必须介于 0 和 64 之间")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Length(min = 0, max = 64, message = "邮箱长度必须介于 0 和 64 之间")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

}