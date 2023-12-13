package com.dao;

import com.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface Goods_mapper {

    @Select("select * from \"SERVER\".GOODS_CATEGORY order by CATEGORY_ID")
    List<Goods_category> query_all_goods_cat();

    @Select("select * from \"SERVER\".GOODS order by GOODS_ID")
    List<Goods> query_all_goods();

    @Select("select * from \"SERVER\".GOODS where goods_id=#{goods_id}")
    Goods get_goods(int goods_id);

    @Select("select * from \"SERVER\".GOODS where category_id=#{category_id} and price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by GOODS_ID ASC")
    List<Goods> query_good_by_id_asc(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where category_id=#{category_id} and price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by SALE DESC")
    List<Goods> query_good_by_sale_desc(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where category_id=#{category_id} and price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by PRICE DESC")
    List<Goods> query_good_by_price_desc(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where category_id=#{category_id} and price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by PRICE ASC")
    List<Goods> query_good_by_price_asc(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by GOODS_ID ASC")
    List<Goods> query_good_by_id_asc_all_cat(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by SALE DESC")
    List<Goods> query_good_by_sale_desc_all_cat(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by PRICE DESC")
    List<Goods> query_good_by_price_desc_all_cat(Goods_request request);

    @Select("select * from \"SERVER\".GOODS where price<=#{max_price} and price>=#{min_price} and (name like CONCAT(CONCAT('%',#{goods_name}),'%') or key_words like CONCAT(CONCAT('%',#{goods_name}),'%')) order by PRICE ASC")
    List<Goods> query_good_by_price_asc_all_cat(Goods_request request);

    @Select("select * from \"SERVER\".GOODS_IMAGE where goods_id=#{goods_id}")
    List<Goods_image> query_goods_image(int goods_id);

    @Select("select stock from \"SERVER\".GOODS where goods_id=#{goods_id}")
    int query_goods_stock(int goods_id);

    @Update("update \"SERVER\".GOODS set stock=#{new_stock} where goods_id=#{goods_id}")
    int update_goods_stock(int goods_id,int new_stock);

    @Update("update \"SERVER\".GOODS set sale=sale+#{sale_increase} where goods_id=#{goods_id}")
    int add_goods_sale(int goods_id,int sale_increase);

    @Update("update \"SERVER\".GOODS set sale=sale-#{sale_decrease} where goods_id=#{goods_id}")
    int reduce_goods_sale(int goods_id,int sale_decrease);

    @Select("select price from \"SERVER\".GOODS where goods_id=#{goods_id}")
    double query_goods_unit_price(int goods_id);

    @Select("select view_address from \"SERVER\".GOODS where goods_id=#{goods_id}")
    String query_goods_view_address(int goods_id);

    @Select("select name from \"SERVER\".GOODS where goods_id=#{goods_id}")
    String query_goods_name(int goods_id);

    @Insert("insert into \"SERVER\".REVIEW(goods_id,user_id,grade,describe,\"DATE\",order_id) values(#{goods_id},#{user_id},#{grade},#{describe},#{date},#{order_id})")
    int insert_goods_review(Review review);

    @Insert("insert into \"SERVER\".GOODS(name,price,stock,sale,subtitle,goods_info,describe,category_id,key_words) values(#{name},#{price},#{stock},#{sale},#{subtitle},#{goods_info},#{describe},#{category_id},#{key_words})")
    int add_goods(Goods goods);

    @Select("select * from \"SERVER\".REVIEW where goods_id=#{goods_id}")
    List<Review> query_review_list(int goods_id);

    @Update("update \"SERVER\".GOODS set name=#{name},price=#{price},stock=#{stock},sale=#{sale},subtitle=#{subtitle},goods_info=#{goods_info},describe=#{describe},category_id=#{category_id},key_words=#{key_words} where goods_id=#{goods_id}")
    int modify_goods(Goods goods);

    @Update("update \"SERVER\".GOODS set view_address=#{view_address} where goods_id=#{goods_id}")
    int set_goods_view(String goods_id,String view_address);

    @Select("select * from CAT_SALE_VIEW")
    List<Cat_sale> get_cat_sale();

    @Select("select GOODS_NAME,SALE from SALE_VIEW ORDER BY SALE DESC")
    List<Goods_sale> get_goods_sale();

    @Select("select GOODS_NAME,SUM(PAID_AMOUNT) as AMOUNT from SALE_AMOUNT_VIEW GROUP BY GOODS_NAME ORDER BY AMOUNT DESC")
    List<Goods_amount> get_goods_amount();

    @Select("select CATEGORY_NAME,SUM(PAID_AMOUNT) as AMOUNT from SALE_AMOUNT_VIEW GROUP BY CATEGORY_NAME")
    List<Cat_amount> get_cat_amount();



}
