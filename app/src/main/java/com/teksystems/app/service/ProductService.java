package com.teksystems.app.service;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.Category;
import com.teksystems.app.model.Product;
import com.teksystems.app.tekkart.HomeActivity;
import com.teksystems.app.tekkart.LoginActivity;
import com.teksystems.app.tekkart.ProductActivity;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
            jsonParams.put("locationId", locationId);
            jsonParams.put("categoryId",String.valueOf(categoryId));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(context, "http://knaresh455-eval-test.apigee.net/v1/fullstack/getproductsinfo", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("success");
                Intent intent = new Intent(context, ProductActivity.class);
                //String message = .getText().toString();
                intent.putExtra("userId", userId);
                    intent.putExtra("PRODUCTCATEGORY", Category.valueOf(category));

                   /* String jsonStr = response.toString();
                    System.out.println(jsonStr);
                    List<Product> prodList = new ArrayList<>();
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();

                        for (int i = 0; i < response.length(); i++) {

                            prodList.add(objectMapper.readValue(response.getJSONObject(i).,Product.class));
                        }
                    }catch (IOException|JSONException e){
                        e.printStackTrace();
                    }*/
                    intent.putExtra("PRODUCT", response.toString());

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
}
