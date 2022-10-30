package com.feedbackapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper( Context context) {
        super(context, "DBNAME.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table feedback(ID INT primary key autoincrement,Rating int,Feedback text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP table if exists feedback");
        onCreate(sqLiteDatabase);
    }

    public boolean insertFeedback(String Feedback){
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("Feedback",Feedback);
        long ID = database.insert("feedback",null, values);
        if (ID <= 0){
            return false;
        }else{
            return true;
        }
    }
}
