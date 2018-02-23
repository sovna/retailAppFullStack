package com.teksystems.app.tekkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.model.Category;
import com.teksystems.app.model.ProductCart;
import com.teksystems.app.model.Transaction;
import com.teksystems.app.tekkart.R;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        String userId = getIntent().getStringExtra("userId");
        ProductCart productCart = (ProductCart) getIntent().getSerializableExtra("cart");
        TextView textView = findViewById(R.id.productid);
        textView.setText(String.valueOf(productCart.getProductId()));
    }
    public void placeOrder(View view){
        String userId = getIntent().getStringExtra("userId");
        ProductCart productCart = (ProductCart) getIntent().getSerializableExtra("cart");

        Transaction transaction = new Transaction();
        List<ProductCart> productCartList = new ArrayList<>();
        productCartList.add(productCart);
        transaction.setProductCartList(productCartList);
        transaction.setUserId(Integer.valueOf(userId));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonTxStr = new String();
        try {
             jsonTxStr = objectMapper.writeValueAsString(transaction);
        }catch (IOException e){
            e.printStackTrace();
        }
        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();

        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key","xxTEKyy");
       /* JSONObject jsonParams = new JSONObject();
        try {
            //Integer categoryId = Category.valueOf(category).getValue();
            jsonParams.put("userId", userId);
            jsonParams.put("productCartList",productCartList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
       */ try {
            jsonEntity = new StringEntity(jsonTxStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        client.post(CartActivity.this, "http://knaresh455-eval-test.apigee.net/v1/fullstack/createtransaction", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("success");
                Intent intent = new Intent(CartActivity.this,HomeActivity.class);
                intent.putExtra("userId",getIntent().getStringExtra("userId"));
                startActivity(intent);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println("failure");

                CharSequence text = "Retry!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(CartActivity.this, text, duration);
                toast.setGravity(Gravity.TOP, -0, 230);
                toast.show();
//                intent.putExtra(EXTRA_MESSAGE, text);
                //startActivity(intent);
            }
        });



    }
}
