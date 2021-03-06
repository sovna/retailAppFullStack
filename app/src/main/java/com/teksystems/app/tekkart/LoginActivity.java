package com.teksystems.app.tekkart;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.github.aakira.expandablelayout.ExpandableRelativeLayout;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.teksystems.app.service.CustomerService;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class LoginActivity extends AppCompatActivity {
    RadioGroup group;
    RadioButton login;
    ExpandableRelativeLayout form, form2;
    EditText userName,email, password, fullName, confirmPassword, phoneNumber;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        group =findViewById(R.id.radiogroup);
        form  =findViewById(R.id.loginForm);
        form2 =findViewById(R.id.registerForm);
        form2.collapse();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton button1 = (RadioButton) findViewById(R.id.Login);
                RadioButton button2 = findViewById(R.id.Register);

                if (i==R.id.Login) {
                    form.expand();
                    form2.collapse();
                    button2.setBackgroundResource(R.drawable.signup_bg);
                    button1.setBackgroundResource(R.drawable.checked_bg);

                }else {
                    form2.expand();
                    form.collapse();
                    button1.setBackgroundResource(R.drawable.signup_bg);
                    button2.setBackgroundResource(R.drawable.checked_bg);

                }


            }
        });
    }

    public void buttonOnClick(View v) {
        Button login = (Button) v;
        final EditText username = (EditText) findViewById(R.id.username);
        EditText pwd = (EditText) findViewById(R.id.password);
        StringEntity jsonEntity = null;
        AsyncHttpClient client = new AsyncHttpClient();
        Header header;
        client.addHeader("Accept", "application/json");

        client.addHeader("Content-Type", "application/json");

        client.addHeader("api-key","xxTEKyy");
        JSONObject jsonParams = new JSONObject();
        try {
            jsonParams.put("username", username.getText().toString());
            jsonParams.put("pwd",pwd.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            jsonEntity = new StringEntity(jsonParams.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        final Context context = getApplicationContext();
        client.post(context, "http://ec2-52-14-221-80.us-east-2.compute.amazonaws.com:8080/TekShopping/TekShop/logIn", jsonEntity, "application/json", new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                System.out.println("success");


                String message = username.getText().toString();
                try {
                    final Controller aController = (Controller) LoginActivity.this.getApplicationContext();
                    aController.setUserId(response.get("User ID").toString());
                    if(aController.getUserId() != null && aController.getCustomer().getUserId() == null) {
                        new CustomerService().getCustomers(LoginActivity.this, aController.getUserId());
                    }

                }catch (JSONException e){
                    e.printStackTrace();
                }
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("username",message);
                startActivity(intent);


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                System.out.println("failure");
                Intent intent = new Intent(context, LoginActivity.class);
                CharSequence text = "Invalid user!";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, -0, 230);
                toast.show();
//                intent.putExtra(EXTRA_MESSAGE, text);
                startActivity(intent);
            }
        });


    }

    public void buttonOnClickRegister(View v) {
        Button login = (Button) v;
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
