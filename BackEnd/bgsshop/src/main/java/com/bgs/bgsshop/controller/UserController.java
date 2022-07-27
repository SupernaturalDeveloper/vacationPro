package com.bgs.bgsshop.controller;

import com.bgs.bgsshop.pojo.User;
import com.bgs.bgsshop.service.UserService;
import com.bgs.bgsshop.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@CrossOrigin("*")
@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserServiceI usi;
    @Autowired
    UserService us;
    //http://localhost:8080/user/getData
    @RequestMapping("getData")
    public ArrayList<User> getData(){
        return usi.getData();
    }
//    普通用户登录验证
//    http://localhost:8080/user/login?username=admin0&password=123456&role=0
    @RequestMapping("login")
    public Integer login(User user){
        return us.Login(user,0);
    }
//    管理员登录验证
//    http://localhost:8080/user/adminLogin?username=admin1&password=123456&role=1
    @RequestMapping("adminLogin")
    public Integer adminLogin(User user){
        return us.Login(user,1);
    }
//    获取用户信息(数据库接口)
//    http://localhost:8080/user/getUserMessage?username=admin1&password=123456&role=1
    @RequestMapping("getUserMessage")
    public User getUserMessage(User user){
        return usi.getUserMessage(user);
    }
//    用户注册（添加数据）
//    http://localhost:8080/user/insert?username=admin2&password=123456&email=2210183204@qq.com&phone=17845998577&url=hb&role=0&createtime=2022-01-27 14:00
    @RequestMapping("insert")
    public Integer insert(User user){
        return us.register(user);
    }
//    修改密码
//http://localhost:8080/user/changePassword?password=123456&id=4
    @RequestMapping("changePassword")
    public Integer changePassword(User user){
        return usi.changePassword(user);
    }
//    验证原密码输入是否正确
//    http://localhost:8080/user/confirmPassword?password=123456&id=4
    @RequestMapping("confirmPassword")
    public Integer confirmPassword(User user){
        return us.confirmPassword(user);
    }
}
