package com.example.user_management;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;



public class DBHelper extends SQLiteOpenHelper  {
    public static final String DATABASE_NAME = "studentRegistration.db";
    public static final String student = "student";
    public static final String fullname = "fullname";
    public static final String username = "username";
    public static final String email = "email";
    public static final String password = "password";
    public static final String phone = "phone";
    public static final String gender = "gender";
    private HashMap hp;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table student" + "(fullname txt, username txt primary key,email txt,password txt,phone int,gender txt)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS student");
        onCreate(db);
    }

    public boolean insertStudent(String fullname,String username,String email,String password,int phone, String gender){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("fullname",fullname);
        contentValues.put("username",username);
        contentValues.put("email",email);
        contentValues.put("password",password);
        contentValues.put("phone",phone);
        contentValues.put("gender",gender);

        db.insert("student",null,contentValues);

        System.out.println("  Student Registered SuccessFully");

        return true;
    }
    public ArrayList<String> getAllStudents(){
        ArrayList<String>array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select *from student",null);
        res.moveToFirst();

        while (res.isAfterLast()==false){
            array_list.add(res.getString(res.getColumnIndex(fullname)));

            res.moveToNext();
        }
        return array_list;
    }

    public Cursor getData(String username,String password){

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from student where username='"+username+"'and password='"+password+"'",null);

        return res;
    }

    public void deleteAll(String username){
        try {

            SQLiteDatabase db = this.getReadableDatabase();
            db.execSQL("delete from student where username != '" + username + "'");
            db.close();
            System.out.println("successfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("ERROR deleted");
        }


    }



}





