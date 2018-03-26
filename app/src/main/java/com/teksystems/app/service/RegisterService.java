package com.teksystems.app.service;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.Customer;
import com.teksystems.app.tekkart.Controller;
import com.teksystems.app.tekkart.RegisterActivity;
import com.teksystems.app.tekkart.ViewProfileActivity;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by sopani on 3/25/2018.
 */

public class RegisterService {

    public void addCustomers(final Context context, final Customer customer, final String pass) {

        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();
        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key", "xxTEKyy");
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("username", customer.getCustomerName());
            jsonParams.put("pwd", pass);
            jsonParams.put("customerName", customer.getCustomerName());
            jsonParams.put("customerAddress", customer.getCustomerAddress());
            jsonParams.put("customerContact", customer.getCustomerContact());
            jsonParams.put("cityId", customer.getCityId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(context, ": http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/signup", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("success");
                Intent intent = new Intent(context, ViewProfileActivity.class);
                try {
                    final Controller aController = (Controller) context.getApplicationContext();
                    aController.setCustomer(new ObjectMapper().readValue(response.toString(), Customer.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                context.startActivity(intent);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println("failure");
                Intent intent = new Intent(context, RegisterActivity.class);
                CharSequence text = "Register failed ! Please try again or continue as guest";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, -0, 230);
                toast.show();
                context.startActivity(intent);
            }
        });


    }
}
