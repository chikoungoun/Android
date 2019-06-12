package com.example.cursor_db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cursor_db.data.StudentContract.StudentEntry;
import com.example.cursor_db.data.StudentDBHelper;

public class MainActivity extends AppCompatActivity {

    //Instanciate SQLiteHelper
    private StudentDBHelper mDbHelper;

    // Defining the textview result name
    private TextView mText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDbHelper = new StudentDBHelper(this);

        // Adding dummy data on the click of a button
        Button bDummies = (Button)findViewById(R.id.button_dummy);
        bDummies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDummy();
            }
        });

        // Displaying the database
        DisplayDatabase();

    }

    // Inserting dummy data into a database
    public void insertDummy(){

        // Adding a data into the database
        SQLiteDatabase db = mDbHelper.getWritableDatabase();// Writable : Create, Update, Delete operations
        ContentValues values = new ContentValues();

        values.put(StudentEntry.COLUMN_STUDENT_FIRSTNAME,"John");
        values.put(StudentEntry.COLUMN_STUDENT_LASTNAME,"Malkovitch");
        values.put(StudentEntry.COLUMN_STUDENT_AGE, 17);

        long newRowId = db.insert(StudentEntry.TABLE_NAME,null,values);

        Toast.makeText(getApplicationContext(),"Adding a new Row",Toast.LENGTH_SHORT).show();
        Log.e("Main","New row ID : "+newRowId);
    }

    public void DisplayDatabase(){

        // Reading from the database
        SQLiteDatabase db = mDbHelper.getReadableDatabase(); // Readable : Select operation

        // specifying the columns we want to return
        String[] projection = {
                StudentEntry._ID,
                StudentEntry.COLUMN_STUDENT_FIRSTNAME,
                StudentEntry.COLUMN_STUDENT_LASTNAME,
                StudentEntry.COLUMN_STUDENT_AGE};

        //instanciating a new cursor : cursor represents a 2 dimensional array getting all the data
        // from a database and allowing us to access through it
        /*
        query(boolean distinct, String table, String[] columns, String selection,
         String[] selectionArgs, String groupBy, String having, String orderBy, String limit)
         */
        Cursor cursor = db.query(StudentEntry.TABLE_NAME,projection,null,null,null,null,null);

        // instanciating the textView to show up the results in
        mText = (TextView) findViewById(R.id.xml_display);

        try{

            mText.setText("The table contains "+cursor.getCount()+" students.\n\n");

            //specify an index for each column in the cursor
            int idColumnIndex = cursor.getColumnIndex(StudentEntry._ID);
            int firstnameColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_STUDENT_FIRSTNAME);
            int lastnameColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_STUDENT_LASTNAME);
            int ageColumnIndex = cursor.getColumnIndex(StudentEntry.COLUMN_STUDENT_AGE);

            // iterating through the rows of the cursor

        }finally {
            // always close the cursor at the end
            cursor.close();
        }

    }
}

