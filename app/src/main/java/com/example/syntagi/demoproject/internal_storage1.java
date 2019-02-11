package com.example.syntagi.demoproject;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class internal_storage1 extends AppCompatActivity {
TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage1);
        tv1=findViewById(R.id.txt_1);
        tv2=findViewById(R.id.txt_2);

    }
    public void load(View view)
    {
        try {
            FileInputStream fileInputStream=openFileInput("abc.txt");
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1)
            {
                buffer.append((char) read);
            }
            String text1=buffer.substring(0,buffer.indexOf(" "));
            String text2=buffer.substring(buffer.indexOf(""));
            tv1.setText(text1);
            tv2.setText(text2);


        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Toast.makeText(this, "saved successfully    ", Toast.LENGTH_SHORT).show();
    }
    public void  previous(View view)
    {
        Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,sharedpreference_activity.class);
        startActivity(i);
    }
}
