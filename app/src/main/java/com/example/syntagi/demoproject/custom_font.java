package com.example.syntagi.demoproject;

import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class custom_font extends AppCompatActivity {
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_font);
        tv1=findViewById(R.id.textview);

        Typeface mycustomfont=Typeface.createFromAsset(getAssets(),"font/comic_sans.ttf");
        tv1.setTypeface(mycustomfont);

    }
}
