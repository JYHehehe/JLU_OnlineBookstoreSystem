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

    @Select("select price from \"SERVER\".GOODS where goods_id=#{goods_id}")
    double query_goods_unit_price(int goods_id);

    @Select("select view_address from \"SERVER\".GOODS where goods_id=#{goods_id}")
    String query_goods_view_address(int goods_id);

    @Select("select name from \"SERVER\".GOODS where goods_id=#{goods_id}")
    String query_goods_name(int goods_id);

    @Insert("insert into \"SERVER\".REVIEW(goods_id,user_id,grade,describe,\"DATE\",order_id) values(#{goods_id},#{user_id},#{grade},#{describe},#{date},#{order_id})")
    int insert_goods_review(Review review);

    @Select("select * from \"SERVER\".REVIEW where goods_id=#{goods_id}")
    List<Review> query_review_list(int goods_id);
}
