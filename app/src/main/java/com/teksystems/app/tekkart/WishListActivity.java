package com.teksystems.app.tekkart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class WishListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wish_list);
        final Controller aController = (Controller) WishListActivity.this.getApplicationContext();
        ListView listView = findViewById(R.id.wishlist);
        listView.setAdapter(new CustomWishListArrayAdapter(WishListActivity.this,aController.getWishLists()));

    }
}
