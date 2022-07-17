package com.example.smartstegno.database;

import android.database.*;
import android.database.sqlite.*;
import android.content.*;
public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME="register.db";
    public static final String TABLE_NAME="registeruser";

    public DatabaseHelper(Context context)
    {
        super(context,DATABASE_NAME,null,1);
    }

    public void onCreate(SQLiteDatabase MyDb)
    {
        MyDb.execSQL("CREATE TABLE registeruser(username TEXT primary key ,password TEXT)");

    }
    public void onUpgrade(SQLiteDatabase MyDb,int i,int i1)
    {
        MyDb.execSQL("DROP TABLE IF EXISTS registerusers");
        onCreate(MyDb);

    }

    public boolean insertuser(String username, String password)
    {
        SQLiteDatabase MyDb=this.getWritableDatabase();
        ContentValues contentvalues=new ContentValues();
        contentvalues.put("username", username);
        contentvalues.put("password", password);
        long res=MyDb.insert("registeruser", null, contentvalues);
        if(res==-1)return false;
        else return true;
    }
    public boolean checkusername(String username)
    {
        SQLiteDatabase MyDb=this.getWritableDatabase();
        Cursor cursor=MyDb.rawQuery("Select * from registeruser where username=?",new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public boolean checkusernamepassword(String username,String password)
    {
        SQLiteDatabase MyDb=this.getWritableDatabase();
        Cursor cursor=MyDb.rawQuery("Select * from registeruser where username=? and password=?",new String[]{username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

}

