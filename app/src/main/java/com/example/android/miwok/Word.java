package com.example.android.miwok;

import android.widget.ImageView;

public class Word {
    private  String mDefaultTranslation;
    private String mMiwokTranslation;
    private  int mImageResourceId;

    private int mAudioResourceID;




    public  Word(String DefaultTranslation, String MiwokTranslation, int ImageResource ,int AudioResource )
    {
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation= MiwokTranslation;
        mImageResourceId =ImageResource;
        mAudioResourceID = AudioResource;
    }

    public  Word(String DefaultTranslation,String MiwokTranslation,int AudioResource )
    {
        mDefaultTranslation=DefaultTranslation;
        mMiwokTranslation= MiwokTranslation;
        mAudioResourceID=AudioResource;

    }



    public  String getDefaultTranslation() {
        return mDefaultTranslation;
    }
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }

    public int getmImageResourceId()
    {
        return  mImageResourceId;
    }
    public int getmAudioResourceID()
    {
        return mAudioResourceID;
    }






}
