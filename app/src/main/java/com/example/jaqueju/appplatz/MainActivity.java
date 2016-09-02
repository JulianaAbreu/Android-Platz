package com.example.jaqueju.appplatz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.jaqueju.appplatz.Fragment.AboutFragment;
import com.example.jaqueju.appplatz.Fragment.Curtidos;
import com.example.jaqueju.appplatz.Fragment.HomeFragment;
import com.example.jaqueju.appplatz.Fragment.ListFragment;
import com.example.jaqueju.appplatz.Fragment.PerfilFragment;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);
        setIconForTabs();
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment());
        adapter.addFrag(new Curtidos());
        adapter.addFrag(new ListFragment());
        adapter.addFrag(new PerfilFragment());


        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        getSupportActionBar().setTitle("Home");
                        break;
                    case 1:
                        getSupportActionBar().setTitle("About");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("List");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Trofeis");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setIconForTabs() {

        int[] tabIcons = {
                R.mipmap.ic_list_white_,
                R.mipmap.ic_favorite_border,
                R.mipmap.ic_trofeu,
                R.mipmap.ic_profile


        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);


    }
}
