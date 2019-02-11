package com.example.syntagi.demoproject;

import android.annotation.SuppressLint;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Navi_Dra_Ex extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private DrawerLayout drawerLayout;
    private ListView listView;
    private String[] day;
  //  private ActionBarDrawerToggle drawerListener;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi__dra__ex);
        drawerLayout = findViewById(R.id.drawerlayout);
        day = getResources().getStringArray(R.array.day);
        listView = findViewById(R.id.list_view2);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, day));
        listView.setOnItemClickListener(this);
//        drawerListener = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_launcher_background, R.string.drawer_open, R.string.drawer_close){
//            public void onDrawerClosed(View drawer)
//            {
//
//            }
//            public void onDrawerOpened(View drawer)
//            {
//
//            }
//        };



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, day[position] + "was selected", Toast.LENGTH_SHORT).show();
        selectItem(position);
    }

    public void selectItem(int position) {
        listView.setItemChecked(position, true);
        setTitle(day[position]);
    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
