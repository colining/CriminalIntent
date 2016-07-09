package com.example.asus.criminalintent.Fragment;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.support.v4.app.Fragment;

import com.example.asus.criminalintent.Crime;
import com.example.asus.criminalintent.CrimeLab;
import com.example.asus.criminalintent.R;

import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * Created by asus on 2016/7/3.
 */
public class CrimeFragment extends Fragment{
    private Crime mCrime;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mSolvedCheck;
    public  static  String EXTRA_CRIME_ID="com.example.asus.criminalintent.crime_id";
    @Override
    public  void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        UUID crimeId =(UUID)getArguments().getSerializable(EXTRA_CRIME_ID);

        mCrime= CrimeLab.get(getActivity()).getCrime(crimeId);
    }
    @Override
    public  View onCreateView (LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_crime,parent,false);
        mTitleField=(EditText)v.findViewById(R.id.crime_title);
       mTitleField.setText(mCrime.getmTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                mCrime.setmTitle(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        mDateButton =(Button)v.findViewById(R.id.crime_date);
        String fromt="yyyy-MM-dd HH:mm:ss.SSS";
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(fromt);
       // mDate=simpleDateFormat.format(mDate);
        mDateButton.setText(simpleDateFormat.format(mCrime.getmDate()));
        mDateButton.setEnabled(false);
        mSolvedCheck=(CheckBox)v.findViewById(R.id.crime_sovled);
        mSolvedCheck.setChecked(mCrime.ismSolved());
        mSolvedCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                mCrime.setmSolved(b);
            }
        });
        return v;
    }
    public static  CrimeFragment newInstance(UUID crimeid)
    {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_CRIME_ID,crimeid);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return  fragment;
    }
}
