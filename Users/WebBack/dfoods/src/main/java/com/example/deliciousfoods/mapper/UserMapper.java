package com.example.deliciousfoods.mapper;

import com.example.deliciousfoods.entities.admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
    public admin findByUserName(String name);
}
