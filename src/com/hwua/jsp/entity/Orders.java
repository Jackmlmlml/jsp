package com.hwua.jsp.entity;

import java.util.Date;

public class Orders {
    private Integer id;
    private Integer userid;
    private Date createDate;
    private String code;
    private Double total;
    private String status;
    private Integer addressid;

    public Orders() {
    }

    public Orders(Integer id, Integer userid, Date createDate, String code, Double total, String status, Integer addressid) {
        this.id = id;
        this.userid = userid;
        this.createDate = createDate;
        this.code = code;
        this.total = total;
        this.status = status;
        this.addressid = addressid;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAddressid() {
        return addressid;
    }

    public void setAddressid(Integer addressid) {
        this.addressid = addressid;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", userid=" + userid +
                ", createDate=" + createDate +
                ", code='" + code + '\'' +
                ", total=" + total +
                ", status='" + status + '\'' +
                ", addressid=" + addressid +
                '}';
    }
}
