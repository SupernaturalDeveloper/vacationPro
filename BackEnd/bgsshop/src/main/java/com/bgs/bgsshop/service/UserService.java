package com.bgs.bgsshop.service;

import com.bgs.bgsshop.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserServiceI usi;
//    登录验证服务
    public Integer Login(User user,Integer number){
        for(User value:usi.getData()){
            if(value.getUsername().equals(user.getUsername())&&value.getPassword().equals(user.getPassword())&&value.getRole().equals(number)){
                return 1;
            }
        }
        return 0;
    }
//    注册验证用户名是否重复
    public Integer register(User user){
        for(User value:usi.getData()){
            if(value.getUsername().equals(user.getUsername())&&value.getRole().equals(user.getRole())){
                return 0;
            }
        }
        return usi.insert(user);
    }
//    验证原密码是否正确
    public Integer confirmPassword(User user){
        if(usi.confirmPassword(user).getPassword().equals(user.getPassword())){
            return 1;
        }
        return 0;
    }
}
