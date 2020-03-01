package com.example.user_management;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends Activity {
    int from_Whare_I_Am_Coming=0;

    private DBHelper mydb;

    TextView fullname;
    TextView email;
    TextView username;
    TextView password;
    TextView phone;
    TextView gender;
    Button btn;
    int id_To_Update;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        fullname = (TextView) findViewById(R.id.fullname);
        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.password);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.phone);
        gender = (TextView) findViewById(R.id.gender);
        btn = (Button) findViewById(R.id.register);

        mydb = new DBHelper(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mydb.insertStudent(fullname.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString(), Integer.parseInt(phone.getText().toString()), gender.getText().toString());
                Toast.makeText( getApplicationContext(),"success full", Toast.LENGTH_SHORT).show();
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent login = new Intent(getApplicationContext(), MainActivity.class);
        login.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(login);
    }
         }




