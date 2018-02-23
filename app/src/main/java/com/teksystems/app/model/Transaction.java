package com.teksystems.app.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sopani on 2/19/2018.
 */

public class Transaction implements Serializable{

    Integer userId;
    List<ProductCart> productCartList;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<ProductCart> getProductCartList() {
        return productCartList;
    }

    public void setProductCartList(List<ProductCart> productCartList) {
        this.productCartList = productCartList;
    }
}
