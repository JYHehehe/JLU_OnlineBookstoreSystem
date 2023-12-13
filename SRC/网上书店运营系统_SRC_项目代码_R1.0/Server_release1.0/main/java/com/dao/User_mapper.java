package com.dao;

import com.pojo.Address;
import com.pojo.Admin_user;
import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface User_mapper {

//    USR表在SERVER这个模式下，USER是Oracle保留字，所以要加双引号访问
    @Select("select count(*) from \"SERVER\".\"USER\" where name=#{name}")
    int check_user_name(String name);

//    @Insert("insert into teacher(id,name) values(#{id},#{name})")

//    ID列通过触发器+序列实现自增，因此只插入name和password字段
    @Insert("insert into \"SERVER\".\"USER\"(name,password) values(#{name},#{password})")
    int insert_user(User user);

    @Select("select count(*) from \"SERVER\".\"USER\" where name=#{name} and password=#{password}")
    int login_check(User user);

    @Select("select count(*) from \"SERVER\".\"ADMIN_USER\" where uname=#{uname} and upwd=#{upwd}")
    int admin_login_check(Admin_user user);

    @Select("select ID from \"SERVER\".\"USER\" where name=#{name}")
    int query_user_id(String name);

    @Select("select * from \"SERVER\".\"ADDRESS\" where user_id=#{user_id}")
    List<Address> query_address_list(int user_id);

    @Insert("insert into \"SERVER\".\"ADDRESS\"(address,name,phone_number,user_id) values(#{address},#{name},#{phone_number},#{user_id})")
    int add_address(Address address);

    @Select("select address from \"SERVER\".\"ADDRESS\" where address_id=#{address_id}")
    String query_address_name(int address_id);

    @Select("select phone_number from \"SERVER\".\"ADDRESS\" where address_id=#{address_id}")
    String query_phone_number(int address_id);

    @Update("update \"SERVER\".\"USER\" set password=#{new_password} where id=#{user_id} and password=#{old_password}")
    int change_password(int user_id,int old_password,int new_password);
}
