package com.example.syntagi.demoproject;

import android.net.Uri;
import android.os.Environment;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Handle_Post extends AppCompatActivity implements AdapterView.OnItemClickListener {
    EditText ed1;
    TextView tv1;
    ProgressBar progressBar;
    ListView listView;
    private String  []listofimage;
    private LinearLayout loading=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle__post);

        ed1=findViewById(R.id.downloadurl);
        tv1=findViewById(R.id.txt3);
        listView=findViewById(R.id.list);
        listView.setOnItemClickListener(this);
        listofimage=getResources().getStringArray(R.array.imageurls);
        progressBar=findViewById(R.id.progres);
        loading=findViewById(R.id.linear_layout);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ed1.setText(listofimage[position]);
    }
    private class DownloadImage implements Runnable
    {
        private String url;
        public DownloadImage(String url)
        {
            this.url=url;
        }

        @Override
        public void run() {
            Handle_Post.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loading.setVisibility(View.VISIBLE);
                }
            });
            downloadimageusingThread(url);
        }
    }
    public void download(View view)
    {
//        File file=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
//
//        String url=listofimage[0];
//        Uri uri=Uri.parse(url);
//        L.s(this,uri.getLastPathSegment());
        String url=ed1.getText().toString();

       Thread mythread=new Thread(new DownloadImage(url));
        mythread.start();
    }
    public boolean downloadimageusingThread(String url)
    {
        boolean successful=false;

        URL downloadURL=null;
        HttpURLConnection httpURLConnection=null;
        InputStream inputStream=null;
        FileOutputStream fileOutputStream=null;
        File file=null;
        try
        {
            downloadURL=new URL(url);
            httpURLConnection= (HttpURLConnection) downloadURL.openConnection();
            inputStream=httpURLConnection.getInputStream();
            file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"/"+Uri.parse(url).getLastPathSegment());
            fileOutputStream=new FileOutputStream(file);
            L.m(""+file.getAbsolutePath());
            int read=-1;
            byte []buffer=new byte[1024];
            while ((read=inputStream.read(buffer))!=-1)
            {
                fileOutputStream.write(buffer,0,read);
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
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loading.setVisibility(View.GONE);

                }
            });
            if (httpURLConnection!=null)
            {
                httpURLConnection.disconnect();
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

}
