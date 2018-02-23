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
}
