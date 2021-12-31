package com.example.demoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    ArrayList<String> arrayList=new ArrayList<String>();
    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "StudentClub", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE \"Student\" (\n" +
                "\t\"name\"\tTEXT,\n" +
                "\t\"email\"\tTEXT,\n" +
                "\t\"mob\"\tTEXT,\n" +
                "\t\"class\"\tTEXT,\n" +
                "\t\"branch\"\tTEXT,\n" +
                "\t\"id\"\tINTEGER NOT NULL UNIQUE,\n" +
                "\tPRIMARY KEY(\"id\" AUTOINCREMENT)\n" +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void registrationsNew(Registrations student){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("email",student.getEmail());
        values.put("mob",student.getMob());
        values.put("class",student.getStuclass());
        values.put("branch",student.getBranch());
        db.insert("Student",null,values);
        db.close();
    }


    public ArrayList<String> fetchData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from Student", null, null);
        while(cursor.moveToNext()){
//            Log.d("TAG","Data is Name:-"+cursor.getString(1));
            arrayList.add(cursor.getString(0));
        }

        return arrayList;


    }
}
