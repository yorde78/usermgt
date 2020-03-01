package com.example.user_management;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class User_Page extends AppCompatActivity {
    TextView fullname;
    String fname;
    String email;
    String phone;
    String gender;
    String username;
    Button about;
    Button longPress;
    Button logout;


    Button listAll;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__page);
        fullname = (TextView) findViewById(R.id.name2);
        fullname.setText(getIntent().getExtras().get("full_name").toString());

        fname = getIntent().getExtras().get("full_name").toString();
        email = getIntent().getExtras().get("email").toString();
        phone = getIntent().getExtras().get("phone").toString();
        gender = getIntent().getExtras().get("gender").toString();
        username = getIntent().getExtras().get("username").toString();

        about = (Button)findViewById(R.id.about);
        longPress = (Button)findViewById(R.id.longPress);
        logout = (Button)findViewById(R.id.logout);
        listAll = (Button)findViewById(R.id.ListAll);

        mydb = new DBHelper(this);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("User Information", "Full Name : "+fname+
                        " Email :"+ email+
                        " Phone No : "+phone+
                        " Gender : "+gender);
            }
        });

        longPress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage("DELETE all users ").setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mydb.deleteAll(username);
                            Toast.makeText(getApplicationContext(), "DELETE SUCCESSFULLY", Toast.LENGTH_SHORT);
                        }
                    }).setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    AlertDialog d = builder.create();
                    d.setTitle("Are You Sure");
                    d.show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "ERROR DELETE ", Toast.LENGTH_SHORT);
                }

                return true;
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(login);
            }
        });
        listAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent recycle = new Intent(this,recycler_view.class);
        startActivity(recycle);

    }
    public void showMessage(String title,String message){
        AlertDialog.Builder bulder = new AlertDialog.Builder(this);
        bulder.setCancelable(true);
        bulder.setTitle(title);
        bulder.setMessage(message);
        bulder.show();
    }
}
