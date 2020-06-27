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
import java.util.Random;

@Service
public class UserService {

    private UserMapper userMapper;
    private RedisUtils redisUtils;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Autowired
    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    /**
     * 新增用户
     * @param tel 电话
     * @param pwd 密码
     * @return 登录状态封装
     */
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

    /**
     * 用户登录
     * @param tel 电话
     * @param pwd 密码
     * @return 登录状态封装
     */
    public LoginRt findUserLogin(String tel, String pwd){
        User user = userMapper.findUserLogin(tel, pwd);
        LoginRt loginRt = new LoginRt();
        if (user != null && user.getUser_Freeze() != 1){
            loginRt.setStatus(true);
            loginRt.setMsg("" + user.getUser_ID());
        }else {
            loginRt.setStatus(false);
            loginRt.setMsg("Login Error!");
        }
        return loginRt;
    }

    /**
     * 获取用户全部地址
     * @param uid 用户id
     * @return 地址返回封装类
     */
    public RtAddr findUserAddrs(int uid){
        if (redisUtils.hasKey("userAddrs-" + uid)){
            logger.info("redis读取userAddrs-" + uid + "。。。。");
            UserAddr userAddr = (UserAddr)redisUtils.getValue("userAddrs-"+uid);
            logger.info("redis读取userAddrs-"+ uid +":"+userAddr.toString());
            return rtAddrUtils(userAddr);
        }else {
            UserAddr userAddr = userMapper.findUserAddrs(uid);
            if (userAddr != null){
                redisUtils.setValue("userAddrs-"+uid, userAddr, 1200);
            }
            return rtAddrUtils(userAddr);
        }
    }

    /**
     * 查找用户默认地址
     * @param uid 用户id
     * @return 返回地址信息包装类
     */
    public RtAddr findUserDfAddr(int uid){
        if (redisUtils.hasKey("DfAddr-" + uid)){
            logger.info("redis读取DfAddr" + uid +"。。。。");
            Addr addr = (Addr) redisUtils.getValue("DfAddr-" + uid);
            logger.info("redis中读取DfAddr:" + addr.toString());
            return rtAddrUtils(addr);
        }else {
            logger.info("mysql中读取addr");
            Addr addr = userMapper.findUserDfAddr(uid);
            if (addr != null){
                redisUtils.setValue("DfAddr-" + uid, addr, 3000);
            }
            return rtAddrUtils(addr);
        }
    }

    /**
     * 地址返回封装类
     * @param object 传入对象
     * @return 地址返回封装类
     */
    private static RtAddr rtAddrUtils(Object object){
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

    /**
     * 修改用户地址
     * @param addr 用户地址
     * @return 修改状态
     */
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

    /**
     * 新增用户地址
     * @param addr 前台接收参数，再把默认地址更新为新增地址
     * @return
     */
    public String insertUserAddr(RecvAddr addr){
        userMapper.insertUserAddr(addr);
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
        return "" + addr.getAddr_ID();
    }

    /**
     * 新增订单
     * @param recvOrder
     * @return
     */
    public int insertUserOrderAndCart(RecvOrder recvOrder){
        UserSimpInfo userSimpInfo = userMapper.findOneUserSimpInfo(recvOrder.getUserID());
        if (userSimpInfo.getUser_Mony() >= recvOrder.getTotal()){
            recvOrder.setOrderState("配送中");
            SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:dd");
            String date = sDateFormat.format(new Date());
            recvOrder.setOrderTime(date);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date now = new Date();
            String spendTime = sdf.format(now.getTime() + 136000);

            recvOrder.setSpendTime(spendTime);
            SimpleDateFormat num = new SimpleDateFormat("yyyyMMddhhmmss");
            Random r = new Random();
            recvOrder.setFormatNum(r.nextInt(100) + num.format(now) + r.nextInt(100));
            userMapper.insertUserOrder(recvOrder);
            int oID = recvOrder.getOrderID();
            recvOrder.getCart().forEach(item->{
                item.setOrderID(oID);
                userMapper.insertUserCart(item);
            });
            logger.info(recvOrder.toString());
            float left = userSimpInfo.getUser_Mony() - recvOrder.getTotal();
            return userMapper.updateUserMoney(left, recvOrder.getUserID());
        }else {
            return -1;
        }
    }

    /**
     * 查询用户一些基本订单信息
     * @param uid
     * @return
     */
    public List<OrderSimpInfo> findOneSimpOrder(int uid){
        logger.info("uid:"+uid);
        List<OrderSimpInfo> orderSimpInfos = userMapper.findOneSimpOrder(uid);
        logger.info(orderSimpInfos.toString());
        return orderSimpInfos;
    }

    public OrderSimpInfo findCrtOneSimpOrder(int oID){
        return userMapper.findCrtOneSimpOrder(oID);
    }

    public int confirmOneOrder(int oID){
        return userMapper.modifyOrderState("待评价", oID);
    }

    /**
     * 新增店铺评价
     * @param recvOrderAss 封装评价类
     * @return 新增状态
     */
    public int assOrder(RecvOrderAss recvOrderAss){
        SimpleDateFormat sDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:dd");
        String date=sDateFormat.format(new Date());
        recvOrderAss.setTime(date);
        recvOrderAss.setAssUnusual(0);
        int flag = userMapper.insertOneAss(recvOrderAss);
        userMapper.modifyOrderState("已完成", recvOrderAss.getOrderID());
        return flag;
    }

    public OrderDetail findOneOrderDetail(int oID){
        return userMapper.findOneOrderDetail(oID);
    }

    public UserSimpInfo findOneUserSimpInfo(int uid){
        return userMapper.findOneUserSimpInfo(uid);
    };

    public int setUserDfAddr(int addrID, int userID){
        int flag = userMapper.updateUserDfAddr(userID, addrID);
        Addr addr = userMapper.findUserDfAddr(userID);
        redisUtils.setValue("DfAddr-" + userID, addr, 3000);
        return flag;
    }
    public String updateUserTel(String tel, int userID){
        UserSimpInfo userSimpInfo = userMapper.findOneUserSimpInfo(userID);
        if (userSimpInfo.getUser_Tel().equals(tel)){
            return "isExist";
        }else {
            userMapper.updateUserTel(tel, userID);
            return "success";
        }
    }
    public int updateUserPwd(String tel, String pwd){
        return userMapper.updateUserPwd(tel, pwd);
    }
}
