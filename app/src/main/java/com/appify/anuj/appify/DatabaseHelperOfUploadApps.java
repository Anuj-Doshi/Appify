package com.appify.anuj.appify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelperOfUploadApps extends SQLiteOpenHelper {

    public static final String db_name="Appify.db";
    public static final String tb_name="verify_app";
    public static final String db_id="ID";
    public static final String db_appicon="App_Icon";
    public static final String db_appname="App_Name";
    public static final String db_devlopername="Devloper_Name";
    public static final String db_type="Type";
    public DatabaseHelperOfUploadApps(Context context) {
        super(context, db_name, null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+ tb_name +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,App_Icon blob ,App_Name TEXT,Devloper_Name TEXT,Type TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+tb_name);
        onCreate(db);
    }
    public boolean insertData(String appicon,String appname,String devlopername,String type)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(db_appicon,appicon);
        cv.put(db_appname,appname);
        cv.put(db_devlopername,devlopername);
        cv.put(db_type,type);
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
}
