package com.teksystems.app.tekkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teksystems.app.model.Customer;
import com.teksystems.app.service.RegisterService;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void buttonOnClick(View v) {
        Button login = (Button) v;
        Customer customer = new Customer();
        customer.setUsername(((EditText)findViewById(R.id.username)).getText().toString());
        EditText pass = (EditText) findViewById(R.id.password);
        customer.setCustomerName(((EditText)findViewById(R.id.name)).getText().toString());
        customer.setCustomerContact(((EditText)findViewById(R.id.phonenumber)).getText().toString());
       customer.setCustomerAddress(((EditText)findViewById(R.id.address)).getText().toString());
        new RegisterService().addCustomers(RegisterActivity.this,customer,pass.getText().toString());
    }

    public void buttonOnClickGuest(View v) {
        Button login = (Button) v;

        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
