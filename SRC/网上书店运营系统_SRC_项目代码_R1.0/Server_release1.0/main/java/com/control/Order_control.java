package com.control;


import com.pojo.Cart;
import com.pojo.Order;
import com.service.Order_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("order")
@RestController
public class Order_control {

    @Autowired
    Order_service order_service;

    @RequestMapping("add_to_cart")
    int add_to_cart(Cart cart){
        return order_service.add_to_cart(cart);
    }
    @RequestMapping("add_to_order")
    int add_to_order(Order order){
        return order_service.add_to_order(order);
    }
    @RequestMapping("query_cart_list")
    List<Cart> query_cart_list(int user_id){
        return order_service.query_cart_list(user_id);
    }

    @RequestMapping("query_order_list")
    List<Order> query_order_list(int user_id){
        return order_service.query_order_list(user_id);
    }

    @RequestMapping("query_all_order_list")
    List<Order> query_all_order_list(){
        return order_service.query_all_order_list();
    }

    @RequestMapping("query_orders_view")
    List<Order> query_orders_view(int state){
        return order_service.query_orders_view(state);
    }

    @RequestMapping("query_order_by_order_id")
    Order query_order_by_order_id(int order_id){
        return order_service.query_order_by_order_id(order_id);
    }

    @RequestMapping("update_cart_goods_amount")
    int update_cart_goods_amount(int cart_id,int goods_amount){
        return order_service.update_cart_goods_amount(cart_id,goods_amount);
    }

    @RequestMapping("pay_one_cart")
    int pay_one_cart(int cart_id){
        return order_service.pay_one_cart(cart_id);
    }

    @RequestMapping("delete_one_cart")
    int delete_one_cart(int cart_id){
        return order_service.delete_one_cart(cart_id);
    }

    @RequestMapping("delete_cart_list")
    int delete_cart_list(int cart_id_list[]){
        int sum=0;
        for (int i = 0; i < cart_id_list.length; i++) {
            sum+=delete_one_cart(cart_id_list[i]);
        }
        return sum;
    }

    @RequestMapping("pay_cart_list")
    int pay_cart_list(int cart_id_list[]){
        int sum=0;
        for (int i = 0; i < cart_id_list.length; i++) {
            sum+=pay_one_cart(cart_id_list[i]);
        }
        return sum;
    }

    @RequestMapping("direct_refund")
    int direct_refund(int order_id){
        return order_service.direct_refund(order_id);
    }

    @RequestMapping("send_out")
    int send_out(int order_id){
        return order_service.send_out(order_id);
    }

    @RequestMapping("accept_refund")
    int accept_refund(int order_id){
        return order_service.accept_refund(order_id);
    }

    @RequestMapping("refuse_refund")
    int refuse_refund(int order_id){
        return order_service.refuse_refund(order_id);
    }

    @RequestMapping("sign_for_order")
    int sign_for_order(int order_id){
        return order_service.sign_for_order(order_id);
    }

}
