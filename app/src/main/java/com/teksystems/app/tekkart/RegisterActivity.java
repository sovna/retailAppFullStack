package com.teksystems.app.tekkart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    public void buttonOnClick(View v) {
        Button login = (Button) v;

        Intent intent = new Intent(this, HomeActivity.class);
        EditText editText = (EditText) findViewById(R.id.username);
        startActivity(intent);
    }
}
