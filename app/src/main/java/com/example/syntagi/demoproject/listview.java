package com.example.syntagi.demoproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class listview extends AppCompatActivity  implements AdapterView.OnItemClickListener {

    ListView lv;
    String [] day={"Sunday","Monday","Thesday","Wednesday","Thusday","Friday","Saturday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv=findViewById(R.id.listview);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,day);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        TextView temp= (TextView) view;
        Toast.makeText(this,temp.getText()+""+position, Toast.LENGTH_SHORT).show();

    }
}
