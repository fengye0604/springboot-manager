package com.example.shiro.service.impl;

import com.example.shiro.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
    public User selectByNameUser(String username) {
        return new User();
    }
}
