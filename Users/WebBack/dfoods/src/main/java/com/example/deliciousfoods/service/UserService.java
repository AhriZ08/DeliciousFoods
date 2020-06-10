package com.example.deliciousfoods.service;

import com.example.deliciousfoods.entities.*;
import com.example.deliciousfoods.mapper.UserMapper;
import com.example.deliciousfoods.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtils redisUtils;

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

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
            user.setUser_HeadImg("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2519824424,1132423651&fm=26&gp=0.jpg");
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

    public RtAddr findUserAddrs(int uid){
        if (redisUtils.hasKey("userAddrs-"+uid)){
            logger.info("redis读取userAddrs-"+ uid +"。。。。");
            UserAddr userAddr = (UserAddr)redisUtils.getValue("userAddrs-"+uid);
            logger.info("redis读取userAddrs-"+ uid +":"+userAddr.toString());
            return rtAddrUtils(userAddr);
        }else {
            UserAddr userAddr = userMapper.findUserAddrs(uid);
            redisUtils.setValue("userAddrs-"+uid, userAddr, 1200);
            return rtAddrUtils(userAddr);
        }
    }

    /**
     * 查找用户默认地址
     * @param uid 用户id
     * @return 返回地址信息包装类
     */
    public RtAddr findUserDfAddr(int uid){
        if (redisUtils.hasKey("DfAddr")){
            logger.info("redis读取DfAddr。。。。");
            Addr addr = (Addr) redisUtils.getValue("DfAddr");
            logger.info("redis中读取DfAddr:" + addr.toString());
            return rtAddrUtils(addr);
        }else {
            logger.info("mysql中读取addr");
            Addr addr = userMapper.findUserDfAddr(uid);
            redisUtils.setValue("DfAddr", addr, 3000);
            return rtAddrUtils(addr);
        }
    }

    public static RtAddr rtAddrUtils(Object object){
        RtAddr rtAddr = new RtAddr();
        if (object != null) {
            rtAddr.setStatus(true);
            rtAddr.setMsg("success");
            rtAddr.setObject(object);
        }else {
            rtAddr.setStatus(false);
            rtAddr.setMsg("error");
            rtAddr.setObject("null");
        }
        return rtAddr;
    }
    public int updateUserAddr(RecvAddr addr){
        if (redisUtils.hasKey("userAddrs-" + addr.getUser_ID())) {
            UserAddr userAddr = (UserAddr) redisUtils.getValue("userAddrs-" + addr.getUser_ID());
            userAddr.getAddrList().forEach(a->{
                if (a.getAddr_ID() ==  addr.getAddr_ID()){
                    a.setAddr(addr.getAddr());
                    a.setCallName(addr.getCallName());
                    a.setRecTel(addr.getRecTel());
                }
            });
            redisUtils.setValue("userAddrs-"+addr.getUser_ID(), userAddr, 1200);
        }
        return userMapper.updateUserAddr(addr);
    }

    public int insertUserAddr(RecvAddr addr){
        int flag = userMapper.insertUserAddr(addr);
        Addr addr1 = userMapper.findUserDfAddr(addr.getUser_ID());
        if (addr1 != null){
            userMapper.updateUserDfAddr(addr.getUser_ID(), addr.getAddr_ID());
        }else {
            userMapper.insertUserDfAddr(addr.getUser_ID(), addr.getAddr_ID());
        }
        if (redisUtils.hasKey("userAddrs-" + addr.getUser_ID())) {
            UserAddr userAddr = (UserAddr) redisUtils.getValue("userAddrs-" + addr.getUser_ID());
            Addr newAddr = new Addr();
            newAddr.setAddr_ID(addr.getAddr_ID());
            newAddr.setAddr(addr.getAddr());
            newAddr.setCallName(addr.getCallName());
            newAddr.setRecTel(addr.getRecTel());
            userAddr.getAddrList().add(newAddr);
            redisUtils.setValue("userAddrs-"+addr.getUser_ID(), userAddr, 1200);
        }
        return flag;
    }

    public int insertUserOrderAndCart(RecvOrder recvOrder){
        recvOrder.setOrderState("配送中");
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:dd");
        String date=sDateFormat.format(new Date());
        recvOrder.setOrderTime(date);
        System.out.println(recvOrder);
        int flag = userMapper.insertUserOrder(recvOrder);
        int oID = recvOrder.getOrderID();
        recvOrder.getCart().forEach(item->{
            item.setOrderID(oID);
            userMapper.insertUserCart(item);
        });
        return flag;
    }

    public List<OrderSimpInfo> findOneSimpOrder(int uid){
        return userMapper.findOneSimpOrder(uid);
    }

    public OrderSimpInfo findCrtOneSimpOrder(int oID){
        return userMapper.findCrtOneSimpOrder(oID);
    }

    public int confirmOneOrder(int oID){
        return userMapper.modifyOrderState("待评价", oID);
    }

    public int assOrder(RecvOrderAss recvOrderAss){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:dd");
        String date=sDateFormat.format(new Date());
        recvOrderAss.setTime(date);
        recvOrderAss.setAssUnusual(0);
        int flag = userMapper.insertOneAss(recvOrderAss);
        userMapper.modifyOrderState("已完成", recvOrderAss.getOrderID());
        return flag;
    }
}
