package com.example.syntagi.demoproject;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Activity2 extends AppCompatActivity {
    EditText editText1;
    TextView textView;
   String PackageName="com.example.myapplication";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        editText1=findViewById(R.id.Edit_Text);
        textView=findViewById(R.id.text1);
    }
    public void load_path(View view)
    {
        PackageManager packageManager=getPackageManager();
        try {
            ApplicationInfo applicationInfo=packageManager.getApplicationInfo(PackageName,packageManager.GET_META_DATA);
         //   textView.setText(applicationInfo.dataDir + "/files/vivz.txt");
String fullpath=applicationInfo.dataDir + "/files/vivz.txt";
readfile(fullpath);
        }
        catch (PackageManager.NameNotFoundException e)
        {
            textView.setTextColor(Color.RED);
            textView.setText(e +"");
        }
    }

    public void readfile(String fullpath)
    {  FileInputStream fileInputStream=null;
        try {
           fileInputStream=new FileInputStream(new File(fullpath));
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1)
            {
                buffer.append((char) read);
            }
          //L.s(this,""+buffer);
            editText1.setText(buffer);
            textView.setTextColor(Color.RED);
            textView.setText(buffer + "\n was read successfully" +fullpath);

        }
        catch (FileNotFoundException e)
        {
            textView.setTextColor(Color.RED);
            textView.setText(e +"");
        }
        catch (IOException e)
        {
            textView.setTextColor(Color.RED);
            textView.setText(e +"");
        }
        finally {
            if (fileInputStream!=null)
            {
                try
                {
                    fileInputStream.close();

                }
                catch (IOException e)
                {
                    textView.setTextColor(Color.RED);
                    textView.setText(e +"");
                }
            }
        }

    }
}
