package com.example.miwok;

public class Word {

    private static final int NO_IMAGE_PROVIDED = -1;

    private String mDefault;
    private String mMiwok;
    //store a picture id rather than the whole image
    private int mImageId = NO_IMAGE_PROVIDED;
    private int mAudioId;


    /*
        public Word(String defaultTransaltion,String miwokTranslation,int imageId){
            mDefault = defaultTransaltion;
            mMiwok = miwokTranslation;
            mImageId = imageId;
        }
        */
    public Word(String defaultTransaltion, String miwokTranslation, int audio) {
        mDefault = defaultTransaltion;
        mMiwok = miwokTranslation;
        mAudioId = audio;
    }

    public Word(String defaultTransaltion, String miwokTranslation, int imageId, int audio) {
        mDefault = defaultTransaltion;
        mMiwok = miwokTranslation;
        mImageId = imageId;
        mAudioId = audio;
    }

    public String getmDefault() {
        return mDefault;
    }

    public String getmMiwok() {
        return mMiwok;
    }

    public int getmImageId() {
        return mImageId;
    }

    public int getmAudioId() {
        return mAudioId;
    }

    public boolean hasImage() {
        return mImageId != NO_IMAGE_PROVIDED;
    }
}
