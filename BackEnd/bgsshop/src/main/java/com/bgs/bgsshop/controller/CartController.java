package com.bgs.bgsshop.controller;

import com.bgs.bgsshop.pojo.Cart;
import com.bgs.bgsshop.pojo.CartProduct;
import com.bgs.bgsshop.service.CartServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RequestMapping("cart")
@RestController
public class CartController {
    @Autowired
    CartServiceI csi;
//    新增
//    http://localhost:8080/cart/add?userId=2&productId=2&num=2&price=198&prices=396&remarks="顺丰快递"
    @RequestMapping("add")
    public Integer add(Cart cart){
        return csi.add(cart);
    }
//    获取某人的购物车
//    http://localhost:8080/cart/getUserCart?userId=2
    @RequestMapping("getUserCart")
    public ArrayList<CartProduct> getUserCart(Cart cart){
        return csi.getUserCart(cart);
    }
//    删除某个商品接口
//    http://localhost:8080/cart/delete?id=1
    @RequestMapping("delete")
    public Integer delete(Cart cart){
        return csi.delete(cart);
    }
//    保存数量
//    http://localhost:8080/cart/updateNum?num=4&productId=3&userId=6
    @RequestMapping("updateNum")
    public Integer updateNum(Cart cart){
        return csi.updateNum(cart);
    }
//    总价格
//    http://localhost:8080/cart/updatePrices?prices=6000&productId=3&userId=6
    @RequestMapping("updatePrices")
    public Integer updatePrices(Cart cart){
        return csi.updatePrices(cart);
    }
}
