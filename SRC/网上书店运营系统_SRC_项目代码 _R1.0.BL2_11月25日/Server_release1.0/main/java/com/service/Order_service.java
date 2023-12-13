package com.service;


import com.dao.Goods_mapper;
import com.dao.Order_mapper;
import com.dao.User_mapper;
import com.pojo.Cart;
import com.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class Order_service {

    @Autowired
    Order_mapper order_mapper;

    @Autowired
    Goods_mapper goods_mapper;

    @Autowired
    User_mapper user_mapper;

    public int add_to_cart(Cart cart){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        cart.setDate(df.format(new Date()));
        return order_mapper.insert_cart(cart);
    }

    public int add_to_order(Order order){
        //设置时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setDate(df.format(new Date()));
        //判断库存是否足够
        int db_stock=goods_mapper.query_goods_stock(order.getGoods_id());
        if(db_stock<order.getGoods_amount()){
            //库存不足
            return -1;
        }
        //更新商品信息
        //更新库存
        goods_mapper.update_goods_stock(order.getGoods_id(),db_stock-order.getGoods_amount());
        //更新销量
        goods_mapper.add_goods_sale(order.getGoods_id(),order.getGoods_amount());
        //创建订单
        //设置支付总金额
        double unit_price=goods_mapper.query_goods_unit_price(order.getGoods_id());
        double paid_amount=unit_price*order.getGoods_amount();
        order.setPaid_amount(paid_amount);
        //设置订单状态
        order.setState(1);
        return order_mapper.insert_order(order);
    }

    public List<Cart> query_cart_list(int user_id){

        List<Cart> cart_list=order_mapper.query_cart_list(user_id);
        for(int i=0;i<cart_list.size();i++){
            int goods_id=cart_list.get(i).getGoods_id();
            cart_list.get(i).setGoods_name(goods_mapper.query_goods_name(goods_id));
            cart_list.get(i).setUnit_price(goods_mapper.query_goods_unit_price(goods_id));
            cart_list.get(i).setView_address(goods_mapper.query_goods_view_address(goods_id));
            cart_list.get(i).setTotal_price(cart_list.get(i).getUnit_price()*cart_list.get(i).getGoods_amount());
            cart_list.get(i).setAddress_name(user_mapper.query_address_name(cart_list.get(i).getAddress_id()));
        }
        return cart_list;
    }
    public List<Order> query_order_list(int user_id){

        List<Order> order_list=order_mapper.query_order_list(user_id);
        for(int i=0;i<order_list.size();i++){
            int goods_id=order_list.get(i).getGoods_id();
            order_list.get(i).setGoods_name(goods_mapper.query_goods_name(goods_id));
            order_list.get(i).setView_address(goods_mapper.query_goods_view_address(goods_id));
            order_list.get(i).setAddress_name(user_mapper.query_address_name(order_list.get(i).getAddress_id()));
            order_list.get(i).setPhone_number(user_mapper.query_phone_number(order_list.get(i).getAddress_id()));
            order_list.get(i).setState_desc();
        }
        return order_list;
    }

    public List<Order> query_all_order_list(){

        List<Order> order_list=order_mapper.query_all_order_list();
        for(int i=0;i<order_list.size();i++){
            int goods_id=order_list.get(i).getGoods_id();
            order_list.get(i).setGoods_name(goods_mapper.query_goods_name(goods_id));
            order_list.get(i).setView_address(goods_mapper.query_goods_view_address(goods_id));
            order_list.get(i).setAddress_name(user_mapper.query_address_name(order_list.get(i).getAddress_id()));
            order_list.get(i).setPhone_number(user_mapper.query_phone_number(order_list.get(i).getAddress_id()));
            order_list.get(i).setState_desc();
        }
        return order_list;
    }

    public List<Order> query_orders_view(int state){

        List<Order> order_list=null;
        if(state==1){
            order_list=order_mapper.query_orders_view_1();
        }
        else if(state==2){
            order_list=order_mapper.query_orders_view_2();
        }
        else if(state==3){
            order_list=order_mapper.query_orders_view_3();
        }
        else if(state==4){
            order_list=order_mapper.query_orders_view_4();
        }
        else if(state==5){
            order_list=order_mapper.query_orders_view_5();
        }
        else if(state==6){
            order_list=order_mapper.query_orders_view_6();
        }

        for(int i=0;i<order_list.size();i++){
            int goods_id=order_list.get(i).getGoods_id();
            order_list.get(i).setGoods_name(goods_mapper.query_goods_name(goods_id));
            order_list.get(i).setView_address(goods_mapper.query_goods_view_address(goods_id));
            order_list.get(i).setAddress_name(user_mapper.query_address_name(order_list.get(i).getAddress_id()));
            order_list.get(i).setPhone_number(user_mapper.query_phone_number(order_list.get(i).getAddress_id()));
            order_list.get(i).setState_desc();
        }
        return order_list;
    }

    public Order query_order_by_order_id(int order_id){

        Order order=order_mapper.query_order_by_order_id(order_id);
        int goods_id=order.getGoods_id();
        order.setGoods_name(goods_mapper.query_goods_name(goods_id));
        order.setView_address(goods_mapper.query_goods_view_address(goods_id));
        order.setAddress_name(user_mapper.query_address_name(order.getAddress_id()));
        order.setState_desc();
        return order;
    }

    public int update_cart_goods_amount(int cart_id,int goods_amount){
        return order_mapper.update_cart_goods_amount(cart_id,goods_amount);
    }

    public int pay_one_cart(int cart_id){
        //删除原来的购物车
        //先把购物车信息查出来
        Cart cart=order_mapper.query_cart_by_cart_id(cart_id);
        //判断库存是否足够
        int db_stock=goods_mapper.query_goods_stock(cart.getGoods_id());
        if(db_stock<cart.getGoods_amount()){
            //库存不足
            return -1;
        }
        //然后创建新的订单
        Order order=new Order();
        order.set_attributes(cart);
        //设置其他属性
        //设置时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        order.setDate(df.format(new Date()));
        //设置支付总金额
        double unit_price=goods_mapper.query_goods_unit_price(order.getGoods_id());
        double paid_amount=unit_price*order.getGoods_amount();
        order.setPaid_amount(paid_amount);
        //设置订单状态
        order.setState(1);
        //更新商品信息
        //更新库存
        goods_mapper.update_goods_stock(order.getGoods_id(),db_stock-order.getGoods_amount());
        //更新销量
        goods_mapper.add_goods_sale(order.getGoods_id(),order.getGoods_amount());
        //删除购物车
        order_mapper.delete_cart_by_cart_id(cart_id);
        //插入订单
        return order_mapper.insert_order(order);
    }

    public int delete_one_cart(int cart_id){
        return order_mapper.delete_cart_by_cart_id(cart_id);
    }

    public int direct_refund(int order_id){
        return order_mapper.set_order_state_refund(order_id);
    }

    public int send_out(int order_id){
        return order_mapper.set_order_state_send_out(order_id);
    }

    public int accept_refund(int order_id){

        Order order=order_mapper.query_order_by_order_id(order_id);
        int db_stock=goods_mapper.query_goods_stock(order.getGoods_id());
        goods_mapper.reduce_goods_sale(order.getGoods_id(),order.getGoods_amount());
        goods_mapper.update_goods_stock(order.getGoods_id(),db_stock+order.getGoods_amount());
        return order_mapper.set_order_state_refund(order_id);
    }

    public int refuse_refund(int order_id){
        return order_mapper.set_order_state_received(order_id);
    }

    public int sign_for_order(int order_id){
        return order_mapper.set_order_state_received(order_id);
    }

}
