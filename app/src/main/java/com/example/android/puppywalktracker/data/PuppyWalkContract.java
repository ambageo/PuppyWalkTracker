package com.example.android.puppywalktracker.data;

import android.provider.BaseColumns;


/**
 * Created by georgeampartzidis on 6/7/17.
 * This class defines the schema for the table which will be used to store the data
 */

public final class PuppyWalkContract {

    private PuppyWalkContract() {
        //Intentionally left empty to prevent this class from being instantiated
    }

    public static abstract class PuppyWalkEntry implements BaseColumns {
        //Names of the table and columns
        public static final String TABLE_NAME = "puppywalk";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME = "name";
        public static final String COLUMN_PET_DATE = "date";
        public static final String COLUMN_PET_DURATION = "duration";
        public static final String COLUMN_PET_TRAINING= "training";

        //Possible values for training
        public static final int TRAINING_NO = 0;
        public static final int TRAINING_YES = 1;

    }
}
