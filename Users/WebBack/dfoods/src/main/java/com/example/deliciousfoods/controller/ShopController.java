package com.example.deliciousfoods.controller;

import com.example.deliciousfoods.entities.Menus;
import com.example.deliciousfoods.entities.Shop;
import com.example.deliciousfoods.entities.ShopAss;
import com.example.deliciousfoods.entities.ShopDetail;
import com.example.deliciousfoods.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/sp")
public class ShopController {

    @Autowired
    ShopService shopService;

    @RequestMapping("/recommend")
    @ResponseBody
    public List<Shop> RecommendShop(){
        return shopService.findRecommendShop();
    }

    @RequestMapping("/sort")
    @ResponseBody
    public List<Shop> sortShop(String sort){
        return shopService.findSortShop(sort);
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<Shop> searchShop(String keyWords){
        return shopService.findSearchShop(keyWords);
    }

    @RequestMapping("/menu/{sid}")
    @ResponseBody
    public List<Menus> shopMenus(@PathVariable("sid") Integer sid){
        return shopService.findShopMenus(sid);
    }

    @RequestMapping("/{sid}")
    @ResponseBody
    public ShopDetail oneShop(@PathVariable("sid") Integer sid){
        return shopService.findOneShop(sid);
    }

    @RequestMapping("/ass/{sid}")
    @ResponseBody
    public List<ShopAss> shopAsses(@PathVariable("sid") Integer sid){
        return shopService.findShopAsses(sid);
    }
}
