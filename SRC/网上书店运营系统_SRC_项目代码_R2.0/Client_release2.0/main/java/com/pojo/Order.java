package com.pojo;

public class Order {
    private int order_id;
    private int goods_id;
    private int goods_amount;
    private double paid_amount;
    private int user_id;
    private int address_id;
    private int state;
    private String date;
    //以下这些属性不存入数据库，但是要返回给前端做页面展示
    private String goods_name;
    private String address_name;
    private String view_address;
    private String state_desc;

    public Order() {
    }

    public void set_attributes(Cart cart){
        goods_id= cart.getGoods_id();
        goods_amount= cart.getGoods_amount();
        user_id= cart.getUser_id();
        address_id= cart.getAddress_id();
    }

    public void setState_desc() {
        if(state==1){
            setState_desc("待发货");
        }
        else if(state==2){
            setState_desc("已发货");
        }
        else if(state==3){
            setState_desc("已签收");
        }
        else if(state==4){
            setState_desc("已评价");
        }
        else if(state==5){
            setState_desc("申请退款中");
        }
        else if(state==6){
            setState_desc("订单已取消");
        }
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public int getGoods_amount() {
        return goods_amount;
    }

    public void setGoods_amount(int goods_amount) {
        this.goods_amount = goods_amount;
    }

    public double getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(double paid_amount) {
        this.paid_amount = paid_amount;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getAddress_name() {
        return address_name;
    }

    public void setAddress_name(String address_name) {
        this.address_name = address_name;
    }

    public String getView_address() {
        return view_address;
    }

    public void setView_address(String view_address) {
        this.view_address = view_address;
    }

    public String getState_desc() {
        return state_desc;
    }

    public void setState_desc(String state_desc) {
        this.state_desc = state_desc;
    }

}
