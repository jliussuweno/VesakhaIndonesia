package com.vesakha.vesakhaindonesia.model;

import java.io.Serializable;

public class Product implements Serializable {
    String idProduct;
    String nameProduct;
    String urlImage;
    String priceProduct;
    String stockProduct;
    String storeId;
    String ongkirStore;

    public Product(String idProduct, String nameProduct, String urlImage, String priceProduct, String stockProduct, String storeId, String ongkirStore) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.urlImage = urlImage;
        this.priceProduct = priceProduct;
        this.stockProduct = stockProduct;
        this.storeId = storeId;
        this.ongkirStore = ongkirStore;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
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

    public String getStockProduct() {
        return stockProduct;
    }

    public void setStockProduct(String stockProduct) {
        this.stockProduct = stockProduct;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getOngkirStore() {
        return ongkirStore;
    }

    public void setOngkirStore(String ongkirStore) {
        this.ongkirStore = ongkirStore;
    }
}
