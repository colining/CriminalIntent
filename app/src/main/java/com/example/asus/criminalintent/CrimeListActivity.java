package com.example.asus.criminalintent;

import android.support.v4.app.Fragment;

/**
 * Created by asus on 2016/7/7.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment(){
        return  new CrimeListFragment();
    }
}
