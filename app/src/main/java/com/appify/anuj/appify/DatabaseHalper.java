package com.appify.anuj.appify;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.support.annotation.Nullable;

public class DatabaseHalper extends SQLiteOpenHelper{
    public static final String db_name="Appify.db";
    public static final String tb_name="Registration";
    public static final String db_id="ID";
    public static final String db_fname="First_Name";
    public static final String db_lname="Last_Name";
    public static final String db_email="Email";
    public static final String db_password="Password";

    public DatabaseHalper(Context context) {
        super(context, db_name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ tb_name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,First_Name TEXT,Last_name TEXT,Email TEXT,Password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tb_name);
        onCreate(db);
    }
    public boolean insertData(String fname,String lname,String email,String password)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(db_fname,fname);
        cv.put(db_lname,lname);
        cv.put(db_email,email);
        cv.put(db_password,password);
        long result = db.insert(tb_name, null, cv);
        if(result==-1)
            return false;
        else
            return true;
    }
    public Cursor getData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+tb_name,null);
        return res;
    }

    /*public Cursor loginData(String email,String pass)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res= db.rawQuery("select * from "+tb_name +"where Email="+email+"and password="+pass,null);
        return res;
    }*/
    public boolean checkUser(String email, String password) {
        String[] columns = {
                db_id
        };
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = db_email + " = ?" + " AND " + db_password + " = ?";
        String[] selectionArgs = {email, password};
        Cursor cursor = db.query(tb_name,
                columns,
                selection,
                selectionArgs,
                null,
                null,
                null);

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return  false;
    }
    public Cursor viewData()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        String query="Select * FROM "+tb_name;
        Cursor cursor1 =db.rawQuery(query,null);
        return cursor1;
    }
    public Cursor productDetail(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " +tb_name + " where ID = " + Id,null);
        return res;
    }

}
