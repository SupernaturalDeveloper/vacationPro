package com.bgs.bgsshop.service;

import com.bgs.bgsshop.pojo.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Mapper
public interface CategoryServiceI {
//    增加
    @Insert("insert into category (code,name,sortorder) values (#{code},#{name},#{sortorder})")
    Integer addCategory(Category category);
//    删除
    @Delete("delete from category where id=#{id}")
    Integer deleteCategory(Category category);
//    修改
    @Update("update category set code=#{code},name=#{name},sortorder=#{sortorder} where id=#{id}")
    Integer setCategory(Category category);
//    查看列表
    @Select("select * from category")
    ArrayList<Category> getCategory();
}
