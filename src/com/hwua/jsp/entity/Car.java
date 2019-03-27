package com.hwua.jsp.entity;

public class Car {
    private Integer id;
    private Integer userid;
    private Integer goodid;
    private Integer counts;

    public Car() {
    }

    public Car(Integer id, Integer userid, Integer goodid, Integer counts) {
        this.id = id;
        this.userid = userid;
        this.goodid = goodid;
        this.counts = counts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodid() {
        return goodid;
    }

    public void setGoodid(Integer goodid) {
        this.goodid = goodid;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", userid=" + userid +
                ", goodid=" + goodid +
                ", counts=" + counts +
                '}';
    }
}
