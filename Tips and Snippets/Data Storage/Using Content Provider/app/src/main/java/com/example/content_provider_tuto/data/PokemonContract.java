package com.example.content_provider_tuto.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

// Defining the database schema
public class PokemonContract {

    public static final String CONTENT_AUTHORITY = "com.example.content_provider_tuto";

    // Base of the URIs
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    // Path for the databse table
    public static final String PATH_POKEMON = "pokemon";


    public PokemonContract() {
    }

    public static final class PokemonEntry implements BaseColumns{

        // The whole Uri link
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_POKEMON);

        // Prefixes for returning lists or single element from a URI
        public static final String CONTENT_LIST_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/"+PATH_POKEMON;

        public static final String CONTENT_ITEM_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE+"/"+CONTENT_AUTHORITY+"/"+PATH_POKEMON;


        // Defining the table schema
        public static final String TABLE_NAME = "pokemon";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_POKE_NAME = "name";
        public static final String COLUMN_POKE_TYPE = "type";
        public static final String COLUMN_POKE_ATK = "attack";
        public static final String COLUMN_POKE_DEF = "defense";


    }
}
