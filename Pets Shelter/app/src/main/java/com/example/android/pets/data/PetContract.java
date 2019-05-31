package com.example.android.pets.data;

import android.provider.BaseColumns;

// Contract Class : Helps creating a bunch of constants adding more clarity and reusability to the code

public final class PetContract {

    public PetContract() {
    }

    public class PetEntry implements BaseColumns{

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







    }
}
