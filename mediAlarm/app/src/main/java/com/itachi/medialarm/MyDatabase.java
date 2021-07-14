package com.itachi.medialarm;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

import android.os.Bundle;

public class MyDatabase extends SQLiteOpenHelper {

    public static String DATABASE_NAME="medicine.db";
    public MyDatabase(@Nullable Context context, @Nullable String name, @Nullable
            SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE MEDICINE_NAMES (NAME TEXT,MDATE TEXT,MTIME TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
