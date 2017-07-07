package com.example.android.puppywalktracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.android.puppywalktracker.data.PuppyWalkContract;
import com.example.android.puppywalktracker.data.PuppyWalkDbHelper;
import com.example.android.puppywalktracker.data.PuppyWalkContract.PuppyWalkEntry;

public class MainActivity extends AppCompatActivity {
    // Create database helper
    PuppyWalkDbHelper mDbHelper = new PuppyWalkDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Check that a new row is inserted properly by printing it on the Logcat.
        insertPuppyWalk();
        Cursor cursor= readDatabaseInfo();
        DatabaseUtils.dumpCursor(cursor);
    }

    private void insertPuppyWalk() {


        //Get the database in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //Create a ContentValues object where column names are the keys,
        // and attributes are the values.
        ContentValues values = new ContentValues();
        values.put(PuppyWalkEntry.COLUMN_PET_NAME, "Aris");
        values.put(PuppyWalkEntry.COLUMN_PET_DATE, "2017-07-05");
        values.put(PuppyWalkEntry.COLUMN_PET_DURATION, 30);
        values.put(PuppyWalkEntry.COLUMN_PET_TRAINING, PuppyWalkEntry.TRAINING_YES);

        long newRowId = db.insert(PuppyWalkEntry.TABLE_NAME, null, values);
        Log.v("MainActivity", "Row added with id: " + newRowId);
    }

    private Cursor readDatabaseInfo() {

        //Create and/or open a database to read data from it
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = {
                PuppyWalkEntry._ID,
                PuppyWalkEntry.COLUMN_PET_NAME,
                PuppyWalkEntry.COLUMN_PET_DATE,
                PuppyWalkEntry.COLUMN_PET_DURATION,
                PuppyWalkEntry.COLUMN_PET_TRAINING
        };

        Cursor cursor = db.query(
                PuppyWalkEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );

        return cursor;
    }

}
