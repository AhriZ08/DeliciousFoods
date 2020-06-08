package com.example.deliciousfoods.service;

import com.example.deliciousfoods.entities.LoginRt;
import com.example.deliciousfoods.entities.User;
import com.example.deliciousfoods.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public LoginRt insertOneUser(String tel, String pwd){
        String reTel = userMapper.findUserByTel(tel);
        LoginRt loginRt = new LoginRt();
        if (reTel != null){
            loginRt.setStatus(false);
            loginRt.setMsg("Register Error!");
        }else {
            User user = new User();
            user.setUser_LoginName(tel);
            user.setUser_Freeze(0);
            user.setUser_Money(100);
            user.setUser_Name(tel);
            user.setUser_Tel(tel);
            user.setUser_Pwd(pwd);
            userMapper.insertOneUser(user);
            loginRt.setStatus(true);
            loginRt.setMsg("" + user.getUser_ID());
        }
        return loginRt;
    }

    public LoginRt findUserLogin(String tel, String pwd){
        User user = userMapper.findUserLogin(tel, pwd);
        LoginRt loginRt = new LoginRt();
        if (user != null){
            loginRt.setStatus(true);
            loginRt.setMsg("" + user.getUser_ID());
        }else {
            loginRt.setStatus(false);
            loginRt.setMsg("Login Error!");
        }
        return loginRt;
    }
}
