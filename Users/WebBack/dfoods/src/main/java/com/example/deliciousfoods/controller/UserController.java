package com.example.deliciousfoods.controller;

import com.example.deliciousfoods.entities.*;
import com.example.deliciousfoods.service.ShopService;
import com.example.deliciousfoods.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

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

    @ResponseBody
    @RequestMapping("/one/{uid}")
    public UserSimpInfo getOneUserSimp(@PathVariable("uid") Integer uid){
        return userService.findOneUserSimpInfo(uid);
    }

    @ResponseBody
    @RequestMapping("/addr/{uid}")
    public RtAddr Addrs(@PathVariable("uid") Integer uid){
        return userService.findUserAddrs(uid);
    }

    @ResponseBody
    @RequestMapping("/addr/df/{uid}")
    public RtAddr dfAddr(@PathVariable("uid") Integer uid){
        return userService.findUserDfAddr(uid);
    }

    @ResponseBody
    @RequestMapping("/addr/mod/{uid}")
    public String modifyAddr(@RequestBody RecvAddr addr,@PathVariable("uid") Integer uid){
        addr.setUser_ID(uid);
        logger.info(addr.toString());
        int flag = userService.updateUserAddr(addr);
        if (flag != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping("/addr/add/{uid}")
    public String newAddr(@RequestBody RecvAddr addr, @PathVariable("uid") Integer uid){
        addr.setUser_ID(uid);
        logger.info(addr.toString());
        return userService.insertUserAddr(addr);
    }

    @ResponseBody
    @RequestMapping("/order")
    public String putOrder(@RequestBody RecvOrder recvOrder){
        int flag = userService.insertUserOrderAndCart(recvOrder);
        if (flag == 1){
            return "success";
        }else if (flag == -1){
            return "no money";
        }else {
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping("/order/all/{uid}")
    public List<OrderSimpInfo> simpInfo(@PathVariable("uid") Integer uid){
        return userService.findOneSimpOrder(uid);
    }

    @ResponseBody
    @RequestMapping("/order/one/{oid}")
    public OrderSimpInfo crtimpInfo(@PathVariable("oid") Integer oid){
        return userService.findCrtOneSimpOrder(oid);
    }

    @ResponseBody
    @RequestMapping("order/confirm/{oid}")
    public String confirmOrder(@PathVariable("oid") Integer oid){
        int flag = userService.confirmOneOrder(oid);
        if (flag != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping("/order/ass")
    public String assOrder(@RequestBody RecvOrderAss recvOrderAss){
        int flag = userService.assOrder(recvOrderAss);
        if (flag != 0){
            return "success";
        }else {
            return "fail";
        }
    }

    @ResponseBody
    @RequestMapping("/order/detail/{oID}")
    public OrderDetail orderDetail(@PathVariable("oID") Integer oID){
        return userService.findOneOrderDetail(oID);
    }

    @ResponseBody
    @RequestMapping("/addr/setDfAddr")
    public int setUserDfAddr(Integer addrID, Integer userID){
        return userService.setUserDfAddr(addrID, userID);
    }

    @ResponseBody
    @RequestMapping("/modtel")
    public String updateUserTel(String tel, Integer userID){
        return userService.updateUserTel(tel, userID);
    }

    @ResponseBody
    @RequestMapping("/modpwd")
    public String updateUserPwd(String tel, String pwd){
        int flag = userService.updateUserPwd(tel, pwd);
        if (flag != 0){
            return "success";
        }else {
            return "fail";
        }
    }

}
