package com.example.syntagi.demoproject;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Async_Down_img extends AppCompatActivity implements AdapterView.OnItemClickListener {
EditText selectionText;
ProgressBar downloadImagePro;
ListView chooseList;
String []listofview;
NonUITaskFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async__down_img);
        selectionText=findViewById(R.id.url_path);
        downloadImagePro=findViewById(R.id.pro_bar);
        chooseList=findViewById(R.id.list);
       listofview=getResources().getStringArray(R.array.imageurls);
     if (savedInstanceState==null)
     {
         fragment=new NonUITaskFragment();
         getSupportFragmentManager().beginTransaction().add(fragment,"TaskFragment").commit();
     }
     else {
         fragment   =(NonUITaskFragment) getSupportFragmentManager().findFragmentByTag("TaskFragment");
     }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        selectionText.setText(listofview[position]);
    }
    public void Downlond_Image(View view)
    {
        if (selectionText.getText().toString()!=null &&  selectionText.getText().toString().length() >0)
        {
            MyTask myTask=new MyTask();
            myTask.execute(selectionText.getText().toString());
        }
    }
    class MyTask extends AsyncTask<String,Integer,Boolean>
    {
        private int calculatedprogres=0;
        private int contentLength=-1;
    private int count=0;

        @SuppressLint("WrongConstant")
        @Override
        protected void onPreExecute() {
            //super.onPreExecute();
            downloadImagePro.setVisibility(View.VISIBLE);
//

            if (Async_Down_img.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            {

                Async_Down_img.this.setRequestedOrientation(Configuration.ORIENTATION_PORTRAIT);

                //Async_Down_img.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }else

            {
            Async_Down_img.this.setRequestedOrientation(Configuration.ORIENTATION_LANDSCAPE);
             //   Async_Down_img.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }

        }

        @Override
        protected Boolean doInBackground(String... params) {
            boolean successful=false;

            URL downloadURL=null;
            HttpURLConnection connection=null;
            InputStream inputStream=null;
            FileOutputStream fileOutputStream=null;
            File file=null;
            try
            {
                downloadURL=new URL(params[0]);
                connection= (HttpURLConnection) downloadURL.openConnection();
                connection.getContentLength();
                inputStream=connection.getInputStream();
                file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"/"+Uri.parse(params[0]).getLastPathSegment());
                fileOutputStream=new FileOutputStream(file);
                L.m(""+file.getAbsolutePath());
                int read=-1;
                byte []buffer=new byte[1024];
                while ((read=inputStream.read(buffer))!=-1)
                {
                    fileOutputStream.write(buffer,0,read);
                    count=count+read;
                    L.m("Counter" +count+ "length" +contentLength);
                    publishProgress(count);
                    //L.m(""+read);
                }
                successful=true;
            }
            catch (MalformedURLException e)
            {
                L.m(e+"");
            }
            catch (IOException e)
            {
                L.m(e+"");
            }
            finally {

                if (connection!=null)
                {
                    connection.disconnect();
                }
                if (inputStream!=null)
                {
                    try {
                        inputStream.close();
                    }
                    catch (IOException e)
                    {
                        L.m(e+"");
                    }
                }
                if (fileOutputStream!=null)
                {
                    try {
                        fileOutputStream.close();
                    }
                    catch (IOException e)
                    {
                        L.m(e+"");
                    }
                }
                return successful;
            }



        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            calculatedprogres=(int)(((double)values[0]/contentLength)*10000);
            downloadImagePro.setProgress(calculatedprogres);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            //super.onPostExecute(aBoolean);
            downloadImagePro.setVisibility(View.GONE);
            Async_Down_img.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);

        }
    }
}
