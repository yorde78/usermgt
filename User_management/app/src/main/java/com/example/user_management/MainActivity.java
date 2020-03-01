package com.example.user_management;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    TextView user;
    TextView pass;
    private DBHelper mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getApplicationContext(), Register.class);
                registerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(registerIntent);
            }
        });
        user=(TextView)findViewById(R.id.username11);
        pass = (TextView)findViewById(R.id.password11);
        mydb = new DBHelper(this);
        btn2=(Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(getApplicationContext(), Register.class);
                registerIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(registerIntent);
            }
        });
        user=(TextView)findViewById(R.id.username11);
        pass = (TextView)findViewById(R.id.password11);
        mydb = new DBHelper(this);
        btn2=(Button)findViewById(R.id.button);

        btn2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.Q)
            @Override
            public void onClick(View v) {

                try {

                    StringBuffer buffer = new StringBuffer();
                    StringBuffer buffer1 = new StringBuffer();
                    StringBuffer buffer2 = new StringBuffer();
                    StringBuffer buffer3 = new StringBuffer();
                    StringBuffer buffer4 = new StringBuffer();
                    StringBuffer buffer5 = new StringBuffer();

                    Cursor rs = mydb.getData(user.getText().toString(), pass.getText().toString());

                    while (rs.moveToNext()) {
                        buffer.append(rs.getString(0));
                        buffer1.append(rs.getString(1));
                        buffer2.append(rs.getString(2));
                        buffer5.append(rs.getString(3));
                        buffer3.append(rs.getString(4));
                        buffer4.append(rs.getString(5));
                    }

                    if (user.getText().toString().contentEquals("") && pass.getText().toString().contentEquals("")) {
                        showMessage("ERROR", "Please input username and password");

                    } else {
                        if (user.getText().toString().contentEquals(buffer1) || pass.getText().toString().contentEquals(buffer5)) {




                            Intent userpage = new Intent(getApplicationContext(), User_Page.class);
                            userpage.setFlags(getIntent().getFlags());
                            userpage.putExtra("username", user.getText().toString());
                            userpage.putExtra("full_name", buffer.toString());
                            userpage.putExtra("email", buffer2.toString());
                            userpage.putExtra("phone", buffer3.toString());
                            userpage.putExtra("gender", buffer4.toString());
                            startActivity(userpage);
                        }
                        else{
                            showMessage("ERROR", "Please register If you don't have Account");
                        }
                    }



                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText( getApplicationContext(),"error ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void showMessage(String title,String message){
        AlertDialog.Builder bulder = new AlertDialog.Builder(this);
        bulder.setCancelable(true);
        bulder.setTitle(title);
        bulder.setMessage(message);
        bulder.show();
    }
}
