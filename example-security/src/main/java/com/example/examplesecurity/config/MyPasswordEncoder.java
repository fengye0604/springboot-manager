package com.example.examplesecurity.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        System.out.println("encode!");
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        System.out.println("matches!");
        return s.equals(charSequence.toString());
    }

}
