package com.example.syntagi.demoproject;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class another_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another_activity);
        Intent i=getIntent();
       int index= i.getIntExtra("index",0);
      FragmentB2 f2= (FragmentB2) getSupportFragmentManager().findFragmentById(R.id.fragment5);
      if(f2!=null)
            f2.changeData(index);
    }
}
