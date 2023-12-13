package com.service;


import com.dao.Goods_mapper;
import com.dao.Order_mapper;
import com.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class Goods_service {

    @Autowired
    private Goods_mapper goods_mapper;

    @Autowired
    private Order_mapper order_mapper;

    public List<Goods_category> query_all_goods_cat(){
        return goods_mapper.query_all_goods_cat();
    }

    public List<Goods> query_all_goods(){
        return goods_mapper.query_all_goods();
    }

    public List<Review> query_review_list(int goods_id){
        return goods_mapper.query_review_list(goods_id);
    }

    public String ClobToString(Clob clob) {
        String reString = "";
        Reader is = null;
        try {
            is = clob.getCharacterStream();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 得到流
        BufferedReader br = new BufferedReader(is);
        String s = null;
        try {
            s = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        StringBuffer sb = new StringBuffer();
        while (s != null) {
            //执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
            sb.append(s);
            try {
                s = br.readLine();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        reString = sb.toString();
        return reString;
    }

    public Goods get_goods(int goods_id){
        Goods goods=goods_mapper.get_goods(goods_id);
        //转换一下属性
        if(goods.getGoods_info()!=null){
            goods.setInfo_list(goods.getGoods_info().split("#"));
        }
        if(goods.getDescribe()!=null){
            goods.setDesc_list(goods.getDescribe().split("#"));
        }
        return goods;
    }

    public List<Goods> query_goods_list(Goods_request request){
        if (request.getGoods_name()==null){
            request.setGoods_name("");
        }
        //逻辑处理
        if(request.getSort_id()==0){
            //默认排序
            if(request.getCategory_id()==0){
                //不选类别
                return goods_mapper.query_good_by_id_asc_all_cat(request);
            }
            return goods_mapper.query_good_by_id_asc(request);
        }
        else if (request.getSort_id()==1){
            //按销量排序
            if(request.getCategory_id()==0){
                //不选类别
                return goods_mapper.query_good_by_sale_desc_all_cat(request);
            }
            return goods_mapper.query_good_by_sale_desc(request);
        }
        else if (request.getSort_id()==2){
            //高价优先
            if(request.getCategory_id()==0){
                //不选类别
                return goods_mapper.query_good_by_price_desc_all_cat(request);
            }
            return goods_mapper.query_good_by_price_desc(request);

        }
        else if (request.getSort_id()==3){
            //低价优先
            if(request.getCategory_id()==0){
                //不选类别
                return goods_mapper.query_good_by_price_asc_all_cat(request);
            }
            return goods_mapper.query_good_by_price_asc(request);
        }
        return null;
    }

    public List<Goods_image> query_goods_image(int goods_id){
        return goods_mapper.query_goods_image(goods_id);
    }

    public int submit_review(Review review){
        //设置order的状态
        order_mapper.set_order_state_reviewed(review.getOrder_id());
        //插入一条评价
        //设置时间
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        review.setDate(df.format(new Date()));
        return goods_mapper.insert_goods_review(review);
    }


}
