package com.example.syntagi.demoproject;

import android.app.Activity;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class mydialog extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydialog);
        Intent i=getIntent();
        if(i!=null)
        {
          int imgId= i.getIntExtra("natureimage",R.drawable.home);
            String name=i.getStringExtra("naturename");
            ImageView myimage=(ImageView) findViewById(R.id.imageview5);
            myimage.setImageResource(imgId);
            TextView tv=(TextView) findViewById(R.id.text3);
            tv.setText("This flag is belongs to" +name);
        }
    }
    public void closeDialog(View v)
    {
      finish();
    }
}
