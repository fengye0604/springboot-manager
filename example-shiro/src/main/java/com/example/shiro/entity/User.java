package com.example.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class User {
    public User(){
    }
    public User(String id, String userName, String password, Set<Role> roles){
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
    }
    private String id;
    private String userName;
    private String password;
    private String Salt;
    /**
     * 用户对应的角色集合
     */
    private Set<Role> roles;

}