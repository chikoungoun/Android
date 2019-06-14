package com.example.android.pets.data;

import android.net.Uri;
import android.provider.BaseColumns;

// Contract Class : Helps creating a bunch of constants adding more clarity and reusability to the code

public final class PetContract {

    /*
    Follwing the Uri format : scheme+content_authority+data
     */
    // the content authority
    public static final String CONTENT_AUTHORITY = "com.example.android.pets";

    // scheme + content authority
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://"+CONTENT_AUTHORITY);

    // the data
    public static final String PATH_PETS = "pets";



    public PetContract() {
    }

    public static final class PetEntry implements BaseColumns{

        // complete content Uri
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI,PATH_PETS);

        //Table name
        public static final String TABLE_NAME = "pets";

        // Table column names
        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PET_NAME ="name";
        public static final String COLUMN_PET_BREED = "breed";
        public static final String COLUMN_PET_GENDER = "gender";
        public static final String COLUMN_PET_WEIGHT = "weight";

        //Gender column possible values
        public static final int GENDER_UNKNOWN = 0;
        public static final int GENDER_MALE = 1;
        public static final int GENDER_FEMALE = 2;

        // Sanity checking
        public static boolean isValidGenger(int gender){
            if(gender == GENDER_UNKNOWN || gender == GENDER_MALE || gender == GENDER_FEMALE){
                return true;
            }
            return false;
        }







    }
}
