package com.teksystems.app.model;

import java.io.Serializable;

/**
 * Created by sopani on 3/19/2018.
 */

public class CartDisplay implements Serializable {

    private String productName;
    int quantity = 0;
    public CartDisplay(){}
    public CartDisplay(String productName, int quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
