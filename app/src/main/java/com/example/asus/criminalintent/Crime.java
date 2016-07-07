package com.example.asus.criminalintent;

import android.util.Log;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Created by asus on 2016/7/3.
 */
public class Crime extends android.text.format.DateFormat{
    private UUID mId;
    private  String mTitle;
    private Date mDate=null;
    private  boolean mSolved;

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmId(UUID mId) {

        this.mId = mId;
    }

    public String getmTitle() {

        return mTitle;
    }

    public UUID getmId() {

        return mId;
    }

    public boolean ismSolved() {
        return mSolved;
    }

    public void setmSolved(boolean mSolved) {
        this.mSolved = mSolved;
    }

    public Date getmDate() {

        return mDate;
    }

    public void setmDate(Date mDate) {

        this.mDate = mDate;
    }

    public  Crime(){
        mId=UUID.randomUUID();
        mDate=new Date();



    }
}
