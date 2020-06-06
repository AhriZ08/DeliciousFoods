package com.example.deliciousfoods.controller;

import com.example.deliciousfoods.entities.shop;
import com.example.deliciousfoods.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public List<shop> RecommendShop(){
        return shopService.findRecommendShop();
    }

    @RequestMapping("/sort")
    @ResponseBody
    public List<shop> sortShop(String sort){
        return shopService.findSortShop(sort);
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<shop> searchShop(String keyWords){
        return shopService.findSearchShop(keyWords);
    }
}
