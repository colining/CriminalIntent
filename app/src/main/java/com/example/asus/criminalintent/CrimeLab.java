package com.example.asus.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by asus on 2016/7/6.
 */
public class CrimeLab
{
    private ArrayList<Crime> crimes;
    private  static  CrimeLab crimeLab;
    private Context appcontext;
    private CrimeLab(Context appcontext)
    {
        this.appcontext=appcontext;
        crimes=  new ArrayList<Crime>();
        for (int i=0;i<100;i++)
        {
            Crime c =new Crime();
            c.setmTitle("Crime #"+i);
            c.setmSolved(i%2==0);
            crimes.add(c);
        }
    }
    public ArrayList<Crime>getCrimes(){
        return crimes;
    }
    public Crime getCrime(UUID id)
    {
        for(Crime c:crimes)
        {
            if(c.getmId().equals(id))
                return  c;
        }
        return  null;
    }
    public  static  CrimeLab get(Context c){
        if(crimeLab==null)
        {
            crimeLab=new CrimeLab(c.getApplicationContext());
        }
        return crimeLab;
    }
}
