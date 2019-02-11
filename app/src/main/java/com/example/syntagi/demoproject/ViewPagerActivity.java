package com.example.syntagi.demoproject;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;


public class ViewPagerActivity extends FragmentActivity {
ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        viewPager = findViewById(R.id.viewpage);
        FragmentManager fragmentManager=getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));


    }
    class MyAdapter extends FragmentPagerAdapter
    {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;

            if (i==0)
            {
                fragment=new ViewPager_a();
            }
            if (i==1)
            {
                fragment=new ViewPagerB();
            }
            if (i==2)
            {
                fragment=new ViewPagerC();
            }
            return fragment;
        }

        @Override
        public int getCount() {

            return 3;
        }

        public CharSequence getPageTitle(int position)
        {
            String title=new String();
            if(position==0)
            {
                return "Tab 1";
            }
            if(position==1)
            {
                return "Tab 2";
            }
            if(position==2)
            {
                return "Tab 3";
            }
            return null;
        }
    }

}
