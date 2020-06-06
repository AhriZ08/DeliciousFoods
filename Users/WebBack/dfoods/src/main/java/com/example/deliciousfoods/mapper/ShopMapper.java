package com.example.deliciousfoods.mapper;

import com.example.deliciousfoods.entities.shop;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopMapper {
    public List<shop> findRecommendShop();
    public List<shop> findSortShop(String sort);
    public List<shop> findSearchShop(String keyWords);
}
