package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Log;

import com.example.android.pets.data.PetContract.PetEntry;


public class PetProvider extends ContentProvider {

    // Tag for the log messages
    public static final String LOG_TAG = PetProvider.class.getSimpleName();

    // URI matcher code for the contentURI for the pets table
    private static final int PETS = 100;

    // URI matcher code for the contentURI for a single pet in the pets table
    private static final int PET_ID = 101;

    // Matching a content URI to a corresponding code
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    //ACHTUNG!!!
    static {

        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY,PetContract.PATH_PETS,PETS);

        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS+"/#",PET_ID);
    }

    private PetDbHelper mDbHelper;


    // initialize the provider and the database helper object
    @Override
    public boolean onCreate() {
        // TODO: Create and initialize a PetDbHelper object to gain access to the pets database.
        // Make sure the variable is a global variable, so it can be referenced from other
        // ContentProvider methods.

        mDbHelper = new PetDbHelper(getContext());

        return true;
    }


    //Perform the query for the given URI. Use the given projection, selection, selection arguments, and sort order.
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs,
                         String sortOrder) {

        SQLiteDatabase database = mDbHelper.getReadableDatabase();

        Cursor cursor;

        int match = sUriMatcher.match(uri);
        switch(match){
            // getting all the table
            case PETS:
                Log.e("PetProvider","SELECT *");
                cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
                //getting a specific entry
            case PET_ID:
                selection = PetEntry._ID +"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI "+uri);
        }

        return cursor;
    }


    //Returns the MIME type of data for the content URI.
    @Override
    public String getType( Uri uri) {
        return null;
    }


    // Insert new data into the provider with the given ContentValues.
    @Override
    public Uri insert(Uri uri,ContentValues values) {
        return null;
    }

    // Updates the data at the given selection and selection arguments, with the new ContentValues.
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }


    //Delete the data at the given selection and selection arguments.
    @Override
    public int delete(Uri uri,String selection, String[] selectionArgs) {
        return 0;
    }
}
