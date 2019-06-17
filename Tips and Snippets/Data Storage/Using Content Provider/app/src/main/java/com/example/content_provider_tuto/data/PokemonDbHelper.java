package com.example.content_provider_tuto.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.content_provider_tuto.data.PokemonContract.PokemonEntry;

public class PokemonDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "pokemons.db";

    public PokemonDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // creating the pokemon table
        String SQL_CREATE_POKEMON_TABLE ="CREATE TABLE "+ PokemonEntry.TABLE_NAME+"("
                +PokemonEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
                +PokemonEntry.COLUMN_POKE_NAME+" TEXT, "
                +PokemonEntry.COLUMN_POKE_TYPE+" TEXT, "
                +PokemonEntry.COLUMN_POKE_ATK+" INTEGER, "
                +PokemonEntry.COLUMN_POKE_DEF+" INTEGER);";

        db.execSQL(SQL_CREATE_POKEMON_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
