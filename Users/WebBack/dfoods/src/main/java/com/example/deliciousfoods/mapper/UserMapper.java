package com.example.deliciousfoods.mapper;

import com.example.deliciousfoods.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public int insertOneUser(User user);
    public int insertUserAddr(@Param("uid") int uid, @Param("addr") String addr);
    public String findUserByTel(String tel);
    public User findUserLogin(@Param("tel")String tel, @Param("pwd")String pwd);
}
