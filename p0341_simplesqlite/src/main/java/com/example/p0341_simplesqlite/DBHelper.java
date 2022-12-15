package com.example.p0341_simplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table myTable (id integer primary key autoincrement, name text, email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addToMyDB(Data data){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", data.getName());
        contentValues.put("email", data.getEmail());
        db.insert("myTable", null, contentValues);
        db.close();
    }

    public void clearMyDB(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("myTable", null, null);
        db.close();
    }

    public ArrayList<Data> readMyDB(){

        ArrayList<Data> list = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query("myTable", null, null, null, null, null, null);
        if(cursor.moveToFirst()){
            int idIndex = cursor.getColumnIndex("id");
            int nameIndex = cursor.getColumnIndex("name");
            int emailIndex = cursor.getColumnIndex("email");

            do{
                int id = cursor.getInt(idIndex);
                String name = cursor.getString(nameIndex);
                String email = cursor.getString(emailIndex);
                Data data = new Data(name, email, id);
                list.add(data);
            }while(cursor.moveToNext());
        }
        db.close();
        return list;
    }
}
