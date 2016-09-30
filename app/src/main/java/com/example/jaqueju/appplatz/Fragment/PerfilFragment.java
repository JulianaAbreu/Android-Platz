package com.example.jaqueju.appplatz.Fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.jaqueju.appplatz.R;

/**
 * A simple {@link Fragment} subclass.
 */

public class PerfilFragment extends Fragment {
    Button image;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private ImageView imageView;
    private FragmentTabHost mTabHost;


    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);

        //mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        //   mTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);


        // mTabHost.addTab(mTabHost.newTabSpec("Curtidos").setIndicator("Curtidos"), CurtidosFragment.class, null);
        // mTabHost.addTab(mTabHost.newTabSpec("EventosMarcados").setIndicator("EU vou!"), EventosMarcadosFragment.class, null);

        return rootView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE && resultCode == resultCode) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);

        }
    }


}