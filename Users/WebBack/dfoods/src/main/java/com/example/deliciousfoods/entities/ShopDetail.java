package com.example.deliciousfoods.entities;

public class ShopDetail extends Shop {
    public String getShop_Address() {
        return Shop_Address;
    }

    public void setShop_Address(String shop_Address) {
        Shop_Address = shop_Address;
    }

    private String Shop_Address;

    @Override
    public String toString() {
        return "ShopDetail{" +
                "Shop_Address='" + Shop_Address + '\'' +
                '}';
    }
}
