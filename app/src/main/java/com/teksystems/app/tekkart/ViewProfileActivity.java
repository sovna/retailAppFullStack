package com.teksystems.app.tekkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.teksystems.app.model.Customer;
import com.teksystems.app.service.CustomerService;
import com.teksystems.app.service.OrderService;
import com.teksystems.app.service.WishListService;

public class ViewProfileActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        final Controller aController = (Controller) ViewProfileActivity.this.getApplicationContext();
        String userId = aController.getUserId();
        Customer customer = aController.getCustomer();
        TextView usertv = (TextView) findViewById(R.id.user_profile_name);
        TextView userbio = (TextView) findViewById(R.id.user_profile_short_bio);
        TextView logInOut = (TextView) findViewById(R.id.login_logout);
        usertv.setText(userId != null ?customer.getCustomerName():"Guest");
        if(!usertv.getText().toString().equalsIgnoreCase("Guest")) {
            userbio.setText(customer.getCustomerContact());
            logInOut.setText("Logout");
            logInOut.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    aController.setCustomer(null);
                    aController.setUserId(null);
                    aController.setProductCarts(null);
                    Intent i = getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(i);
                }
            });
        } else {
            userbio.setText("Please login with your account");
            logInOut.setText("Login");
            logInOut.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(ViewProfileActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            });
        }

    }

    public void fetchOrders(View v) {
        RelativeLayout orders = (RelativeLayout) v;
        final Controller aController = (Controller) this.getApplicationContext();
        new OrderService().fetchOrders(this,aController.getUserId());
    }

    public void fetchWishList(View v) {
        RelativeLayout orders = (RelativeLayout) v;
        final Controller aController = (Controller) ViewProfileActivity.this.getApplicationContext();
        new WishListService().getWishList(this,aController.getUserId());
    }

    public void fetchDeliveryAddress(View v) {
        RelativeLayout address = (RelativeLayout) v;
        Intent intent = new Intent(this, DeliveryAddressActivity.class);
        EditText editText = (EditText) findViewById(R.id.username);
        startActivity(intent);
    }

}
