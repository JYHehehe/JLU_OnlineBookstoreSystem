package com.pojo;

import java.util.ArrayList;
import java.util.List;

public class Cat_sale_list {
    List<String> cat_name_list;
    List<Integer> sale_list;

    public Cat_sale_list(){
        cat_name_list=new ArrayList<String>();
        sale_list=new ArrayList<Integer>();
    }

    public void add(Cat_sale cat_sale){
        cat_name_list.add(cat_sale.getCategory_name());
        sale_list.add(cat_sale.getSale());
    }

    public List<String> getCat_name_list() {
        return cat_name_list;
    }

    public void setCat_name_list(List<String> cat_name_list) {
        this.cat_name_list = cat_name_list;
    }

    public List<Integer> getSale_list() {
        return sale_list;
    }

    public void setSale_list(List<Integer> sale_list) {
        this.sale_list = sale_list;
    }

    @Override
    public String toString() {
        return "{" +
                "cat_name_list=" + cat_name_list +
                ", sale_list=" + sale_list +
                '}';
    }
}
