package com.example.deliciousfoods.controller;

import com.example.deliciousfoods.entities.LoginRt;
import com.example.deliciousfoods.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigInteger;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    public UserService userService;

    @ResponseBody
    @RequestMapping("/register")
    public LoginRt register(String t_phone, String t_pwd){
        logger.info("t_phone:"+ t_phone+",t_pwd:" + t_pwd);
        return userService.insertOneUser(t_phone, t_pwd);
    }

    @ResponseBody
    @RequestMapping("/login")
    public LoginRt login(String phone, String pwd){
        return userService.findUserLogin(phone, pwd);
    }
}
