package com.example.deliciousfoods;

import com.example.deliciousfoods.entities.Menus;
import com.example.deliciousfoods.entities.Shop;
import com.example.deliciousfoods.mapper.ShopMapper;
import com.example.deliciousfoods.mapper.UserMapper;
import com.example.deliciousfoods.service.ShopService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
class DeliciousfoodsApplicationTests {

    @Autowired
    ShopService shopService;

    @Autowired
    ShopMapper shopMapper;

    @Autowired
    UserMapper userMapper;

/*    @Test
    void test1() {
        List<Shop> list = shopService.findSearchShop("基");
        list.forEach(shop -> System.out.println(shop));
    }

    @Test
    void test2(){
        List<Menus> mlist = shopMapper.findShopMenus(70001);
        mlist.forEach(ms -> System.out.println(ms.toString()));
    }

    @Test
    void test3(){
        Integer tel = userMapper.findUserByTel(1234567);
        System.out.println(tel);
    }*/
}
