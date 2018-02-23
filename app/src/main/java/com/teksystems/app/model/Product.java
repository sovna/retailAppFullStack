package com.teksystems.app.model;

import android.os.Parcelable;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;



public  class Product implements Serializable {

    private Integer productId;

    private Integer productCategoryId;
    private Integer manufacturerId;
    private Integer locationId;
    private String productName;
    //private String thumbnailPath;
    private float unitPrice;
    private String uom;

    public Product() {
    }

    public Product(Integer productId, Integer productCategoryId, Integer manufacturerId, Integer locationId, String productName,
                   float unitPrice, String uom) {
        this.productId = productId;
        this.productCategoryId = productCategoryId;
        this.manufacturerId = manufacturerId;
        this.locationId = locationId;
        this.productName = productName;
        // this.thumbnailPath = thumbnailPath;
        this.unitPrice = unitPrice;
        this.uom = uom;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductCategoryId() {
        return productCategoryId;
    }

    public void setProductCategoryId(Integer productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    public Integer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }
}