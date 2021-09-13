package com.example.shiro.config;

import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.service.impl.PermissionDaoService;
import com.example.shiro.service.impl.RoleDaoService;
import com.example.shiro.service.impl.UserDaoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
 
	@Autowired
	private UserDaoService userDaoService;
	@Autowired
	private RoleDaoService roleDaoService;
	@Autowired
	private PermissionDaoService permissionDaoService;
	
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 能进入到这里，表示账号已经通过验证了
		String username = (String) principals.getPrimaryPrincipal();
		User user = userDaoService.selectByNameUser(username);
		//先把所拥有的角色给获取
//		Set<String> roleString = roleDaoService.selectByUserIdString(user.getUserId());
		Set<String> roleString = new HashSet<>();
		//查询该用户所拥有的角色
//		List<Role> roleList = roleDaoService.selectByUserIdRoles(user.getUserId());
		List<Role> roleList = (List<Role>) new HashSet<Role>();

		//查询所有角色所拥有的权限
		Set<String> perms = new HashSet<>();
		for(Role role : roleList) {
//			Set<String> permString = permissionDaoService.selectByRoleIdPermissionString(role.getRoleId());
			Set<String> permString = new HashSet<>();
			perms.addAll(permString);
		}
		
		// 授权对象
		SimpleAuthorizationInfo s = new SimpleAuthorizationInfo();
		// 把通过DAO获取到的角色和权限放进去
		s.setStringPermissions(perms);
		s.setRoles(roleString);
		return s;
	}
 
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		//获取登陆的用户名和密码
		UsernamePasswordToken t = (UsernamePasswordToken) token;
		String username = token.getPrincipal().toString();
		String password = new String(t.getPassword());
		//从数据库中获取登陆的用户
		User user = userDaoService.selectByNameUser(username);
		if(null==user) {
			System.out.println("没找到此用户");
			throw new AuthenticationException();
		}
		//把用户输入的密码进行md5和盐加密一起运算两次
		String encodedPassword = new SimpleHash("md5", password, user.getSalt(), 2).toString();
		if (!user.getPassword().equals(encodedPassword)) {
			System.out.println("密码错误");
			throw new AuthenticationException();
		}
		// 认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
		SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(username, password, getName());
		return a;
	}
 
}