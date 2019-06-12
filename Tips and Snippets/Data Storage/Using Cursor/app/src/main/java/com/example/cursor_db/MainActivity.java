package com.example.cursor_db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.cursor_db.data.StudentContract.StudentEntry;
import com.example.cursor_db.data.StudentDBHelper;

public class MainActivity extends AppCompatActivity {

    //Instanciate SQLiteHelper
    private StudentDBHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDbHelper = new StudentDBHelper(this);

        Button bDummies = (Button)findViewById(R.id.button_dummy);
        bDummies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertDummy();
            }
        });

    }

    // Inserting dummy data into a database
    public void insertDummy(){

        // Adding a data into the database
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(StudentEntry.COLUMN_STUDENT_FIRSTNAME,"John");
        values.put(StudentEntry.COLUMN_STUDENT_LASTNAME,"Malkovitch");
        values.put(StudentEntry.COLUMN_STUDENT_AGE, 17);

        long newRowId = db.insert(StudentEntry.TABLE_NAME,null,values);

        Toast.makeText(getApplicationContext(),"Adding a new Row",Toast.LENGTH_SHORT).show();
        Log.e("Main","New row ID : "+newRowId);






    }
}
