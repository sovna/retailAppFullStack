package com.teksystems.app.tekkart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.teksystems.app.model.Category;
import com.teksystems.app.model.Product;
import com.teksystems.app.model.ProductCart;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Intent intent = getIntent();
        Category category = (Category) intent.getSerializableExtra("PRODUCTCATEGORY");
        List<Product> list = getObjectFromString(intent);


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.categoryname);
        textView.setText("Category: "+category.getKey());
        ListView listView = findViewById(R.id.productlist);
        listView.setAdapter(new CustomArrayAdapter(ProductActivity.this,list));


    }

 public void addToCart(View view) {
     ImageButton imageButton = findViewById(R.id.add);
     List<Product> list = getObjectFromString(getIntent());
     TextView productNametextv = findViewById(R.id.firstLine);
      String productName = productNametextv.getText().toString();
     ProductCart productCart = new ProductCart();
     productCart.setOrderLine(1);
     productCart.setQuantity(productCart.getQuantity()+1);
     for(Product product :list) {
         if(productName.equalsIgnoreCase(product.getProductName()))
             productCart.setProductId(product.getProductId());
         productCart.setOrderAmount(product.getUnitPrice());
     }
     String userId = getIntent().getStringExtra("userId");
     Intent intent = new Intent(ProductActivity.this, CartActivity.class);
     intent.putExtra("userId",userId);
     intent.putExtra("cart",productCart);
     startActivity(intent);
 }

 public List<Product> getObjectFromString(Intent intent){
     String productjsonstr = intent.getStringExtra("PRODUCT");
     Product[] productList= new Product[2];
     try {
         ObjectMapper objectMapper = new ObjectMapper();
         productList = objectMapper.readValue(productjsonstr, Product[].class);
     } catch (IOException e) {
         e.printStackTrace();
     }
     List<Product> list = new ArrayList<Product>();
     list = Arrays.asList(productList);
     return list;
 }
}