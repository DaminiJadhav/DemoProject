package com.example.syntagi.demoproject;

import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Looper_EX extends AppCompatActivity {

    Button btn;
    MyThread myThread;
       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_looper__ex);
        btn=findViewById(R.id.send_but);


         myThread=new MyThread();
        myThread.run();


       }
    public void sendMessage(View view)
    {
        myThread.handler.post(new Runnable() {
            @Override
            public void run() {
                Log.d("Theread",Thread.currentThread().getName());
                L.m(Thread.currentThread().getName());
            }
        });

    }
    class MyThread implements Runnable {
        Handler handler;
        public MyThread(){


        }
           @Override
        public void run() {
//               Looper.prepare();
               handler=new Handler();
//               Looper.loop();
        }
    }

}
