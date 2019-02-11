package com.example.syntagi.demoproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class sharedpreference1 extends AppCompatActivity {
TextView usernametxtview,passtxtview;
//EditText editText1,editText2;
public static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference1);
        usernametxtview=findViewById(R.id.txt_1);
        passtxtview=findViewById(R.id.txt_2);
    }
    public void load(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("Name",DEFAULT);
        String pass=sharedPreferences.getString("Password",DEFAULT);
        if (name.equals(DEFAULT) || pass.equals(DEFAULT))
        {
            Toast.makeText(this, "No data was found", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show();
            usernametxtview.setText(name);
            passtxtview.setText(pass);
        }


    }
    public void  previous(View view)
    {
        Toast.makeText(this, "Previous", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,sharedpreference_activity.class);
        startActivity(i);
    }
}
