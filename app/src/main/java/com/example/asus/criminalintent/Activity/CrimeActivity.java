package com.example.asus.criminalintent.Activity;

import android.support.v4.app.Fragment;

import com.example.asus.criminalintent.Fragment.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {

@Override
    protected Fragment createFragment(){
    return  new CrimeFragment();
}
}
