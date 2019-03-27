package com.hwua.jsp.entity;

public class address {
    private Integer id;
    private String shengid;
    private String shiid;
    private String quid;
    private String detail;
    private String shou;
    private String phone;

    public address() {
    }

    public address(Integer id, String shengid, String shiid, String quid, String detail, String shou, String phone) {
        this.id = id;
        this.shengid = shengid;
        this.shiid = shiid;
        this.quid = quid;
        this.detail = detail;
        this.shou = shou;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShengid() {
        return shengid;
    }

    public void setShengid(String shengid) {
        this.shengid = shengid;
    }

    public String getShiid() {
        return shiid;
    }

    public void setShiid(String shiid) {
        this.shiid = shiid;
    }

    public String getQuid() {
        return quid;
    }

    public void setQuid(String quid) {
        this.quid = quid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getShou() {
        return shou;
    }

    public void setShou(String shou) {
        this.shou = shou;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "address{" +
                "id=" + id +
                ", shengid='" + shengid + '\'' +
                ", shiid='" + shiid + '\'' +
                ", quid='" + quid + '\'' +
                ", detail='" + detail + '\'' +
                ", shou='" + shou + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
