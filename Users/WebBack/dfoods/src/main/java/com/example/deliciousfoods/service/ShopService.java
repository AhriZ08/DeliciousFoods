package com.example.deliciousfoods.service;

import com.example.deliciousfoods.entities.Menus;
import com.example.deliciousfoods.entities.Shop;
import com.example.deliciousfoods.entities.ShopAss;
import com.example.deliciousfoods.entities.ShopDetail;
import com.example.deliciousfoods.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    ShopMapper shopMapper;

    public List<Shop> findRecommendShop(){
        return shopMapper.findRecommendShop();
    }

    public List<Shop> findSortShop(String sort){
        return shopMapper.findSortShop(sort);
    }

    public List<Shop> findSearchShop(String keyWords){
        return shopMapper.findSearchShop(keyWords);
    }

    public List<Menus> findShopMenus(Integer sid){return  shopMapper.findShopMenus(sid);}

    public ShopDetail findOneShop(Integer sid){return shopMapper.findOneShop(sid);}

    public List<ShopAss> findShopAsses(int sid){return shopMapper.findShopAsses(sid);}
}
