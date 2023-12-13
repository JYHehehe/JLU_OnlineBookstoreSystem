package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Goods_amount_list {

    List<String> goods_name_list;
    List<Integer> amount_list;

    public Goods_amount_list(){
        goods_name_list=new ArrayList<String>();
        amount_list=new ArrayList<Integer>();
    }

    public void add(Goods_amount goods_amount){
        goods_name_list.add(goods_amount.getGoods_name());
        amount_list.add(goods_amount.getAmount());
    }

    public List<String> getGoods_name_list() {
        return goods_name_list;
    }

    public void setGoods_name_list(List<String> goods_name_list) {
        this.goods_name_list = goods_name_list;
    }

    public List<Integer> getAmount_list() {
        return amount_list;
    }

    public void setAmount_list(List<Integer> amount_list) {
        this.amount_list = amount_list;
    }
}
