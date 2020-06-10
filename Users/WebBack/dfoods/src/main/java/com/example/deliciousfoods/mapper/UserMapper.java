package com.example.deliciousfoods.mapper;

import com.example.deliciousfoods.entities.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    public int insertOneUser(User user);
    public String findUserByTel(String tel);
    public User findUserLogin(@Param("tel")String tel, @Param("pwd")String pwd);

    public UserAddr findUserAddrs(int uid);

    public Addr findUserDfAddr(int uid);

    public int updateUserAddr(RecvAddr recvUpdateAddr);
    public int insertUserAddr(RecvAddr recvInsertAddr);

    public int updateUserDfAddr(@Param("userID") int userID, @Param("addrID") int addrID);
    public int insertUserDfAddr(@Param("userID") int userID, @Param("addrID") int addrID);

    public int insertUserOrder(RecvOrder recvOrder);
    public int insertUserCart(Cart cart);
    public List<OrderSimpInfo> findOneSimpOrder(int uid);
    public OrderSimpInfo findCrtOneSimpOrder(int oID);
    public int modifyOrderState(@Param("state") String state, @Param("oID") int oID);
    public int insertOneAss(RecvOrderAss orderAss);
}
