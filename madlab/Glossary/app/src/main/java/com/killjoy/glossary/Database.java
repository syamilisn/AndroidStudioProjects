package com.killjoy.glossary;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {

    static final private String DB_NAME = "turret";
    static final private String DB_TABLE = "gloss";
    static final private int DB_VER = 1;

    Context ctx;
    SQLiteDatabase myDb;

    public Database(Context ct){
        super(ct,DB_NAME,null,DB_VER);
        ctx=ct;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table "+DB_TABLE+" (_id integer primary key autoincrement, word text, meaning text);");
        Log.i("Database", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+DB_TABLE);
        onCreate(db);
    }

    public void insertData(String s1, String s2){
        myDb =  getWritableDatabase();
        myDb.execSQL("insert into "+DB_TABLE+" (word, meaning) values('"+s1+"','"+s2+"');");
        //Toast.makeText(ctx,"Word added successfully", Toast.LENGTH_SHORT).show();

    }
    //getting data:
    public void getAll(){
        //params: int i, int value
        myDb=getReadableDatabase();
        //myDb.rawQuery("Select * from "+DB_NAME +" where _id= ?",value);
        //or
        //myDb.rawQuery("Select * from "+DB_NAME +" where _id= "+value+"",null);
        Cursor cr = myDb.rawQuery("Select * from "+DB_TABLE,null);
        StringBuilder str = new StringBuilder();

        while (cr.moveToNext()){
            String s1 = cr.getString(1);
            String s2 = cr.getString(2);
            str.append(s1+"          "+s2+"\n");
        }
        Toast.makeText(ctx,str.toString(), Toast.LENGTH_LONG).show();
    }
    /*
    public String getMeaning(String s1){
        myDb = getReadableDatabase();
        Cursor cr = myDb.rawQuery("Select meaning from "+DB_TABLE+" where name="+s1+"", null);
        return cr.getString(2);
    }
    */
    public String getMeaning(String s1){
        myDb = getReadableDatabase();
        //Cursor cr = myDb.rawQuery("SELECT word, meaning FROM "+DB_TABLE+" WHERE word = ? AND id = ?", new String[] {"apple", "2"});
        //Cursor cr = myDb.rawQuery("SELECT meaning FROM "+DB_TABLE+" WHERE word = ? ", new String[] {s1});
        Cursor cr = myDb.rawQuery("SELECT * FROM "+DB_TABLE+" WHERE word = ? ", new String[] {s1});
        StringBuilder str = new StringBuilder();
        //String s0 , s2 ;
        String wordMeaning;
        while(cr.moveToNext()){
             wordMeaning = cr.getString(2);
            str.append(""+wordMeaning+"\n");
        }
        /*
        while (cr.moveToNext()){
            s0 = cr.getString(1);
            s2 = cr.getString(2);
            str.append(s0+"          "+s2+"\n");
        }

         */
        //Toast.makeText(ctx,str.toString(), Toast.LENGTH_LONG).show();
        return String.valueOf(str);

    }


}
