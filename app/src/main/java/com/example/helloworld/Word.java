package com.example.helloworld;

public class Word {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mAudio;
    private static final int NO_IMAGE = -1;
    private int mImageResourceId=NO_IMAGE;

    public Word(String English, String Miwok, int Audio){
        mDefaultTranslation = English;
        mMiwokTranslation = Miwok;
        mAudio = Audio;
    }

    public Word(String English, String Miwok, int Image,int Audio){
        mDefaultTranslation = English;
        mMiwokTranslation = Miwok;
        mImageResourceId = Image;
        mAudio = Audio;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public  String getDefaultTranslation(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){ return mImageResourceId;}

    public int getAudio(){return mAudio;}

    public boolean hasImage(){
        return mImageResourceId!=NO_IMAGE;
    }
}
