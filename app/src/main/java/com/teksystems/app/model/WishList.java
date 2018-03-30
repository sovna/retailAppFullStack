package com.teksystems.app.model;

import java.util.Date;

/**
 * Created by sopani on 3/24/2018.
 */

public class WishList {

    Integer wishlistId;
    String productName;
    Integer productId;
    Integer userId;
    Integer productCategoryId;
    Integer manufacturerId;
    Integer locationId;
    String wishlistDate;
    Date LastUpdatedDate;

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getWishListId() {
        return wishlistId;
    }

    public void setWishListId(Integer wishListId) {
        this.wishlistId = wishListId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getWishlistDate() {
        return wishlistDate;
    }

    public void setWishlistDate(String wishListDate) {
        this.wishlistDate = wishListDate;
    }

    public Date getLastUpdatedDate() {
        return LastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        LastUpdatedDate = lastUpdatedDate;
    }
}
