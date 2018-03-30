package com.teksystems.app.service;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.CartDisplay;
import com.teksystems.app.model.Category;
import com.teksystems.app.model.Product;
import com.teksystems.app.tekkart.Controller;
import com.teksystems.app.tekkart.HomeActivity;
import com.teksystems.app.tekkart.LoginActivity;
import com.teksystems.app.tekkart.OrderActivity;
import com.teksystems.app.tekkart.ProductActivity;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

/**
 * Created by sopani on 2/18/2018.
 */

public class ProductService {

    public void getproducts(final Context context, String locationId, final String category, final String userId){
        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();
        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key","xxTEKyy");
        JSONObject jsonParams = new JSONObject();
        try {
            Integer categoryId = Category.valueOf(category).getValue();
            jsonParams.put("locationId", locationId!=null?locationId:"601");
            jsonParams.put("categoryId",String.valueOf(categoryId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(context, "http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/getProducts", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("success");
                final Controller aController = (Controller) context.getApplicationContext();
                Intent intent = new Intent(context, ProductActivity.class);
                aController.setProductCategory(Category.valueOf(category).getKey());
                List<Product> productCategoryList = getObjectFromString(response.toString());
                for(Product productCategoryWise : productCategoryList) {
                    aController.getProductCategoryList().add(productCategoryWise);
                }
                context.startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println("failure");
                Intent intent = new Intent(context, LoginActivity.class);
                CharSequence text = "Retry!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, -0, 230);
                toast.show();
//                intent.putExtra(EXTRA_MESSAGE, text);
                context.startActivity(intent);
            }
        });



    }

    public List<Product> getObjectFromString(String productjsonstr){
        Product[] productList= new Product[0];
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            productList = objectMapper.readValue(productjsonstr, Product[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> list = new ArrayList<Product>();
        list = Arrays.asList(productList);
        System.out.println(list);
        return list;
    }

    public CartDisplay getProductName(Context context,String productId){
        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();
        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key", "xxTEKyy");
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("productId", productId);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

final CartDisplay cartDisplay = new CartDisplay();

        client.post(context,"http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/getProductById",
                jsonEntity, "application/json", new JsonHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        System.out.println("success");
                        try {
                            cartDisplay.setProductName(response.get("productName").toString());
                        } catch(JSONException e){
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                        System.out.println("failure");

                    }
                });
        return cartDisplay;
    }

}
