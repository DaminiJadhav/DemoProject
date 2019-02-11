package com.example.syntagi.demoproject;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class toggle_button extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    RelativeLayout r;
    ToggleButton tb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        tb = findViewById(R.id.togglebutton);
        r = findViewById(R.id.rv);
        tb.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            r.setBackgroundColor(Color.BLACK);
        } else {
            r.setBackgroundColor(Color.WHITE);
        }
    }
}
