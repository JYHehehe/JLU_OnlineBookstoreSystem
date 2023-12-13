package com.control;
import com.pojo.Address;
import com.pojo.Admin_user;
import com.pojo.User;
import com.service.User_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("user")
@RestController
public class User_control {

    @Autowired
    User_service user_service;

    @RequestMapping("register")
    int register(User user){
//        id=xxx&name=xxx&password=xxx
//        System.out.println("-----------------------------------");
//        System.out.println(user.getId());
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//        System.out.println("-----------------------------------");
        return user_service.register(user);
    }

    @RequestMapping("login_check")
    int login_check(User user){
        System.out.println("-----------------------------------");
        System.out.println(user.toString());
        System.out.println("-----------------------------------");
        return user_service.login_check(user);
    }

    @RequestMapping("admin_login_check")
    int admin_login_check(Admin_user user){
        System.out.println("-----------------------------------");
        System.out.println(user.toString());
        System.out.println("-----------------------------------");
        return user_service.admin_login_check(user);
    }


    @RequestMapping("get_address_list")
    List<Address> get_address_list(int id){
        return user_service.get_address_list(id);
    }

    @RequestMapping("change_password")
    int change_password(int user_id,int old_password,int new_password){
        return user_service.change_password(user_id,old_password,new_password);
    }

    @RequestMapping("add_address")
    int add_address(Address address){
        return user_service.add_address(address);
    }
}
