package com.teksystems.app.tekkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;

import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.teksystems.app.model.Category;
import com.teksystems.app.model.Product;
import com.teksystems.app.model.ProductCart;
import com.teksystems.app.model.Transaction;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductActivity extends AppCompatActivity {
    Transaction transaction = new Transaction();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        final Controller aController = (Controller) ProductActivity.this.getApplicationContext();
        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.categoryname);
        textView.setText("Category: "+aController.getProductCategory());
        ListView listView = findViewById(R.id.productlist);
        listView.setAdapter(new CustomArrayAdapter(ProductActivity.this,aController.getProductCategoryList()));


    }


 public void goToCart(View view){
     final Controller aController = (Controller) ProductActivity.this.getApplicationContext();
     transaction.setProductCartList(aController.getCart());
     transaction.setUserId(Integer.valueOf(getIntent().getStringExtra("userId")));

     Intent intent = new Intent(ProductActivity.this, CartActivity.class);
     intent.putExtra("cart",transaction);
     startActivity(intent);
 }

}