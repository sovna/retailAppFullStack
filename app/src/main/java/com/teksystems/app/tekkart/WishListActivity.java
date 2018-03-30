package com.teksystems.app.tekkart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.teksystems.app.model.CartDisplay;
import com.teksystems.app.model.WishList;
import com.teksystems.app.service.ProductService;
import com.teksystems.app.service.WishListService;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WishListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        final Controller aController = (Controller) this.getApplicationContext();

        ListView listView = findViewById(R.id.wishlist);
        listView.setAdapter(new CustomWishListArrayAdapter(this,aController.getWishLists()));

    }
}
