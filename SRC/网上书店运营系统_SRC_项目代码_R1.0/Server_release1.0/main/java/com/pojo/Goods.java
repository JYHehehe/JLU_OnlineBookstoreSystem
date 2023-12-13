package com.pojo;

public class Goods {

    private int goods_id;
    private String name;
    private double price;
    private int stock;
    private int sale;
    private String subtitle;
    private String goods_info;
    private String describe;
    private String view_address;
    private String video_address;
    private int category_id;
    private String[] info_list;
    private String[] desc_list;
    private String key_words;

    public Goods() {
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getGoods_info() {
        return goods_info;
    }

    public void setGoods_info(String goods_info) {
        this.goods_info = goods_info;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getView_address() {
        return view_address;
    }

    public void setView_address(String view_address) {
        this.view_address = view_address;
    }

    public String getVideo_address() {
        return video_address;
    }

    public void setVideo_address(String video_address) {
        this.video_address = video_address;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String[] getInfo_list() {
        return info_list;
    }

    public void setInfo_list(String[] info_list) {
        this.info_list = info_list;
    }

    public String[] getDesc_list() {
        return desc_list;
    }

    public void setDesc_list(String[] desc_list) {
        this.desc_list = desc_list;
    }

    public String getKey_words() {
        return key_words;
    }

    public void setKey_words(String key_words) {
        this.key_words = key_words;
    }
}
