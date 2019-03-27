package com.hwua.jsp.entity;

public class OrderDetail {
    private Integer id;
    private Integer goodid;
    private Integer orderid;
    private Integer count;
    private Double price;

    public OrderDetail() {
    }

    public OrderDetail(Integer id, Integer goodid, Integer orderid, Integer count, Double price) {
        this.id = id;
        this.goodid = goodid;
        this.orderid = orderid;
        this.count = count;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", goodid=" + goodid +
                ", orderid=" + orderid +
                ", count=" + count +
                ", price=" + price +
                '}';
    }
}
