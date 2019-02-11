package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.Toast;

public class check_box extends AppCompatActivity implements OnClickListener {
CheckBox c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        c=findViewById(R.id.checkbox);
        c.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       CheckBox t=(CheckBox) v;
       if(t.isChecked())
       {
           Toast.makeText(this,"you want coffee with sugar",Toast.LENGTH_LONG).show();
       }
       else
       {
           Toast.makeText(this,"I know you are diet conscious:D I like it",Toast.LENGTH_LONG).show();
       }

    }
}
