package com.example.jaqueju.appplatz.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jaqueju.appplatz.R;

import java.io.ByteArrayOutputStream;

/**
 * A simple {@link Fragment} subclass.
 */

public class PerfilFragment extends Fragment {
    private Button btncamera;
    private ImageView capturedImage;
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

        btncamera = (Button) rootView.findViewById(R.id.btnCamera);
        capturedImage = (ImageView) rootView.findViewById(R.id.capturedImage);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                getActivity().startActivityFromFragment(PerfilFragment.this, cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        //mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        //   mTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);


        // mTabHost.addTab(mTabHost.newTabSpec("Curtidos").setIndicator("Curtidos"), CurtidosFragment.class, null);
        // mTabHost.addTab(mTabHost.newTabSpec("EventosMarcados").setIndicator("EU vou!"), EventosMarcadosFragment.class, null);

        return rootView;
    }

    private void openCamera() {
        Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();

                    capturedImage.setImageBitmap(photo);

                }
            }
        } catch (Exception e) {
            Toast.makeText(this.getActivity(), e+"Something went wrong", Toast.LENGTH_LONG).show();

        }
    }


}