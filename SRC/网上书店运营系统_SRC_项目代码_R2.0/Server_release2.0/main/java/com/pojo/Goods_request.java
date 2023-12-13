package com.pojo;

public class Goods_request {

    private int category_id;
    private int sort_id;
    private double min_price;
    private double max_price;
    private String goods_name;

    public Goods_request() {
    }

    @Override
    public String toString() {
        return "Goods_request{" +
                "category_id=" + category_id +
                ", sort_id=" + sort_id +
                ", min_price=" + min_price +
                ", max_price=" + max_price +
                ", goods_name='" + goods_name + '\'' +
                '}';
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getSort_id() {
        return sort_id;
    }

    public void setSort_id(int sort_id) {
        this.sort_id = sort_id;
    }

    public double getMin_price() {
        return min_price;
    }

    public void setMin_price(double min_price) {
        this.min_price = min_price;
    }

    public double getMax_price() {
        return max_price;
    }

    public void setMax_price(double max_price) {
        this.max_price = max_price;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }
}
