package com.teksystems.app.tekkart;

/**
 * Created by sopani on 3/21/2018.
 */

import java.util.ArrayList;
import java.util.List;

import android.app.Application;

import com.teksystems.app.model.Customer;
import com.teksystems.app.model.Order;
import com.teksystems.app.model.Product;
import com.teksystems.app.model.ProductCart;
import com.teksystems.app.model.WishList;

public class Controller extends Application{

    private String userId;
    private List<Product> products = new ArrayList<>();
     List<ProductCart> productCarts =new ArrayList<>();
     Customer customer = new Customer();
     List<Order> orders =new ArrayList<>();
     List<WishList> wishLists = new ArrayList<>();

    public List<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(List<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public WishList getWishList(int pPosition) {

        return wishLists.get(pPosition);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Order getOrder(int pPosition) {

        return orders.get(pPosition);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Product getProducts(int pPosition) {

        return products.get(pPosition);
    }

    public List<ProductCart> getProductCarts() {
        return productCarts;
    }

    public void setProductCarts(List<ProductCart> productCarts) {
        this.productCarts = productCarts;
    }

    public List<Product> getProducts() {

        return products;
    }


    public void setProducts(List<Product> products) {

        this.products = products;

    }
    public ProductCart getCart(int pPosition) {

        return productCarts.get(pPosition);
    }

    public List<ProductCart> getCart() {

        return productCarts;

    }

    public int getProductsArraylistSize() {

        return products.size();
    }

}
