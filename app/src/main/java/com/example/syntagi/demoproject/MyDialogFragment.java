package com.example.syntagi.demoproject;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MyDialogFragment extends AppCompatActivity implements My_Dialog_Fragment1.Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_dialog_fragment);
    }
    public void showdialog(View view)
    {
        FragmentManager manager=getSupportFragmentManager();
           My_Dialog_Fragment1 myDialogFragment=new   My_Dialog_Fragment1();
           myDialogFragment.show(manager,"My Dialog");

    }

    @Override
    public void onDialogMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
