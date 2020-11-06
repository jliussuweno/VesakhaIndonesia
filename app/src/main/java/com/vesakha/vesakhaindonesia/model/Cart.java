package com.vesakha.vesakhaindonesia.model;

public class Cart {
    private String idCart;
    private String idDivisi;
    private String idCategory;
    private String nameProduct;
    private String description;
    private String detail;
    private String spec;
    private String specval;
    private String img;
    private String price;
    private String weight;
    private String stock;
    private String disc;
    private String ddisc;
    private String addDate;
    private String qty;

    public Cart(String idCart, String idDivisi, String idCategory, String nameProduct, String description, String detail, String spec, String specval, String img, String price, String weight, String stock, String disc, String ddisc, String addDate, String qty) {
        this.idCart = idCart;
        this.idDivisi = idDivisi;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
        this.description = description;
        this.detail = detail;
        this.spec = spec;
        this.specval = specval;
        this.img = img;
        this.price = price;
        this.weight = weight;
        this.stock = stock;
        this.disc = disc;
        this.ddisc = ddisc;
        this.addDate = addDate;
        this.qty = qty;
    }

    public String getIdCart() {
        return idCart;
    }

    public void setIdCart(String idCart) {
        this.idCart = idCart;
    }

    public String getIdDivisi() {
        return idDivisi;
    }

    public void setIdDivisi(String idDivisi) {
        this.idDivisi = idDivisi;
    }

    public String getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(String idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSpecval() {
        return specval;
    }

    public void setSpecval(String specval) {
        this.specval = specval;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getDdisc() {
        return ddisc;
    }

    public void setDdisc(String ddisc) {
        this.ddisc = ddisc;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }
}
