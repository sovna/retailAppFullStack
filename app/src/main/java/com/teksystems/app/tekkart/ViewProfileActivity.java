package com.teksystems.app.tekkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class ViewProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
    }

    public void fetchDeliveryAddress(View v) {
        RelativeLayout address = (RelativeLayout) v;
        Intent intent = new Intent(this, DeliveryAddressActivity.class);
        EditText editText = (EditText) findViewById(R.id.username);
        startActivity(intent);
    }

}
