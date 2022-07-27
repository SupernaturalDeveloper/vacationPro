package com.bgs.bgsshop.service;

import com.bgs.bgsshop.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Mapper
public interface UserServiceI {
    @Select("select * from user")
    ArrayList<User> getData();
    @Select("select * from user where username=#{username} and password=#{password} and role=#{role};")
    User getUserMessage(User user);
    @Insert("insert into user (username,password,email,phone,url,role,createtime) values(#{username},#{password},#{email},#{phone},#{url},#{role},#{createtime});")
    Integer insert(User user);
    @Update("update user set password=#{password} where id=#{id}")
    Integer changePassword(User user);
    @Select("select * from user where id=#{id}")
    User confirmPassword(User user);
}
