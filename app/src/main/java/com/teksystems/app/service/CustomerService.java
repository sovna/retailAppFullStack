package com.teksystems.app.service;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.Category;
import com.teksystems.app.model.Customer;
import com.teksystems.app.tekkart.Controller;
import com.teksystems.app.tekkart.LoginActivity;
import com.teksystems.app.tekkart.ProductActivity;
import com.teksystems.app.tekkart.ViewProfileActivity;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by sopani on 3/25/2018.
 */

public class CustomerService {



    public void getCustomers(final Context context,final String userId){

        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();
        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key","xxTEKyy");
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


        client.post(context, "http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/getCustomer", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("success");
                Intent intent = new Intent(context, ViewProfileActivity.class);
                try{
                final Controller aController = (Controller) context.getApplicationContext();
                aController.setCustomer(new ObjectMapper().readValue(response.toString(),Customer.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                context.startActivity(intent);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println("failure");
                Intent intent = new Intent(context, ViewProfileActivity.class);

                context.startActivity(intent);
            }
        });



    }
}
