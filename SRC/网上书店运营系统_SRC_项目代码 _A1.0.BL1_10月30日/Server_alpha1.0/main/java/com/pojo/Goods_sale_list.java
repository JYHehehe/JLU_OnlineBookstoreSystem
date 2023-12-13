package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Goods_sale_list {

    List<String> goods_name_list;
    List<Integer> sale_list;

    public Goods_sale_list(){
        goods_name_list=new ArrayList<String>();
        sale_list=new ArrayList<Integer>();
    }

    public void add(Goods_sale goods_sale){
        goods_name_list.add(goods_sale.getGoods_name());
        sale_list.add(goods_sale.getSale());
    }

    public List<String> getGoods_name_list() {
        return goods_name_list;
    }

    public void setGoods_name_list(List<String> goods_name_list) {
        this.goods_name_list = goods_name_list;
    }

    public List<Integer> getSale_list() {
        return sale_list;
    }

    public void setSale_list(List<Integer> sale_list) {
        this.sale_list = sale_list;
    }
}
