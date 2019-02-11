package com.example.syntagi.demoproject;

import android.content.Context;
import android.content.res.Resources;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class baseadapter extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baseadapter);
        list = findViewById(R.id.listview);
        list.setAdapter(new VivzAdapter(this));

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    class SingleRow

    {
        String title;
        String description;
        int image;

        SingleRow(String title, String description, int image)
        {
            this.title = title;
            this.description = description;
            this.image = image;
        }
    }

    class VivzAdapter extends BaseAdapter {

        ArrayList<SingleRow> list;
        Context context;

        VivzAdapter(Context c) {
            context = c;
            list = new ArrayList<SingleRow>();
            Resources res = getResources();
            String[] title = res.getStringArray(R.array.titles);
            String[] description = res.getStringArray(R.array.description);
            int[] img = {R.drawable.home, R.drawable.index, R.drawable.index2, R.drawable.index3, R.drawable.home, R.drawable.index,
                    R.drawable.home, R.drawable.index, R.drawable.index2, R.drawable.index3};
            for (int i = 0; i < 10; i++) {
                list.add(new SingleRow(title[i], description[i], img[i]));
            }
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView= inflater.inflate(R.layout.simple_row_img, parent, false);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            TextView description = (TextView) convertView.findViewById(R.id.description);
            ImageView image = (ImageView) convertView.findViewById(R.id.imageview);
            SingleRow temp = list.get(position);
            title.setText(temp.title);
            description.setText(temp.description);
            image.setImageResource(temp.image);
            return convertView;
        }
    }
}
