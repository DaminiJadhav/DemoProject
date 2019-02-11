package com.example.syntagi.demoproject;

import android.content.Intent;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class fragment_com3 extends AppCompatActivity implements FragmentA2.Communicator {

    FragmentA2 f1;  
    FragmentB2 f2;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_com3);

        manager = getSupportFragmentManager();
        f1 = (FragmentA2) manager.findFragmentById(R.id.fragment4);
        f2 = (FragmentB2) manager.findFragmentById(R.id.fragment5);
        f1.setCommunicator(this);
    }

    @Override
    public void respond(int index) {

        if (f2 != null && f2.isVisible()) {
            f2.changeData(index);
        } else {
            Intent i = new Intent(this, another_activity.class);
            i.putExtra("index", index);
            startActivity(i);
        }
    }
}
