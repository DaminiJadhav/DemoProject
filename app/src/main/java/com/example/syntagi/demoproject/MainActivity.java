package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView iv1,iv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
iv1=findViewById(R.id.imageview);
iv2=findViewById(R.id.imageview2);
iv1.setOnClickListener(this);
iv2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.imageview)
        {
            iv1.setVisibility(View.GONE);
            iv2.setVisibility(View.VISIBLE);
        }
        else
        {

            iv2.setVisibility(View.GONE);
            iv1.setVisibility(View.VISIBLE);
        }

    }
}
