package com.example.syntagi.demoproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

public class gridview extends AppCompatActivity implements AdapterView.OnItemClickListener {

    GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gv = (GridView) findViewById(R.id.gridview);
        gv.setAdapter(new VivzAdapter(this));
        gv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, mydialog.class);
        VivzAdapter.ViewHolder holder = (VivzAdapter.ViewHolder) view.getTag();
        nature temp = (nature) holder.mynature.getTag();
        i.putExtra("natureimage", temp.imgId);
        i.putExtra("naturename", temp.naturename);
        startActivity(i);
    }

    class nature {
        int imgId;
        String naturename;

        nature(int imgId, String naturename) {
            this.imgId = imgId;
            this.naturename = naturename;
        }
    }

    class VivzAdapter extends BaseAdapter {
        Context context;
        ArrayList<nature> arrayList;

        VivzAdapter(Context context) {
            this.context = context;
            arrayList = new ArrayList<nature>();
            Resources res = context.getResources();
            String[] tempnaturename = res.getStringArray(R.array.nature_name);
            int[] naturename = {R.drawable.index, R.drawable.index4, R.drawable.index5, R.drawable.index, R.drawable.index4, R.drawable.index5, R.drawable.index, R.drawable.index4, R.drawable.index5, R.drawable.index};
            for (int i = 0; i < 10; i++) {
                nature tempnature = new nature(naturename[i], tempnaturename[i]);
                arrayList.add(tempnature);
            }
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return arrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        class ViewHolder {
            ImageView mynature;

            ViewHolder(View v) {
                mynature = v.findViewById(R.id.imageview4);
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.single_grid_item, parent, false);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            nature temp = arrayList.get(position);
            holder.mynature.setImageResource(temp.imgId);
            holder.mynature.setTag(temp);
            return convertView;
        }
    }
}
