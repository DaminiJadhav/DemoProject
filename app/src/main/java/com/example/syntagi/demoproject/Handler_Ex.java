package com.example.syntagi.demoproject;

import android.os.Handler;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Handler_Ex extends AppCompatActivity {

    Thread thread;
    Handler handler;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler__ex);
        progressBar=findViewById(R.id.progres_bar);
        thread=new Thread(new MyThread());
        thread.start();
        handler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
              //  super.handleMessage(msg);
                progressBar.setProgress(msg.arg1);
            }
        };
    }
    class MyThread implements Runnable
    {

        @Override
        public void run() {

            for (int i=0;i<100;i++)
            {
                Message message= Message.obtain();
                if (message!=null) {
                    message.arg1 = i;
                    handler.sendMessage(message);
                } try {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
