package com.example.syntagi.demoproject;

import android.os.AsyncTask;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AsynTask_ativity extends AppCompatActivity {
ListView mylist;
String [] text={"Hello","is","what","how","get", "post","do","ex","in","id","non","and","an","a","the","welcome","nice","wonderful","good"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_asyn_task_ativity);
        mylist=findViewById(R.id.async_list);
        mylist.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,new ArrayList<String>()));
        new MyTask().execute();

    }
    class MyTask extends AsyncTask<Void,String,Void>
    {
        private ArrayAdapter<String> adapter;
        private int count=0;
        @Override
        protected void onPreExecute() {
            //super.onPreExecute();

       adapter= (ArrayAdapter<String>) mylist.getAdapter();
       setProgressBarIndeterminate(false);
       setProgressBarVisibility(true);

        }
        @Override
        protected Void doInBackground(Void... voids) {
            for (String item:text)
            {
                publishProgress(item);
              try
              {
                  Thread.sleep(200);
              }
              catch (InterruptedException e)
              {
                  e.printStackTrace();
              }
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //super.onProgressUpdate(values);
            adapter.add(values[0]);
            count++;
            setProgress((int)(((double)count/text.length)*10000));

        }

        @Override
        protected void onPostExecute(Void aVoid) {
           // super.onPostExecute(aVoid);
            setProgressBarVisibility(true);
            L.s(AsynTask_ativity.this,"All items added were successfully");

        }
    }
}
