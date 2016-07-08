package com.example.asus.criminalintent.Fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.criminalintent.Activity.CrimeActivity;
import com.example.asus.criminalintent.Crime;
import com.example.asus.criminalintent.CrimeLab;
import com.example.asus.criminalintent.R;

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
        crimes = CrimeLab.get(getActivity()).getCrimes();
       // ArrayAdapter<Crime> adapter = new ArrayAdapter<Crime>(getActivity(),android.R.layout.simple_list_item_1,crimes);
        CrimeAdapter crimeAdapter =new CrimeAdapter(crimes);
        setListAdapter(crimeAdapter);


    }
    @Override
    public void onListItemClick(ListView listView, View view , int position,long id)
    {
       // Crime c =(Crime)(getListAdapter()).getItem(position);
        Crime c =((CrimeAdapter)getListAdapter()).getItem(position);
        //Log.d(TAG, c.getmTitle()+"was click");
        //启动CrimeAcivity
        Intent intent =new Intent(getActivity(), CrimeActivity.class);
        startActivity(intent);


    }

    private   class  CrimeAdapter extends  ArrayAdapter<Crime> {
        public CrimeAdapter(ArrayList<Crime> crimes)
        {
            super(getActivity(),0,crimes);
        }
        int a=0;
        @Override
        public  View getView (int position, View convertView, ViewGroup parent)
        {
            if(convertView==null)
            {
                convertView =getActivity().getLayoutInflater().inflate(R.layout.list_item_crime,null);

            }
            Crime c =getItem(position);
            TextView titleTextView  =(TextView)convertView.findViewById(R.id.crime_list_item_titleTextView);
            titleTextView.setText(c.getmTitle());
            TextView dateTextview =(TextView)convertView.findViewById(R.id.crime_list_item_dateTextView);
            dateTextview.setText(c.getmDate().toString());
            CheckBox sovledCheckbox= (CheckBox)convertView.findViewById(R.id.crime_list_item_sovledCheckBox);
            sovledCheckbox.setChecked(c.ismSolved());


            return  convertView;
        }
    }


}
