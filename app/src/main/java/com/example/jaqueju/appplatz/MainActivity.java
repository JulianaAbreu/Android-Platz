package com.example.jaqueju.appplatz;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.jaqueju.appplatz.Activity.LoginActivity;
import com.example.jaqueju.appplatz.Activity.MapaActivity;
import com.example.jaqueju.appplatz.Adapter.ViewPagerAdapter;
import com.example.jaqueju.appplatz.Fragment.CategoriasFragment;
import com.example.jaqueju.appplatz.Fragment.CurtidosFragment;
import com.example.jaqueju.appplatz.Fragment.HomeFragment;
import com.example.jaqueju.appplatz.Fragment.PerfilFragment;
import com.example.jaqueju.appplatz.Fragment.RankingCategoriasFragment;


public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.fab);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MapaActivity.class);
                startActivity(i);
            }
        });

/*
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapaActivity.class);
                startActivity(intent);
            }
        });
        /*
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

            }
        });
*/

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
        adapter.addFrag(new CategoriasFragment());
        adapter.addFrag(new CurtidosFragment());
        adapter.addFrag(new RankingCategoriasFragment());
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
                        getSupportActionBar().setTitle("Categorias");
                        break;
                    case 2:
                        getSupportActionBar().setTitle("Curtidos");
                        break;
                    case 3:
                        getSupportActionBar().setTitle("Troféis");
                        break;
                    case 4:
                        getSupportActionBar().setTitle("Perfil");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void setIconForTabs() {

        int[] tabIcons = {
                R.mipmap.ic_home_white__,
                R.mipmap.ic_list_white_,
                R.mipmap.ic_favorite_border,
                R.mipmap.ic_trofeu,
                R.mipmap.ic_profile


        };

        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }


}
