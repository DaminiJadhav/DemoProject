package com.example.syntagi.demoproject;

import android.content.Intent;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_storage_activity extends AppCompatActivity {
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_storage_activity);
        editText=findViewById(R.id.usereditxt);
    }
    public void internal_cache(View view)
    {
        String data=editText.getText().toString();
        File folder=getCacheDir();
        File myfile=new File(folder,"MyFile1.txt");
        writeData(myfile,data);

    }
    public void external_cache(View view)
    {
        String data=editText.getText().toString();
        File folder=getExternalCacheDir();
        File myfile=new File(folder,"MyFile2.txt");
        writeData(myfile,data);
    }
    public void external_private(View view)
    {
        String data=editText.getText().toString();
        File folder=getExternalFilesDir("File_Storage");
        File myfile=new File(folder,"MyFile3.txt");
        writeData(myfile,data);
    }
    public void external_public_file(View view)
    {

        String data=editText.getText().toString();
        File folder=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myfile=new File(folder,"MyFile4.txt");
        //dirchecked(d);
        writeData(myfile,data);
    }

    private void writeData(File myfile,String data)
    {
        FileOutputStream fileOutputStream=null;
        try
        {
            fileOutputStream=new FileOutputStream(myfile);
            fileOutputStream.write(data.getBytes());
            message(data+ "was written successfully" +myfile.getAbsolutePath());

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
            if (fileOutputStream!=null)
            {
                try
                {
                    fileOutputStream.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    private  void dirchecked(String d)
    {
        File f = new File(Environment.DIRECTORY_DOWNLOADS + d);

        if(!f.isDirectory()) {
            f.mkdirs();
        }
    }
    public void next(View view)
    {
        Intent i=new Intent(this,file_stro_load_act.class);
        startActivity(i);
    }
    public void message(String message)
    {
       Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
