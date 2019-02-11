package com.example.syntagi.demoproject;

import android.content.Intent;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class file_stro_load_act extends AppCompatActivity {
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_stro_load_act);
        editText=findViewById(R.id.usereditxtload);
    }
    public void  load_internal_cache(View view)
    {

        File folder=getCacheDir();
        File myfile=new File(folder,"MyFile1.txt");
        String data=readData(myfile);
        if (data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("NO data was return");
        }

    }
    public void  load_external_cache(View view)
    {
        File folder=getExternalCacheDir();
        File myfile=new File(folder,"MyFile2.txt");
        String data=readData(myfile);
        if (data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("NO data was return");
        }
    }
    public void  load_external_private(View view)
    {
        File folder=getExternalFilesDir("File_Storage");
        File myfile=new File(folder,"MyFile3.txt");
        String data=readData(myfile);
        if (data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("NO data was return");
        }
    }
    public void  load_external_public(View view)
    {
        File folder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile=new File(folder,"MyFile4.txt");
        String data=readData(myfile);
        if (data!=null)
        {
            editText.setText(data);
        }
        else
        {
            editText.setText("NO data was return");
        }
    }
    private String readData(File myfile)
    {
        FileInputStream fileInputStream=null;
        try
        {
            fileInputStream=new FileInputStream(myfile);
            int read=-1;
            StringBuffer stringBuffer=new StringBuffer();
            while ((read=fileInputStream.read())!=-1)
            {
                stringBuffer.append((char) read);
            }
return stringBuffer.toString();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
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
                    e.printStackTrace();
                }
            }
        }
return null;
    }
    public void  Previous(View view)
    {
        Intent i=new Intent(this,file_storage_activity.class);
        startActivity(i);
    }
    public void message(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
