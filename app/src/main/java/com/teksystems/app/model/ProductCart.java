package com.teksystems.app.model;

import java.io.Serializable;

/**
 * Created by sopani on 2/19/2018.
 */

public class ProductCart implements Serializable{
    Integer orderLine;
    Integer productId;
    int quantity = 0;
    double orderAmount;
    Integer productCategoryId;
    Integer manufacturerId;
    Integer locationId;
    String productUom;
    String transactionType;



    public Integer getOrderLine() {
        return orderLine;
    }

    public void setOrderLine(Integer orderLine) {
        this.orderLine = orderLine;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double rateAmount) {
        this.orderAmount = this.quantity*rateAmount;
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

    public String getProductUom() {
        return productUom;
    }

    public void setProductUom(String productUom) {
        this.productUom = productUom;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
