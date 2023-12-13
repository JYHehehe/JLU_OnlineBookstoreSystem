package com.control;


import com.dao.Goods_mapper;
import com.dao.Order_mapper;
import com.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("sale")
public class Sale_control {

    @Autowired
    private Goods_mapper goods_mapper;
    @Autowired
    private Order_mapper order_mapper;

    @RequestMapping("get_cat_sale")
    Cat_sale_list get_cat_sale(){

        Cat_sale_list cat_sale_list=new Cat_sale_list();
        List<Cat_sale> cat_sales=goods_mapper.get_cat_sale();
        for(int i=0;i<cat_sales.size();i++){
            cat_sale_list.add(cat_sales.get(i));
        }
        System.out.println(cat_sale_list.toString());
        return cat_sale_list;
    }

    @RequestMapping("get_goods_sale")
    Goods_sale_list get_goods_sale(){

        Goods_sale_list goods_sale_list=new Goods_sale_list();
        List<Goods_sale> goods_sales=goods_mapper.get_goods_sale();
        for(int i=0;i<goods_sales.size() && i<5;i++){
            goods_sale_list.add(goods_sales.get(i));
        }
        return goods_sale_list;
    }

    @RequestMapping("get_goods_amount")
    Goods_amount_list get_goods_amount(){

        Goods_amount_list goods_amount_list=new Goods_amount_list();
        List<Goods_amount> goods_amounts=goods_mapper.get_goods_amount();
        for(int i=0;i<goods_amounts.size() && i<5;i++){
            goods_amount_list.add(goods_amounts.get(i));
        }
        return goods_amount_list;
    }

    @RequestMapping("get_cat_amount")
    Cat_amount_list get_cat_amount(){

        Cat_amount_list cat_amount_list=new Cat_amount_list();
        List<Cat_amount> cat_amounts=goods_mapper.get_cat_amount();
        for(int i=0;i<cat_amounts.size();i++){
            cat_amount_list.add(cat_amounts.get(i));
        }
        return cat_amount_list;
    }

}



