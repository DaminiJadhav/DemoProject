package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class image_listview extends AppCompatActivity {

    ListView lv;
    String [] day={"Sunday","Monday","Thesday","Wednesday","Thusday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_listview);

        lv=findViewById(R.id.listview);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.single_row,R.id.textview,day);
        lv.setAdapter(adapter);
    }
}
