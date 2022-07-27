package com.bgs.bgsshop.service;

import com.bgs.bgsshop.pojo.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Mapper
public interface ProductServiceI {
    //    获取所有商品列表
    @Select("select * from product")
    ArrayList<Product> getList();
    @Insert("insert into product (categoryId,code,name,subtitle,detail,price,stock,sales,images,isCommend) values(#{categoryId},#{code},#{name},#{subtitle},#{detail},#{price},#{stock},#{sales},#{images},#{isCommend})")
    Integer  add(Product product);
    @Update("update product set categoryId=#{categoryId},code=#{code},name=#{name},subtitle=#{subtitle},detail=#{detail},price=#{price},stock=#{stock},sales=#{sales},images=#{images},isCommend=#{isCommend} where id=#{id}")
    Integer set(Product product);
    @Delete("delete from product where id=#{id}")
    Integer delete(Product product);
//    获取推荐商品列表
    @Select("select * from product where isCommend=1")
    ArrayList<Product> getCommendList();
//    获取热销产品列表
    @Select("select * from product where sales>=1000")
    ArrayList<Product> getSalesList();
    //    获取其他产品列表
    @Select("select * from product where sales<=1000 and isCommend=0")
    ArrayList<Product> getQtList();
//    获取当前商品id
    @Select("select * from product where id=#{id}")
    Product getDqProduct(Product product);
}
