package com.monolite.contacts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JoséAugusto on 23/07/2016.
 */

public class DBAdapter extends SQLiteOpenHelper {

    public DBAdapter(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT, twitter TEXT)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
