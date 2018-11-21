package com.example.shusmoy.arong_salesman;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Shusmoy on 2/22/2017.
 */

public class database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "adv_data.db";
    // TOGGLE THIS NUMBER FOR UPDATING TABLES AND DATABASE
    private static final int DATABASE_VERSION = 1;
    database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// CREATE Price TABLE
        db.execSQL("CREATE TABLE " + "Price"
                        + " (" + "Serial_no" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "Item" + " String,"
                        + "Type" + " String,"
                        + "Price" + " INTEGER);");
        System.out.println("done");
// CREATE COURSES TABLE


    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        Log.w("LOG_TAG", "Upgrading database from version "
                        + oldVersion + " to " + newVersion + ",");
// KILL PREVIOUS TABLES IF UPGRADED
                db.execSQL("DROP TABLE IF EXISTS " + "Price");
        //db.execSQL("DROP TABLE IF EXISTS " + "Order");
// CREATE NEW INSTANCE OF SCHEMA
        onCreate(db);
    }

    // WRAPPER METHOD FOR ADDING A STUDENT
    public long addprice(SQLiteDatabase sd,String item, String type, int price) {
// CREATE A CONTENTVALUE OBJECT
        ContentValues cv = new ContentValues();
        cv.put("Item", item);
        cv.put("Type", type);
        cv.put("Price", price);
// RETRIEVE WRITEABLE DATABASE AND INSERT
        //SQLiteDatabase sd = getWritableDatabase();
        System.out.println(item+"  "+cv.getAsString("Type")+"  "+price);
        long result = sd.insert("Price","",cv);
       //sd.insert("Price","Item",cv);
        System.out.println(result);
        return result;
    }
    public long addorder(String item, String type, int price) {
// CREATE A CONTENTVALUE OBJECT
        ContentValues cv = new ContentValues();
        cv.put("Order", item);
        cv.put("Order", type);
        cv.put("Order", price);
// RETRIEVE WRITEABLE DATABASE AND INSERT
        SQLiteDatabase sd = getWritableDatabase();
        long result = sd.insert("Order","Item",cv);
        return result;
    }
    public void deletep()
    {

    }


}