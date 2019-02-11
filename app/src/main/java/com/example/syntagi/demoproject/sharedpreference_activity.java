package com.example.syntagi.demoproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;




public class sharedpreference_activity extends AppCompatActivity {

    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharedpreference_activity);
        username=findViewById(R.id.edit_text1);
        password=findViewById(R.id.edit_text2);


    }
    public void save(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
      SharedPreferences.Editor editor= sharedPreferences.edit();
      editor.putString("Name",username.getText().toString());
        editor.putString("Password",password.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data save successfully", Toast.LENGTH_SHORT).show();
    }
    public void  next(View view)
    {
        Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
        Intent i=new Intent(this,sharedpreference1.class);
        startActivity(i);
    }
}
