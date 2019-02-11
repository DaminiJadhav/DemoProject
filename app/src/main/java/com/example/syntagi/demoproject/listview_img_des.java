package com.example.syntagi.demoproject;

import android.content.Context;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class listview_img_des extends AppCompatActivity {
 ListView lv;
    String [] memetitle;
 String [] memedescription;
 int[] images={R.drawable.home,R.drawable.index,R.drawable.index2,R.drawable.index3,R.drawable.home,R.drawable.index,
         R.drawable.home,R.drawable.index,R.drawable.index2,R.drawable.index3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_img_des);
        Resources res=getResources();
        memetitle=res.getStringArray(R.array.titles);
        memedescription=res.getStringArray(R.array.description);
        lv=findViewById(R.id.listview);

        VivzAdapter adpater=new VivzAdapter(this,memetitle,images,memedescription);
        lv.setAdapter(adpater);
    }
    class VivzAdapter extends ArrayAdapter<String>
    {
        Context context;
        int [] images;
        String [] titlearray;
        String[] descriptionarray;
        VivzAdapter(Context c, String[] titles, int[] imgs, String[] desc )
        {

            super(c,R.layout.simple_row_img,R.id.textview,titles);
            this.context=c;
            this.images=imgs;
            this.titlearray=titles;
           this.descriptionarray=desc;
        }
        public View getView(int position, View convertview, ViewGroup parent)
        {
            View row=convertview;
            if(row==null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.simple_row_img, parent, false);
            }
            ImageView myimg=(ImageView) row.findViewById(R.id.imageview);
            TextView myiv=(TextView) row.findViewById(R.id.title);
            TextView myiv2=(TextView) row.findViewById(R.id.description);
            myimg.setImageResource(images[position]);
            myiv.setText(titlearray[position]);
            myiv2.setText(descriptionarray[position]);
            return row;
        }
    }
}
