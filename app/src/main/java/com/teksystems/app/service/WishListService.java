package com.teksystems.app.service;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.Order;
import com.teksystems.app.model.WishList;
import com.teksystems.app.tekkart.Controller;
import com.teksystems.app.tekkart.OrderActivity;

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

    public String addToWishList(WishList wishList) {
        try {
            Connection con = new ConnectionClass().getConnections();
            String sql = "INSERT INTO FSTACK.WISHLISTS VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prest = con.prepareStatement(sql);
            prest.setInt(1,wishList.getWishListId());
            prest.setInt(2,wishList.getUserId());
            prest.setInt(3,wishList.getProductId());
            prest.setInt(4,wishList.getProductCategoryId());
            prest.setInt(5,wishList.getManufacturerId());
            prest.setInt(6,wishList.getLocationId());
            prest.setDate(7,new java.sql.Date((new Date()).getTime()));
            prest.setDate(8,new java.sql.Date((new Date()).getTime()));
            ResultSet rs = prest.executeQuery();
            prest.close();
            con.close();
        } catch (SQLException e){
            return "Bad Request";
        }
        return "Success";
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
                        final Controller aController = (Controller) context.getApplicationContext();

                        try {
                            aController.setWishLists(Arrays.asList(new ObjectMapper().readValue(response.toString(), WishList[].class)));
                        } catch (Exception e){
                            e.printStackTrace();
                        }

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
