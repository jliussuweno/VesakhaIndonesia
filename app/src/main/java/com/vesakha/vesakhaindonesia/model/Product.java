package com.vesakha.vesakhaindonesia.model;

import java.io.Serializable;

public class Product implements Serializable {
    String idProduct;
    String idDivisi;
    String idCategory;
    String nameProduct;
    String description;
    String detail;
    String spec;
    String specVal;
    String urlImage;
    String priceProduct;
    String weight;
    String stockProduct;
    String disc;
    String dDisc;
    String addDate;
    String link;

    public Product(String idProduct, String idDivisi, String idCategory, String nameProduct, String description, String detail, String spec, String specVal, String urlImage, String priceProduct, String weight, String stockProduct, String disc, String dDisc, String addDate, String link) {
        this.idProduct = idProduct;
        this.idDivisi = idDivisi;
        this.idCategory = idCategory;
        this.nameProduct = nameProduct;
        this.description = description;
        this.detail = detail;
        this.spec = spec;
        this.specVal = specVal;
        this.urlImage = urlImage;
        this.priceProduct = priceProduct;
        this.weight = weight;
        this.stockProduct = stockProduct;
        this.disc = disc;
        this.dDisc = dDisc;
        this.addDate = addDate;
        this.link = link;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
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

    public String getSpecVal() {
        return specVal;
    }

    public void setSpecVal(String specVal) {
        this.specVal = specVal;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(String priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(String stockProduct) {
        this.stockProduct = stockProduct;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getdDisc() {
        return dDisc;
    }

    public void setdDisc(String dDisc) {
        this.dDisc = dDisc;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
