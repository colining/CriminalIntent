package com.example.asus.criminalintent;

import android.content.Context;

/**
 * Created by asus on 2016/7/6.
 */
public class CrimeLab
{
    private  static  CrimeLab crimeLab;
    private Context appcontext;
    private CrimeLab(Context appcontext)
    {
        this.appcontext=appcontext;


    }
    public  static  CrimeLab get(Context c){
        if(crimeLab==null)
        {
            crimeLab=new CrimeLab(c.getApplicationContext());
        }
        return crimeLab;
    }
}
