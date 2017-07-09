package com.example.android.puppywalktracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.puppywalktracker.data.PuppyWalkContract.PuppyWalkEntry;

/**
 * Created by georgeampartzidis on 6/7/17.
 */

public class PuppyWalkDbHelper extends SQLiteOpenHelper {
    // In case there is a change in the database schema,
    // increment the database
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "puppywalk.db";

    public PuppyWalkDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        createTable(db);
    }

    public void onUpgrade(SQLiteDatabase db, int OldVersion, int NewVersion) {
        // This database is only a cache for online data, so its upgrade policy
        // is simply to discard the data and start over
        String SQL_DROP_ENTRIES =
                "DROP TABLE IF EXISTS " + PuppyWalkEntry.TABLE_NAME;
        db.execSQL(SQL_DROP_ENTRIES);
        createTable(db);
    }

    private void createTable(SQLiteDatabase db) {
        String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + PuppyWalkEntry.TABLE_NAME + "(" +
                        PuppyWalkEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        PuppyWalkEntry.COLUMN_PET_NAME + " TEXT," +
                        PuppyWalkEntry.COLUMN_PET_DATE + " DATE," +
                        PuppyWalkEntry.COLUMN_PET_DURATION + " INTEGER NOT NULL," +
                        PuppyWalkEntry.COLUMN_PET_TRAINING + " INTEGER NOT NULL)";
        db.execSQL(SQL_CREATE_ENTRIES);
    }
}
