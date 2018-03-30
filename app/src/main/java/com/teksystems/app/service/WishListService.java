package com.teksystems.app.service;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.Order;
import com.teksystems.app.model.WishList;
import com.teksystems.app.tekkart.CartActivity;
import com.teksystems.app.tekkart.Controller;
import com.teksystems.app.tekkart.HomeActivity;
import com.teksystems.app.tekkart.OrderActivity;
import com.teksystems.app.tekkart.WishListActivity;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by sopani on 3/24/2018.
 */

public class WishListService {

    public void addToWishList(final Context context,final WishList wishList) { StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();

        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key","xxTEKyy");
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("userId", wishList.getUserId());
            jsonParams.put("productId",wishList.getProductId());
            jsonParams.put("productCategoryId", wishList.getProductCategoryId());
            jsonParams.put("manufacturerId",wishList.getManufacturerId());
            jsonParams.put("locationId", wishList.getLocationId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(context, "http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/createWishlist", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("success");

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println("failure");

                CharSequence text = "Product is in your wishlist already";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, -0, 230);
                toast.show();
//                intent.putExtra(EXTRA_MESSAGE, text);
                //startActivity(intent);
            }
        });

    }

    public void getWishList(final Context context, final String userId) {

        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();
        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key", "xxTEKyy");
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("userId", userId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(context, "http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/getWishlist",
                jsonEntity, "application/json", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                        super.onSuccess(statusCode, headers, response);
                        System.out.println("success");
                        Intent intent = new Intent(context, WishListActivity.class);
                        final Controller aController = (Controller) context.getApplicationContext();
                        try {
                            aController.setWishLists(Arrays.asList(new ObjectMapper().readValue(response.toString(), WishList[].class)));
                        } catch (Exception e){
                            e.printStackTrace();
                        }
                        context.startActivity(intent);
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        System.out.println("failure");
                        Intent intent = new Intent(context, OrderActivity.class);
                        CharSequence text = errorResponse.toString();
                        int duration = Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.setGravity(Gravity.TOP, -0, 230);
                        toast.show();
//                intent.putExtra(EXTRA_MESSAGE, text);
                        context.startActivity(intent);
                    }
                });
    }

}
