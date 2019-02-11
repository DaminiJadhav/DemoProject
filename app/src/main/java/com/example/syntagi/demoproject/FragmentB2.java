package com.example.syntagi.demoproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB2 extends Fragment {

    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_b2,container,false);
       textView=view.findViewById(R.id.textview7);
       return view;
    }

    public void changeData(int index)
    {
        String []description=getResources().getStringArray(R.array.description2);
        textView.setText(description[index]);
    }
}
