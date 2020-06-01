package com.example.deliciousfoods.controller;

import com.example.deliciousfoods.entities.admin;
import com.example.deliciousfoods.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class userController {

    @Autowired
    public UserMapper userMapper;

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        String name = "admin";
        admin ad = userMapper.findByUserName(name);
        return ad.getAdmin_Name();
    }
}
