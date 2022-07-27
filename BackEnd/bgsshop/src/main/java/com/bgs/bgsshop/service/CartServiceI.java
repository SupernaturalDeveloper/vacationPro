package com.bgs.bgsshop.service;

import com.bgs.bgsshop.pojo.Cart;
import com.bgs.bgsshop.pojo.CartProduct;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Mapper
public interface CartServiceI {
    @Insert("insert into cart (userId,productId,num,price,prices,remarks) values (#{userId},#{productId},#{num},#{price},#{prices},#{remarks})")
    Integer add(Cart cart);
    @Select("SELECT * from cart,product where cart.productId=product.id and userId=#{userId};")
    ArrayList<CartProduct> getUserCart(Cart cart);
    @Delete("delete from cart where id=#{id}")
    Integer delete(Cart cart);
    @Update("update cart set num=#{num} where productId=#{productId} and userId=#{userId}")
    Integer updateNum(Cart cart);
    @Update("update cart set prices=#{prices} where userId=#{userId} and productId=#{productId}")
    Integer updatePrices(Cart cart);
}
