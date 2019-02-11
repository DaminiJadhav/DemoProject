package com.example.syntagi.demoproject;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class fragment_trans extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
FragmentManager manager;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_trans);
        manager=getSupportFragmentManager();
        text = findViewById(R.id.tv_msg);
        manager.addOnBackStackChangedListener(this);

    }
    public void addA(View view)
    {
    FragmentA3 f1=new FragmentA3();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group,f1,"A");
        transaction.commit();
        transaction.addToBackStack("addA");
    }
    public void RemoveA(View view)
    {
        FragmentA3 f1= (FragmentA3) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f1!=null)
        {
            transaction.remove(f1);
            transaction.addToBackStack("RemoveA");
            transaction.commit();
        }
        else
        {
            Toast.makeText(this,"This Fragment A is not add before",Toast.LENGTH_LONG).show();
        }
    }

   public void addB(View view)
    {
        FragmentB3 f2=new FragmentB3();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.group,f2,"B");
        transaction.addToBackStack("addB");
        transaction.commit();
    }

    public void RemoveB(View view)
    {
        FragmentB3 f2= (FragmentB3) manager.findFragmentByTag("B");
        FragmentTransaction transaction=manager.beginTransaction();
        if(f2!=null)
        {
            transaction.remove(f2);
            transaction.addToBackStack("RemoveB");
            transaction.commit();
        }
        else
        {
            Toast.makeText(this,"This Fragment B is not add before",Toast.LENGTH_LONG).show();
        }
    }

    public void ReplaceAwithB(View view)
    {
        FragmentB3 f2=new FragmentB3();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.group,f2,"B");
        transaction.addToBackStack("ReplaceAwithB");
        transaction.commit();
    }
    public void ReplaceBwithA(View view)
    {
        FragmentA3 f1=new FragmentA3();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(R.id.group,f1,"A");
        transaction.addToBackStack("ReplaceBwithA");
        transaction.commit();
    }
    public void attachA(View view)
    {
        FragmentA3 f1= (FragmentA3) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if (f1!=null)
        {
            transaction.attach(f1);
            transaction.addToBackStack("attachA");
            transaction.commit();
        }
    }
    public void dettachA(View view)
    {
        FragmentA3 f1= (FragmentA3) manager.findFragmentByTag("A");
        FragmentTransaction transaction=manager.beginTransaction();
        if (f1!=null)
        {
            transaction.detach(f1);
            transaction.addToBackStack("detachA");
            transaction.commit();
        }
    }

    public void back(View view)
    {
        manager.popBackStack();
    }
    public void popaddB(View view)
    {
        manager.popBackStack("addB",0);
    }


    @Override
    public void onBackStackChanged()
    {
        text.setText(text.getText()+"\n");
        text.setText(text.getText()+"The current status black stack");
        int count=manager.getBackStackEntryCount();
        for (int i=count-1;i>=0;i--)
        {
            FragmentManager.BackStackEntry entry=manager.getBackStackEntryAt(i);
            text.setText(text.getText()+" "+entry.getName()+" \n");
        }
        text.setText(text.getText()+"\n");
    }
}
