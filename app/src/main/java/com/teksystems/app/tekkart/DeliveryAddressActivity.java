package com.teksystems.app.tekkart;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.teksystems.app.model.Customer;

public class DeliveryAddressActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_address);
        final Controller aController = (Controller) DeliveryAddressActivity.this.getApplicationContext();
        Customer customer = aController.getCustomer();
        TextView address = (TextView) findViewById(R.id.address_text);
        address.setText(aController.getUserId() != null ?customer.getCustomerAddress():"SignUp to have doorstep deliveries");
    }


}
