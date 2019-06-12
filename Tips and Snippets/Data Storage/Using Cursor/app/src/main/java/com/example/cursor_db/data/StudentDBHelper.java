package com.example.cursor_db.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cursor_db.data.StudentContract.StudentEntry;


// Creating a database and managing the version


public class StudentDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "school";

    public static final int DATABASE_VERSION = 1;

    public StudentDBHelper(Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating the database table
        String SQL_CREATE_TABLE = "CREATE TABLE "+StudentEntry.TABLE_NAME+"("
                +StudentEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +StudentEntry.COLUMN_STUDENT_FIRSTNAME+" TEXT, "
                +StudentEntry.COLUMN_STUDENT_LASTNAME+" TEXT NOT NULL, "
                +StudentEntry.COLUMN_STUDENT_AGE+" INTEGER);";

        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
