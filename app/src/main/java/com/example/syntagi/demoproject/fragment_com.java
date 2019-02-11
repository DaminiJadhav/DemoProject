package com.example.syntagi.demoproject;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class fragment_com extends AppCompatActivity implements Communicator{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_com);
    }

    @Override
    public void respond(String data) {

        FragmentManager manager=getSupportFragmentManager();
        FragmentB f2= (FragmentB) manager.findFragmentById(R.id.fragment1);
        f2.changeText(data);

    }

    @Override
    public void respond(int i) {

    }
}
