package com.example.hotel;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import android.util.Log;

import org.w3c.dom.Text;

import static org.xmlpull.v1.XmlPullParser.TEXT;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME="hotel";

    public static final String TABLE_NAME="customer";
    public static final String COL = "cus_no";
    public static final String COL_1="FirstName";
    public static final String COL_2="LastName";
    public static final String COL_3="contact";
    public static final String COL_4="id";
    public static final String COL_5="Address";
    public static final String COL_6="UserName";
    public static final String COL_7="Password";

    public static final String TABLE_NAME1="room";
    public static final String coloum1="roomID";
    public static final String coloum2="Bedcount";
    public static final String  coloum3="price";
    public static final String  coloum4="availability";
    public static final String  coloum5="offers";


    public static final String TABLE_NAME2="foods";
    public static final String COL1= "Name";
    public static final String COL2="Price";
    public static final String COL3="time";

    public static final String TABLE_NAME3="employee";
    public static final String coloumm1="empID";
    public static final String coloumm2="Name";
    public static final String coloumm3="contact";

    public static final String TABLE_NAME4="roomhire";

    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" +COL+"INTEGER,"+ COL_1 + " TEXT," +
    COL_2 +" TEXT," + COL_3 +" TEXT,"+ COL_4 +" TEXT,"+ COL_5 +" TEXT,"+ COL_6 +" TEXT,"+ COL_7 +" TEXT);";

    private static final String CREATE_TABLE1 = "create table " + TABLE_NAME1 + "(" + coloum1 + " TEXT," + coloum2 +" TEXT," +
            coloum3 +" TEXT,"+ coloum4 +" TEXT,"+ COL_5 +" TEXT);";

    private static final String CREATE_TABLE2 = "create table " + TABLE_NAME2 + "(" + COL1 + " TEXT," + COL2 +" TEXT," +
            COL3 +" TEXT);";

    private static final String CREATE_TABLE3 = "create table " + TABLE_NAME3 + "(" + coloumm1 + " TEXT," + coloumm2 +" TEXT," +
            coloumm3 +" TEXT);";

    public DatabaseHelper (@Nullable Context context){
        super (context, DATABASE_NAME,null,1);
        Log.e("first","opendatabase");

    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("Test2","oncreate table");
        db.execSQL(CREATE_TABLE);
        db.execSQL("CREATE TABLE "
                + TABLE_NAME
                + "(empNo INTEGER PRIMARY KEY AUTOINCREMENT,  FirstName VARCHAR(50), LastName VARCHAR(50), " +
                "Contact VARCHAR(50), Email VARCHAR, Address VARCHAR, UserName VARCHAR, Password VARCHAR)");

        db.execSQL(CREATE_TABLE1);
        db.execSQL("CREATE TABLE " + TABLE_NAME1
                + "(roomID VARCHAR(50) PRIMARY KEY, bedcount VARCHAR(50), " +
               "price VARCHAR(10),availability VARCHAR(10),ofers VARCHAR(10))");

        db.execSQL(CREATE_TABLE2);
        db.execSQL(CREATE_TABLE3);

        db.execSQL("CREATE TABLE "
                + TABLE_NAME4
                + "(bookingNo INTEGER PRIMARY KEY AUTOINCREMENT,  roomID VARCHAR(50), cus_no VARCHAR(50), " +
"DateOut VARCHAR(50), DateDue VARCHAR(50), DateReturned VARCHAR(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME4);
        onCreate(db);
    }

    public Cursor searchUsers(String text){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from "+TABLE_NAME1+" WHERE "+coloum2+ "OR"+coloum4+" Like '@"+text+"@'";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }

    //public Cursor viewData(){
        //SQLiteDatabase db = this.getReadableDatabase();
        //String query = "Select * from "+TABLE_NAME1;

       // Cursor cursor = db.rawQuery(query, null);
       // return cursor;
   // }
    //search from query
    public Cursor search (String text){
       SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from "+TABLE_NAME1+" WHERE "+coloum2+ "OR"+coloum4+" Like '@"+text+"@'";
        Cursor cursor;
        cursor = db.rawQuery(query, null);
        return  cursor;
    }


    public Cursor viewData() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME1;  // Use uppercase for SQL keywords

        Cursor cursor = db.rawQuery(query, null);

        // Check if cursor is null (query might not return data)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                // Cursor has data, return it
                return cursor;
            } else {
                // Cursor is empty (no data found)
                //  Close the cursor to avoid resource leaks
                cursor.close();
                return null; // Indicate no data found
            }
        } else {
            // Handle error scenario where cursor could not be created
            //  e.g., log an error message
            return null;
        }
    }
public Cursor viewemp() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME3;  // Use uppercase for SQL keywords

        Cursor cursor = db.rawQuery(query, null);

        // Check if cursor is null (query might not return data)
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                // Cursor has data, return it
                return cursor;
            } else {
                // Cursor is empty (no data found)
                //  Close the cursor to avoid resource leaks
                cursor.close();
                return null; // Indicate no data found
            }
        } else {
            // Handle error scenario where cursor could not be created
            //  e.g., log an error message
            return null;
        }
    }

}



