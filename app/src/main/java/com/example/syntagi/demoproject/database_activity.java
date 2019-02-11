package com.example.syntagi.demoproject;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class database_activity extends AppCompatActivity {

    VivzHelper vivzHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_activity);
        vivzHelper=new VivzHelper(this);
        SQLiteDatabase sqLiteDatabase=vivzHelper.getWritableDatabase();
    }
}
