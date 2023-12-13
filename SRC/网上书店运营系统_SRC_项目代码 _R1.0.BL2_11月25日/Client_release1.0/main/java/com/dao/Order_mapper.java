package com.dao;


import com.pojo.Cart;
import com.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface Order_mapper {


    @Insert("insert into \"SERVER\".\"CART\"(goods_id,goods_amount,user_id,address_id,\"DATE\") values(#{goods_id},#{goods_amount},#{user_id},#{address_id},#{date})")
    int insert_cart(Cart cart);

    @Insert("insert into \"SERVER\".\"ORDERS\"(goods_id,goods_amount,paid_amount,user_id,address_id,state,\"DATE\") values(#{goods_id},#{goods_amount},#{paid_amount},#{user_id},#{address_id},#{state},#{date})")
    int insert_order(Order order);

    @Select("select * from \"SERVER\".\"CART\" where user_id=#{user_id}")
    List<Cart> query_cart_list(int user_id);

    @Select("select * from \"SERVER\".\"ORDERS\" where user_id=#{user_id} and state!=6")
    List<Order> query_order_list(int user_id);

    @Select("select * from \"SERVER\".\"ORDERS\" where user_id=#{user_id} and state=6")
    List<Order> query_refund_order_list(int user_id);

    @Select("select * from \"SERVER\".\"ORDERS\" where order_id=#{order_id}")
    Order query_order_by_order_id(int order_id);

    @Update("update \"SERVER\".\"CART\" set goods_amount=#{goods_amount} where cart_id=#{cart_id}")
    int update_cart_goods_amount(int cart_id,int goods_amount);

    @Select("select * from \"SERVER\".\"CART\" where cart_id=#{cart_id}")
    Cart query_cart_by_cart_id(int cart_id);

    @Delete("delete from \"SERVER\".\"CART\" where cart_id=#{cart_id}")
    int delete_cart_by_cart_id(int cart_id);

    @Update("update \"SERVER\".\"ORDERS\" set state=6 where order_id=#{order_id}")
    int set_order_state_refund(int order_id);

    @Update("update \"SERVER\".\"ORDERS\" set state=3 where order_id=#{order_id}")
    int set_order_state_received(int order_id);

    @Update("update \"SERVER\".\"ORDERS\" set state=4 where order_id=#{order_id}")
    int set_order_state_reviewed(int order_id);

    @Update("update \"SERVER\".\"ORDERS\" set state=5 where order_id=#{order_id}")
    int set_order_state_req_refund(int order_id);

}
