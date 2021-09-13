package com.example.shiro.service.impl;


import com.example.shiro.entity.Permissions;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.service.LoginService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class LoginServiceImpl implements LoginService {
    static Map<String, User> map = new HashMap<>();
    static{

        Permissions permissions1 = new Permissions("1", "query");
        Permissions permissions2 = new Permissions("2", "add");
        Permissions permissions3 = new Permissions("3", "list");

//        设置第一个用户
//        设置权限
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        permissionsSet.add(permissions3);
//        设置角色
        Role role = new Role("1", "admin", permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
//        添加用户
        User user = new User("1", "lisi", "123456", roleSet);
        map.put(user.getUserName(), user);

//        设置第二个用户
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions1);
        permissionsSet1.add(permissions3);

        Role role1 = new Role("2", "user", permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);

        User user1 = new User("2", "zhangsan", "123456", roleSet1);
        map.put(user1.getUserName(), user1);
    }

    @Override
    public User getUserByName(String getMapByName) {
        return getMapByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     *
     * @param userName 用户名
     * @return User
     */
    private User getMapByName(String userName) {
        return map.get(userName);
    }
}