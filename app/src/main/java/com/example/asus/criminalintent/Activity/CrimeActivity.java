package com.example.asus.criminalintent.Activity;

import android.support.v4.app.Fragment;

import com.example.asus.criminalintent.Fragment.CrimeFragment;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

@Override
    protected Fragment createFragment(){
    UUID crimeId =(UUID)getIntent().getSerializableExtra(CrimeFragment.EXTRA_CRIME_ID);
    return CrimeFragment.newInstance(crimeId);
    //return  new CrimeFragment();
}
}
