package com.example.android.pets.data;

import android.content.ContentProvider;
import android.content.ContentResolver;
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

        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS, PETS);

        sUriMatcher.addURI(PetContract.CONTENT_AUTHORITY, PetContract.PATH_PETS + "/#", PET_ID);
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
        switch (match) {
            // getting all the table
            case PETS:
                Log.e("PetProvider", "SELECT *");
                cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            //getting a specific entry
            case PET_ID:
                selection = PetEntry._ID + "=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(PetEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }

        //Setting notification URI on the Cursor, to know what content URI the cuirsor was created for
        //If the data at this URI changes, then we know we need to update the Cursor
        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }


    // Insert new data into the provider with the given ContentValues.
    @Override
    public Uri insert(Uri uri, ContentValues values) {

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case PETS:
                return insertPet(uri, values);
            default:
                throw new IllegalArgumentException(("Insertion is not supported for " + uri));
        }


    }

    // Helper method for the insert()
    private Uri insertPet(Uri uri, ContentValues values){

        /*
                Sanity check
         */
        // Check that the name is not null
        String name = values.getAsString(PetEntry.COLUMN_PET_NAME);
        if(name == null){
            throw new IllegalArgumentException("Pet requires a name");
        }

        //Checking the Gender is equal to one of the available data
        Integer gender = values.getAsInteger(PetEntry.COLUMN_PET_GENDER);
        if(gender == null || !PetEntry.isValidGender(gender)){
            throw new IllegalArgumentException("Pet requires valid gender");
        }

        //Checking the weight. Can be null but not negative
        Integer weight = values.getAsInteger(PetEntry.COLUMN_PET_WEIGHT);
        if(weight < 0 && weight != null){
            throw new IllegalArgumentException("Pet weight requires a valid weight");
        }

        // No need to check the breed


        /*
                Inserting in the database
         */
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        //Insert the new pet with the given values
        long id = database.insert(PetEntry.TABLE_NAME,null,values);

        //if ID is -1, then the insertion failed.
        if(id == -1){
            Log.e(LOG_TAG,"Failed to insert row for "+uri);
        }

        //Notify all listeners that the data has changed for the pet content URI
        getContext().getContentResolver().notifyChange(uri,null);

        return ContentUris.withAppendedId(uri,id);
    }

    /*
            Updating data
     */
    // Updates the data at the given selection and selection arguments, with the new ContentValues.
    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

        final int match = sUriMatcher.match(uri);
        switch (match){
            case PETS:
                return updatePet(uri, values, selection,selectionArgs);
            case PET_ID:

                selection = PetEntry._ID+"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return updatePet(uri,values, selection,selectionArgs);
                default:
                    throw new IllegalArgumentException(("Update is not supported for "+uri));

        }
    }

    private int updatePet(Uri uri, ContentValues values, String selection, String[] selectionArgs){

        // TODO: Update the selected pets in the pets database table with the given ContentValues
         /*
                Sanity check
         */

         //Check if the link PetEntry#COLUMN_PET_NAME key is present
        if(values.containsKey(PetEntry.COLUMN_PET_NAME)){
            // Check that the name is not null
            String name = values.getAsString(PetEntry.COLUMN_PET_NAME);
            if(name == null){
                throw new IllegalArgumentException("Pet requires a name");
            }
        }


        //Check if the link PetEntry#COLUMN_PET_GENDER key is present
        if(values.containsKey(PetEntry.COLUMN_PET_GENDER)){
            //Checking the Gender is equal to one of the available data
            Integer gender = values.getAsInteger(PetEntry.COLUMN_PET_GENDER);
            if(gender == null || !PetEntry.isValidGender(gender)){
                throw new IllegalArgumentException("Pet requires valid gender");
            }
        }


        //Check if the link PetEntry#COLUMN_PET_WEIGHT key is present
        if(values.containsKey(PetEntry.COLUMN_PET_WEIGHT)){
            //Checking the weight. Can be null but not negative
            Integer weight = values.getAsInteger(PetEntry.COLUMN_PET_WEIGHT);
            if(weight < 0 && weight != null){
                throw new IllegalArgumentException("Pet weight requires a valid weight");
            }
        }


        // No need to check the breed

        /*
        Don't try to update if there are no values to update
         */
        if(values.size() == 0){
            return 0;
        }

        /*
        Don't try to update if there are no values to update
         */
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        /*
        Return the number of database rows affected by the update
         */
        int rowsUpdated =  database.update(PetEntry.TABLE_NAME,values,selection,selectionArgs);

        //if 1 or more rows are updated notify all listeners
        if(rowsUpdated != 0){
            getContext().getContentResolver().notifyChange(uri,null);
        }

        // return the number of rows updated
        return rowsUpdated;
    }

    /*
            Deleting data
     */
    //Delete the data at the given selection and selection arguments.
    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {

        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        int rowsDeleted;

        final int match = sUriMatcher.match(uri);
        switch (match){
            case PETS:
                //delete all rows that matches the selection and selection args
                rowsDeleted = database.delete(PetEntry.TABLE_NAME, selection, selectionArgs);
                break;
            case PET_ID:
                //delete a single row given the ID in the URI
                selection = PetEntry._ID+"=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                rowsDeleted = database.delete(PetEntry.TABLE_NAME,selection,selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Deletion is not suported for "+uri);
        }

        // if 1 or more rows were deleted, then notify all listeners that the data at the URI has changed
        if(rowsDeleted != 0){
            getContext().getContentResolver().notifyChange(uri,null);
        }

        return rowsDeleted;
    }

    //Returns the MIME type of data for the content URI.
    @Override
    public String getType(Uri uri) {

        final int match = sUriMatcher.match(uri);
        switch (match){
            case PETS:
                return PetEntry.CONTENT_LIST_TYPE;
            case PET_ID:
                return PetEntry.CONTENT_ITEM_TYPE;
                default:
                    throw new IllegalStateException("Unknown URI "+uri+" witch match "+match);
        }
    }
}
