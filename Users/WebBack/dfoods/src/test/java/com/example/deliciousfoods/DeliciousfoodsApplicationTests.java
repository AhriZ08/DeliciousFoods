package com.example.deliciousfoods;

import com.example.deliciousfoods.entities.shop;
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
    @Test
    void test1() {
        List<shop> list = shopService.findSearchShop("基");
        list.forEach(shop -> System.out.println(shop));
    }

}
