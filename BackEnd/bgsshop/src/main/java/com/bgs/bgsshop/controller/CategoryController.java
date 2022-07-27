package com.bgs.bgsshop.controller;

import com.bgs.bgsshop.pojo.Category;
import com.bgs.bgsshop.service.CategoryServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RequestMapping("category")
@RestController
public class CategoryController {
    @Autowired
    CategoryServiceI csi;
//    增加
//    http://localhost:8080/category/add?code=1003&name=玩具&sortorder=3
    @RequestMapping("add")
    public Integer add(Category category){
        return csi.addCategory(category);
    }
//    删除
//    http://localhost:8080/category/delete?id=3
    @RequestMapping("delete")
    public Integer delete(Category category){
        return csi.deleteCategory(category);
    }
//    修改
//    http://localhost:8080/category/set?code=1022&name=饮料&sortorder=4&id=1
    @RequestMapping("set")
    public Integer set(Category category){
        return csi.setCategory(category);
    }
//    获取列表
//    http://localhost:8080/category/get
    @RequestMapping("get")
    public ArrayList<Category> get(){
        return csi.getCategory();
    }
}
