package com.hwua.jsp.entity;

public class Good {
    private Integer id;
    private String name;
    private Double price;
    private String img;
    private String detail;
    private Integer type1;
    private Integer type2;
    private Integer kucun;

    public Good() {
    }

    public Good(Integer id, String name, Double price, String img, String detail, Integer type1, Integer type2, Integer kucun) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.detail = detail;
        this.type1 = type1;
        this.type2 = type2;
        this.kucun = kucun;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getType1() {
        return type1;
    }

    public void setType1(Integer type1) {
        this.type1 = type1;
    }

    public Integer getType2() {
        return type2;
    }

    public void setType2(Integer type2) {
        this.type2 = type2;
    }

    public Integer getKucun() {
        return kucun;
    }

    public void setKucun(Integer kucun) {
        this.kucun = kucun;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", img='" + img + '\'' +
                ", detail='" + detail + '\'' +
                ", type1=" + type1 +
                ", type2=" + type2 +
                ", kucun=" + kucun +
                '}';
    }
}
