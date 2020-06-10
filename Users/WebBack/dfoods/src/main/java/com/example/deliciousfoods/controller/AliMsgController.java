package com.example.deliciousfoods.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.deliciousfoods.service.AliSmsService;
import com.example.deliciousfoods.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AliMsgController {

    @Autowired
    AliSmsService aliSmsService;

    @Autowired
    RedisUtils redisUtils;

    @RequestMapping("/sms")
    @ResponseBody
    public String messgVerify(String tel_num) throws ClientException {
        String code = aliSmsService.sendSms(tel_num);
        redisUtils.setValue("code", code, 180);
//      System.out.println(redisUtils.getValue("code"));
        return code;
    }
}
