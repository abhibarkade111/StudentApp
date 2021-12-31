package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demoapp.Adapter.studentAdapter;

import java.util.ArrayList;
import java.util.List;

public class viewStudents extends AppCompatActivity {

    Button showButton;
    ListView listView;
    Adapter adapter;
    public static List<Registrations> studentReg = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_students);
        listView = findViewById(R.id.listview);

        showButton=findViewById(R.id.buttonShow);
        SharedPreferences pref = getSharedPreferences("studentD",MODE_PRIVATE);
        String name1 = pref.getString("name","");
        String email1= pref.getString("email","");
        String branch1 = pref.getString("branch","");
        String mob1 = pref.getString("mob","");
        String stuclass = pref.getString("stuclass","");

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(viewStudents.this, "Name = "+name1+"\nEmail = "+email1+"\nBranch = "+branch1+"\nmob = "+mob1+"\nCalss = "+stuclass, Toast.LENGTH_SHORT).show();
            }
        });

        DBHelper dbHelper = new DBHelper(viewStudents.this,"Student", null, 1);
       ArrayList listnew =  dbHelper.fetchData();


        adapter = new studentAdapter(viewStudents.this,listnew);
        listView.setAdapter((ListAdapter) adapter);
    }


}