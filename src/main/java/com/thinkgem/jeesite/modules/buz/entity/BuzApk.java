/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.buz.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * apk管理Entity
 * @author xiejun
 * @version 2017-11-02
 */
public class BuzApk extends DataEntity<BuzApk> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名称
	private String edition;		// 版本号
	private String type;		// 类型
	private String path;		// 文件
	
	public BuzApk() {
		super();
	}

	public BuzApk(String id){
		super(id);
	}

	@Length(min=0, max=64, message="名称长度必须介于 0 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=200, message="版本号长度必须介于 1 和 200 之间")
	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
	@Length(min=1, max=200, message="类型长度必须介于 1 和 200 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=64, message="文件长度必须介于 0 和 64 之间")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}