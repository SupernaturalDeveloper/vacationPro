package com.bgs.bgsshop.controller;

import com.bgs.bgsshop.pojo.Product;
import com.bgs.bgsshop.service.ProductServiceI;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RequestMapping("product")
@RestController
public class ProductController {
    @Autowired
    ProductServiceI psi;
//    http://localhost:8080/product/getList
    @RequestMapping("getList")
    public ArrayList<Product> getList(){
        return psi.getList();
    }
    //    http://localhost:8080/product/getCommendList
    @RequestMapping("getCommendList")
    public ArrayList<Product> getCommendList(){
        return psi.getCommendList();
    }
    //    http://localhost:8080/product/getSalesList
    @RequestMapping("getSalesList")
    public ArrayList<Product> getSalesList(){
        return psi.getSalesList();
    }
    //    http://localhost:8080/product/getQtList
    @RequestMapping("getQtList")
    public ArrayList<Product> getQtList(){
        return psi.getQtList();
    }
//    http://localhost:8080/product/add?categoryId=5&code=1006&name=鸟&subtitle=鹦鹉&detail=会说话的鹦鹉&price=1000&stock=550&sales=80&images=yw.jpg&isCommend=10
    @RequestMapping("add")
    public Integer add(Product product){
        return psi.add(product);
    }
    //    http://localhost:8080/product/set?id=3&categoryId=5&code=1006&name=鸟&subtitle=鹦鹉&detail=会说话的鹦鹉&price=1000&stock=550&sales=80&images=yw.jpg&isCommend=12
    @RequestMapping("set")
    public Integer set(Product product){
        return psi.set(product);
    }
//    http://localhost:8080/product/delete?id=4
    @RequestMapping("delete")
    public Integer delete(Product product){
        return psi.delete(product);
    }
    //    http://localhost:8080/product/getDqProduct?id=4
    @RequestMapping("getDqProduct")
    public Product getDqProduct(Product product){
        return psi.getDqProduct(product);
    }
}
