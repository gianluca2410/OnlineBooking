package com.example.sharif.onlinebooking;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SHARIF on 8/15/2018.
 */

 public class Database extends SQLiteOpenHelper {
    public static final String DBName = "Books_Data";
    public static final String TName = "Books";
    public static final String Col_1 = "B_name";
    public static final String Col_2 = "A_name";
    public static final String Col_3 = "B_page";
    public static final String Col_4 = "B_words";
    public static final String Col_5 = "B_price";
    public static final String Col_6 = "B_edition";
    public static final String Col_7 = "B_code";

    public Database(Context context) {
        super(context, DBName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TName + "(" + Col_1 + " TEXT," + Col_2 + " TEXT," + Col_3 + " TEXT," + Col_4 + " TEXT,"
                + Col_5 + " TEXT," + Col_6 + " TEXT," + Col_7 + " TEXT PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TName);
        onCreate(db);
    }
// function to add data into database
    public void Add(Book book){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_1,book.getB_name());
        cv.put(Col_2,book.getA_name());
        cv.put(Col_3,book.getB_page());
        cv.put(Col_4,book.getB_words());
        cv.put(Col_5,book.getB_price());
        cv.put(Col_6,book.getB_edition());
        cv.put(Col_7,book.getB_code());
      db.insert(TName,null,cv);
      db.close();
    }
    // function to update the data in the database
    public void Update(String Code, String P,String edition,String page,String words){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Col_3,page);
        cv.put(Col_4,words);
        cv.put(Col_5,P);
        cv.put(Col_6,edition);
        db.update(TName,cv,"B_code=?",new String[]{Code});
    }
    // function to delete data
    public int Del(String a){
        SQLiteDatabase db=this.getReadableDatabase();
      int b=  db.delete(TName,"B_code=?",new String[]{a});
      return b;
    }
// function to get data from database
    public ArrayList<Book> getData(){
        List<Book> dataList=new ArrayList<Book>();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.query(TName, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String a=cursor.getString(0);
            String b=cursor.getString(1);
            String c=cursor.getString(2);
            String d=cursor.getString(3);
            String e=cursor.getString(4);
            String f=cursor.getString(5);
            String g=cursor.getString(6);
            Book ca=new Book(a,b,c,d,e,f,g);
            dataList.add(ca);
            cursor.moveToNext();
        }
        return (ArrayList<Book>) dataList;
    }
}
