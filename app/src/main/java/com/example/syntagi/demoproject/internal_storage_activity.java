package com.example.syntagi.demoproject;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class internal_storage_activity extends AppCompatActivity {
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_activity);
        username=findViewById(R.id.edit_text1);
        password=findViewById(R.id.edit_text2);
    }

    public void save(View view) {
        String text1 = username.getText().toString();
        String text2 = password.getText().toString();
        File file=null;
        text1 = text1 + "";
        FileOutputStream fileOutputStream = null;
        try {
            file=getFilesDir();
            fileOutputStream = openFileOutput("abc.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(text1.getBytes());
            fileOutputStream.write(text2.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        Toast.makeText(this, "saved successfully"+file, Toast.LENGTH_SHORT).show();
    }


        public void next (View view)
        {
            Toast.makeText(this, "Next", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, sharedpreference1.class);
            startActivity(i);
        }
    }


