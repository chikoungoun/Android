package com.example.cursor_db.data;

import android.provider.BaseColumns;

// Defining the constants for the

public final class StudentContract {

    public StudentContract() {
    }

    public class StudentEntry implements BaseColumns{

        // Table name
        public static final String TABLE_NAME = "students";

        // Table column names (create a unique ID)
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_STUDENT_FIRSTNAME = "First_name";
        public static final String COLUMN_STUDENT_LASTNAME = "Last_name";
        public static final String COLUMN_STUDENT_AGE = "Age";


    }
}
