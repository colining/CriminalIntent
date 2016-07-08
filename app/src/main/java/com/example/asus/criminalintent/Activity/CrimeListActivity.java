package com.example.asus.criminalintent.Activity;

import android.support.v4.app.Fragment;

import com.example.asus.criminalintent.Fragment.CrimeListFragment;

/**
 * Created by asus on 2016/7/7.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return  new CrimeListFragment();
    }
}
