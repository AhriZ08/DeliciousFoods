package com.example.deliciousfoods.service;

import com.example.deliciousfoods.entities.shop;
import com.example.deliciousfoods.mapper.ShopMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    @Autowired
    ShopMapper shopMapper;

    public List<shop> findRecommendShop(){
        return shopMapper.findRecommendShop();
    }

    public List<shop> findSortShop(String sort){
        return shopMapper.findSortShop(sort);
    }

    public List<shop> findSearchShop(String keyWords){
        return shopMapper.findSearchShop(keyWords);
    }
}
