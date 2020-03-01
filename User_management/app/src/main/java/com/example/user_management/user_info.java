package com.example.user_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import android.content.Intent;
public class user_info extends AppCompatActivity {
    TextView fullname;
    TextView email;
    TextView phone;
    TextView gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        fullname = (TextView) findViewById(R.id.full_name2);
        email = (TextView)findViewById(R.id.email2);
        phone = (TextView)findViewById(R.id.mobile2);
        gender = (TextView)findViewById(R.id.gender2);


        fullname.setText(getIntent().getExtras().get("full_name2").toString());
        email.setText(getIntent().getExtras().get("email2").toString());
        phone.setText(getIntent().getExtras().get("phone2").toString());
        gender.setText(getIntent().getExtras().get("gender2").toString());
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        openNewActivity();
    }

    public void openNewActivity() {
        Intent intent = new Intent(this, User_Page.class);
        startActivity(intent);
    }
}



