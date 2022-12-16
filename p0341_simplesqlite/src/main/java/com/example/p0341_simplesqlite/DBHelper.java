package com.example.p0341_simplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final String LOG_TAG = "MyLog";

    public DBHelper(@Nullable Context context) {
        super(context, "myDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(LOG_TAG, "--- Create database ---");
        db.execSQL("create table myTable (id integer primary key autoincrement, name text, email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addToMyDB(Data data){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        Log.d(LOG_TAG, "--- Insert in mytable: ---");

        contentValues.put("name", data.getName());
        contentValues.put("email", data.getEmail());

        long rowID = db.insert("myTable", null, contentValues);
        Log.d(LOG_TAG, "row inserted, ID = " + rowID);

        db.close();
    }

    public void clearMyDB(){

        SQLiteDatabase db = this.getWritableDatabase();
        int clearCount = db.delete("myTable", null, null);
        Log.d(LOG_TAG, "--- Database is clear ---");
        Log.d(LOG_TAG, "--- Delete number rows: " + clearCount);
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
                Log.d(LOG_TAG, "ID = " + id + " name = " + name +" email = "+ email);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

    public void updateMyDB(String id, Data data){

        if(!id.equalsIgnoreCase("")) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", data.getName());
            contentValues.put("email", data.getEmail());
            db.update("myTable", contentValues, "id = ?", new String[] {id});
            db.close();
        }
    }

    public void deleteOneInMyDB(String id){

        if(!id.equalsIgnoreCase("")){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("MyTable", "id = " + id, null);
            db.close();
        }
    }
}
