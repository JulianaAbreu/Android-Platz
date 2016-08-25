package com.example.jaqueju.appplatz.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TabHost;

import com.example.jaqueju.appplatz.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class PerfilFragment extends Fragment {
    private FragmentTabHost mTabHost;



    public PerfilFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_perfil, container, false);

        mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        mTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);

        mTabHost.addTab(mTabHost.newTabSpec("Curtidos").setIndicator("Curtidos"), Curtidos.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("EventosMarcados").setIndicator("EU vou!"), EventosMarcados.class, null);

        return rootView;
    }





}
