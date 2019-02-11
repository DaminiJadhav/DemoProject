    package com.example.syntagi.demoproject;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

    public class CustomDialog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_dialog);
    }

    public void showdialog(View view)
    {

        MyAlertCustDial myAlertCustDial=new  MyAlertCustDial ();
        myAlertCustDial.show(getSupportFragmentManager(),"My Alert");
    }
        public void showdialog1(View view)
        {

            MyAlertCustDial myAlertCustDial=new  MyAlertCustDial ();
            FragmentManager manager=getSupportFragmentManager();
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(R.id.group1,myAlertCustDial,"My alert fragment");
            transaction.commit();
                        
        }
}
