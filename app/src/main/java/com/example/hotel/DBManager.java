package com.example.hotel;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

    private DatabaseHelper dbHelper;
    private SQLiteDatabase database;
    private Context context;

    public DBManager(Context context) {
        this.context = context;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }


    public void close() {
        dbHelper.close();
    }

    public void insert(String query) {
        try {
            database.execSQL(query);
        } catch (Exception e) {
            System.out.println("ExecuteQuery error : " + e);
        }
    }
    public void update(String query) {
        try {
            database.execSQL(query);
        } catch (Exception e) {
            System.out.println("ExecuteQuery error : " + e);
        }
    }


    public Cursor Select(String query) {
        Cursor cursor;
        cursor = database.rawQuery(query, null);
        return cursor;
    }

    public void execSQL(String updateQuery, String[] strings) {
    }
}
