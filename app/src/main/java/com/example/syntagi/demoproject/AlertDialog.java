package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AlertDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }
    public void showDialog(View view)
    {
        Alert_Dialog_cls alert_dialog_cls=new Alert_Dialog_cls();
        alert_dialog_cls.show(getSupportFragmentManager(),"My Alert");

    }
}
