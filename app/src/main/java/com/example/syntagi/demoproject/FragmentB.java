package com.example.syntagi.demoproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentB extends Fragment {
    TextView tv;
    String data;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        tv = view.findViewById(R.id.textview5);
        if (savedInstanceState == null) {

        } else {
            data = savedInstanceState.getString("tv");

            tv.setText(data);
        }
        return view;

    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("text", data);

    }

    public void changeText(String data) {
        if (data != null) {
            this.data = data;
            tv.setText(data);
        }

    }
}
