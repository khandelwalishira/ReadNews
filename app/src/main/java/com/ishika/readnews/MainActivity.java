package com.ishika.readnews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,msports,mhealth,mtechnology,mentertainment,mscience;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;
    String api="7304139b90354661b9a97ecd3fc849f5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);
        mhome=findViewById(R.id.home);
        msports=findViewById(R.id.sports);
        mhealth=findViewById(R.id.health);
        mtechnology=findViewById(R.id.tech);
        mentertainment=findViewById(R.id.entertaiment);
        mscience=findViewById(R.id.science);
        ViewPager viewPager=findViewById(R.id.fragenentcontainer);
        tabLayout=findViewById(R.id.include);
        pagerAdapter=new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);
        //texttag par click karne ke baad directly move to that particular tab
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0 || tab.getPosition() == 1 || tab.getPosition() == 2 || tab.getPosition() == 3 || tab.getPosition() == 4 || tab.getPosition() == 5) {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
}