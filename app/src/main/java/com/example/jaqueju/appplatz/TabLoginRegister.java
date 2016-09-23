package com.example.jaqueju.appplatz;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

import com.example.jaqueju.appplatz.Activity.LoginActivity;
import com.example.jaqueju.appplatz.Activity.RegisterActivity;

/**
 * Created by 15153818 on 26/08/2016.
 */
public class TabLoginRegister extends TabActivity {
    TabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_login_register);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);

        TabHost.TabSpec tab1 = tabHost.newTabSpec("First Tab");
        TabHost.TabSpec tab2 = tabHost.newTabSpec("Second Tab");

        tab1.setIndicator("Login");
        tab1.setContent(new Intent(this, LoginActivity.class));

        tab2.setIndicator("Cadastre-se");
        tab2.setContent(new Intent(this, RegisterActivity.class));

        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
    }

}
