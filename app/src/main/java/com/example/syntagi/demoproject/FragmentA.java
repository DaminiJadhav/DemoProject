package com.example.syntagi.demoproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment implements View.OnClickListener {

    Button button;
    int counter=0;
    Communicator comm;
    @Nullable

    public void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);
        if (saveInstanceState==null)
        {
            counter=0;
        }
        else
        {
            counter=saveInstanceState.getInt("counter",0);
        }
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragmenta,container,false);
        }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            comm= (Communicator) getActivity();
            button=getActivity().findViewById(R.id.button);
            button.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("counter",counter);

    }

    @Override
    public void onClick(View v) {
        counter++;
        comm.respond("The button was clicked "+counter+ "times");

    }
}
