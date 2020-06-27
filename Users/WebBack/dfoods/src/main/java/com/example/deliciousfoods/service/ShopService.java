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

    /**
     * 查找推荐店铺
     * @return 推荐店铺列表
     */
    public List<Shop> findRecommendShop(){
        return shopMapper.findRecommendShop();
    }

    /**
     * 查找当前分类店铺
     * @param sort 分类名
     * @return 店铺列表
     */
    public List<Shop> findSortShop(String sort){
        return shopMapper.findSortShop(sort);
    }

    /**
     * 查找搜索店铺
     * @param keyWords 搜索关键词
     * @return 店铺列表
     */
    public List<Shop> findSearchShop(String keyWords){
        return shopMapper.findSearchShop(keyWords);
    }

    /**
     * 查询当前店铺的菜品
     * @param sid 店铺ID
     * @return 菜品列表
     */
    public List<Menus> findShopMenus(Integer sid){return  shopMapper.findShopMenus(sid);}

    /**
     * 查询店铺详细信息
     * @param sid 店铺ID
     * @return 店铺信息封装类
     */
    public ShopDetail findOneShop(Integer sid){return shopMapper.findOneShop(sid);}

    /**
     * 查询店铺评论
     * @param sid 店铺ID
     * @return 评论列表
     */
    public List<ShopAss> findShopAsses(int sid){return shopMapper.findShopAsses(sid);}
}
