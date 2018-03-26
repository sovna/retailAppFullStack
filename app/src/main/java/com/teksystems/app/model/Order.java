package com.teksystems.app.model;

import java.util.Date;

/**
 * Created by sopani on 3/25/2018.
 */

public class Order {
    Integer transactionId;
    Integer transactionLineId;
    Integer userId;
    Integer productId;
    Integer quantity;
    Double amount;
    String transactionDate;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionLineId() {
        return transactionLineId;
    }

    public void setTransactionLineId(Integer transactionLineId) {
        this.transactionLineId = transactionLineId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }
}
