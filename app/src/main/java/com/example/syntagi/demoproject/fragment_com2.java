package com.example.syntagi.demoproject;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import static com.example.syntagi.demoproject.R.*;

public class fragment_com2 extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_fragment_com2);
    }

    @Override
    public void respond(String data)
    {

    }

    @Override
    public void respond(int i) {
       FragmentManager manager=getSupportFragmentManager();
       FragmentB1 f2= (FragmentB1) manager.findFragmentById(id.fragment3);
       f2.changeData(i);

    }
}
