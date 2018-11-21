package com.example.shusmoy.arong_salesman;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Shusmoy on 2/25/2017.
 */

public class dataorder extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "adv_data.db";
    // TOGGLE THIS NUMBER FOR UPDATING TABLES AND DATABASE
    private static final int DATABASE_VERSION = 1;
    dataorder(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// CREATE Price TABLE
        db.execSQL("CREATE TABLE " + "ArongOrder"
                + " (" + "Serial_no" + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "Item" + " String,"
                + "Type" + " String,"
                +"Amount"+ " INTEGER,"
                +"Price" + " INTEGER);");
// CREATE COURSES TABLE
        System.out.println("dne ");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        Log.w("LOG_TAG", "Upgrading database from version "
                + oldVersion + " to " + newVersion + ",");
// KILL PREVIOUS TABLES IF UPGRADED
        db.execSQL("DROP TABLE IF EXISTS " + "ArongOrder");
        //db.execSQL("DROP TABLE IF EXISTS " + "Order");
// CREATE NEW INSTANCE OF SCHEMA
        onCreate(db);
    }

    // WRAPPER METHOD FOR ADDING A STUDENT
    public long addorder(SQLiteDatabase sd,String item, String type,int amount, int price) {
// CREATE A CONTENTVALUE OBJECT
        ContentValues cv = new ContentValues();
        cv.put("Item", item);
        cv.put("Type", type);

        cv.put("Amount",amount);
        cv.put("Price", price);

// RETRIEVE WRITEABLE DATABASE AND INSERT
        //SQLiteDatabase sd = getWritableDatabase();
        System.out.println(item+"  "+cv.getAsString("Type")+"  "+price);
        long result = sd.insert("ArongOrder","",cv);
        //sd.insert("Price","Item",cv);
        System.out.println(result);
        return result;
    }


}