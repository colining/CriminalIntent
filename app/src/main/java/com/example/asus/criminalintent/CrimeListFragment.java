package com.example.asus.criminalintent;

import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2016/7/7.
 */
public class CrimeListFragment extends android.support.v4.app.ListFragment{
    private ArrayList<Crime> crimes;
    private  static  final String TAG ="CrimeListFragment";
    @Override
    public  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getActivity().setTitle(R.string.crime_title);
        crimes =CrimeLab.get(getActivity()).getCrimes();
        ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,crimes);
        setListAdapter(adapter);


    }
    @Override
    public void onListItemClick(ListView listView, View view , int position,long id)
    {
        Crime c =(Crime)(getListAdapter()).getItem(position);
        Log.d(TAG, c.getmTitle()+"was click");
    }

    private   class  CrimeAdapter extends  ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes)
        {
            super(getActivity(),0,crimes);
        }
    }
}
