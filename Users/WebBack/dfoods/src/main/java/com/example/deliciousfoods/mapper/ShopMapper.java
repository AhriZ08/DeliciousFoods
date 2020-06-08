package com.example.deliciousfoods.mapper;

import com.example.deliciousfoods.entities.Menus;
import com.example.deliciousfoods.entities.Shop;
import com.example.deliciousfoods.entities.ShopDetail;
import com.example.deliciousfoods.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopMapper {
    public List<Shop> findRecommendShop();
    public List<Shop> findSortShop(String sort);
    public List<Shop> findSearchShop(String keyWords);
    public List<Menus> findShopMenus(int sid);
    public ShopDetail findOneShop(int sid);
}
