package com.example.content_provider_tuto.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.CancellationSignal;

import com.example.content_provider_tuto.data.PokemonContract.PokemonEntry;

public class PokemonProvider extends ContentProvider {

    private static final int POKEMONS = 100;
    private static final int POKEMON_ID = 101;

    // Matching a content URI to a corresponding code
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);


    //ACHTUNG!!! HYPER IMPORTANT
    static {

        sUriMatcher.addURI(PokemonContract.CONTENT_AUTHORITY,PokemonContract.PATH_POKEMON,POKEMONS);

        sUriMatcher.addURI(PokemonContract.CONTENT_AUTHORITY, PokemonContract.PATH_POKEMON+"/#",POKEMON_ID);
    }

    private PokemonDbHelper mDbHelper;

    @Override
    public boolean onCreate() {

        // initialize the provider and the databse object
        mDbHelper = new PokemonDbHelper(getContext());

        return true;
    }


    // find the MIME type of the results
    @Override
    public String getType(Uri uri) {
        switch (sUriMatcher.match(uri)){
            case POKEMONS:
                return PokemonEntry.CONTENT_LIST_TYPE;
            case POKEMON_ID:
                return PokemonEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown uri : "+uri);

        }
    }

    @Override
    public Cursor query(Uri uri,String[] projection,String selection,String[] selectionArgs,String sortOrder) {

        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor;

        int match =sUriMatcher.match(uri);
        switch (match){
            case POKEMONS:
                cursor = db.query(PokemonEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            case POKEMON_ID:
                selection = PokemonEntry._ID+"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                cursor = db.query(PokemonEntry.TABLE_NAME,
                        projection,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        long id;
        Uri returnUri;

        final int match = sUriMatcher.match(uri);
        switch (match){
            case POKEMONS:
                id = db.insert(PokemonEntry.TABLE_NAME,null,values);
                if(id > 0){
                    returnUri = ContentUris.withAppendedId(uri,id);
                }else{
                    throw new UnsupportedOperationException("Unable to insert rows into: " + uri);
                }
                break;
                default:
                    throw new IllegalArgumentException(("Insertion is not supported for " + uri));
        }
        return returnUri;
    }

    @Override

    public int delete(Uri uri, String selection, String[] selectionArgs) {

        final SQLiteDatabase db = mDbHelper.getWritableDatabase();

        switch(sUriMatcher.match(uri)){
            case POKEMONS:
                return db.delete(PokemonEntry.TABLE_NAME,selection,selectionArgs);
            case POKEMON_ID:
                selection = PokemonEntry._ID+"=?";
                selectionArgs = new String[]{ String.valueOf(ContentUris.parseId(uri))};
                return db.delete(PokemonEntry.TABLE_NAME,selection,selectionArgs);
                default:
                    throw new  IllegalArgumentException("Deletion is not suported for "+uri);
        }
    }



    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {

       SQLiteDatabase db = mDbHelper.getWritableDatabase();

        switch(sUriMatcher.match(uri)){
            case POKEMONS:
                return db.update(PokemonEntry.TABLE_NAME,values,selection,selectionArgs);
            case POKEMON_ID:
                selection = PokemonEntry._ID+"=?";
                selectionArgs = new String[]{String.valueOf(ContentUris.parseId(uri))};
                return db.update(PokemonEntry.TABLE_NAME,values,selection,selectionArgs);

            default:
                throw new IllegalArgumentException(("Insertion is not supported for " + uri));
        }

    }
}
