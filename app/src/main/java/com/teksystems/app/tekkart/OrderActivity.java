package com.teksystems.app.tekkart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final Controller aController = (Controller) OrderActivity.this.getApplicationContext();
        ListView listView = findViewById(R.id.orderlist);
        listView.setAdapter(new CustomOrderArrayAdapter(OrderActivity.this,aController.getOrders()));
    }
}
