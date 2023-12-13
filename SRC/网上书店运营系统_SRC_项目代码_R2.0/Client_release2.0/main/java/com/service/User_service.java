package com.service;

import com.dao.User_mapper;
import com.pojo.Address;
import com.pojo.Goods;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class User_service {

    @Autowired
    User_mapper userMapper;

    public int register(User user){
        //先check一下用户名是否被注册
        int flag=userMapper.check_user_name(user.getName());
        if (flag==1){
            //用户名已被注册
            return 1;
        }
        //注册用户
        flag=userMapper.insert_user(user);
        if (flag==0){
            //操作失败
            return 2;
        }
        return 0;
    }

    public int login_check(User user){
        //先check一下用户名和密码是否正确
        int flag=userMapper.login_check(user);
        if(flag==0){
            //用户名或密码不正确
            return 0;
        }
        //查询user_id并返回
        int user_id=userMapper.query_user_id(user.getName());
        return user_id;
    }

    public List<Address> get_address_list(int user_id){
        return userMapper.query_address_list(user_id);
    }

    public int change_password(int user_id,int old_password,int new_password){
        return userMapper.change_password(user_id,old_password,new_password);
    }

    public int add_address(Address address){
        return userMapper.add_address(address);
    }
}
