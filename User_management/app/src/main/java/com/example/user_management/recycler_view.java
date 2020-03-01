package com.example.user_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public class recycler_view extends AppCompatActivity {
    private RecyclerView recyclerView;
    DBHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = (RecyclerView)findViewById(R.id.recycleView2);
        mydb = new DBHelper(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);


        List<Model> modelList = new ArrayList<>();
        ;
        SQLiteDatabase db = mydb.getReadableDatabase();
        Cursor res = db.rawQuery("select *from student",null);

        StringBuffer buffer = new StringBuffer();
        StringBuffer buffer1 = new StringBuffer();
        StringBuffer buffer2 = new StringBuffer();
        StringBuffer buffer3 = new StringBuffer();
        StringBuffer buffer4 = new StringBuffer();
        StringBuffer buffer5 = new StringBuffer();


        while (res.moveToNext()) {

            buffer.append(res.getString(0));
            buffer1.append(res.getString(1));
            modelList.add(new Model(res.getString(0),res.getString(2),res.getString(4),res.getString(5)));
        }
        res.close();


        MyAddapter adapter = new MyAddapter(modelList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
