package com.example.shiro.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	/**
	 * 访问用户列表页面
	 * @return
	 */
	@RequestMapping("/userlist")
	@RequiresPermissions("userList")//我的用户并没有userList这个权限，所以访问不了
	public String userlist() {
		return "userInfo";
	}
	
	/**
	 * 访问用户增加页面
	 * @return
	 */
	@RequestMapping("/useradd")
	@RequiresRoles("admin")//我的用户并没有admin这个角色，所以访问不了
	public String useradd() {
		return "userAdd";
	}
	/**
	 * 访问用户删除页面
	 * @return
	 */
	@RequestMapping("/userdelete")
	public String userdelete() {
		return "userDelete";
	}
}