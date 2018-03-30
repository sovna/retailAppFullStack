package com.teksystems.app.tekkart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.teksystems.app.model.Order;
import com.teksystems.app.service.OrderService;

import org.codehaus.jackson.map.ObjectMapper;

import java.util.Arrays;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        final Controller aController = (Controller)this.getApplicationContext();
        String orderStr = getIntent().getStringExtra("orders");
        try {
            aController.setOrders(Arrays.asList(new ObjectMapper().readValue(orderStr, Order[].class)));
        } catch (Exception e){
            e.printStackTrace();
        }
        ListView listView = findViewById(R.id.orderlist);
        listView.setAdapter(new CustomOrderArrayAdapter(this,aController.getOrders()));
    }
}
