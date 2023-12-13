package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cat_amount_list {

    List<String> cat_name_list;
    List<Integer> amount_list;

    public Cat_amount_list(){
        cat_name_list=new ArrayList<String>();
        amount_list=new ArrayList<Integer>();
    }

    public void add(Cat_amount cat_amount){
        cat_name_list.add(cat_amount.getCategory_name());
        amount_list.add(cat_amount.getAmount());
    }

    public List<String> getCat_name_list() {
        return cat_name_list;
    }

    public void setCat_name_list(List<String> cat_name_list) {
        this.cat_name_list = cat_name_list;
    }

    public List<Integer> getAmount_list() {
        return amount_list;
    }

    public void setAmount_list(List<Integer> amount_list) {
        this.amount_list = amount_list;
    }
}
