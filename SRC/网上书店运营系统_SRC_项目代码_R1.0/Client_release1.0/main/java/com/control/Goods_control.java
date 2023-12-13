package com.control;


import com.pojo.*;
import com.service.Goods_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("goods")
@RestController
public class Goods_control {

    @Autowired
    private Goods_service goods_service;

    @RequestMapping("query_all_goods_cat")
    List<Goods_category> query_all_goods_cat(){
        return goods_service.query_all_goods_cat();
    }

    @RequestMapping("query_all_goods")
    List<Goods> query_all_goods(){
        return goods_service.query_all_goods();
    }

    @RequestMapping("query_goods_list")
    List<Goods> query_goods_list(Goods_request request){
        System.out.println("----------------------------------------------");
        System.out.println(request.toString());
        System.out.println("----------------------------------------------");
        return goods_service.query_goods_list(request);
    }

    @RequestMapping("query_review_list")
    List<Review> query_review_list(int goods_id){
        return goods_service.query_review_list(goods_id);
    }

    @RequestMapping("get_goods")
    Goods get_goods(int goods_id){
        return goods_service.get_goods(goods_id);
    }

    @RequestMapping("query_goods_image")
    List<Goods_image> query_goods_image(int goods_id){
        return goods_service.query_goods_image(goods_id);
    }

    @RequestMapping("submit_review")
    int submit_review(Review review){
        return goods_service.submit_review(review);
    }

}
