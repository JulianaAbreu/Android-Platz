package com.example.jaqueju.appplatz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by JaqueJu on 24/09/2016.
 */
public class SingleItemViewCtgHome extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get the view from singleitemview.xml
        setContentView(R.layout.single_item_view);

        // Get position from intent passed from MainActivity.java
        Intent i = getIntent();

        int position = i.getExtras().getInt("id");

        // Open the Image adapter
        ImageAdapterCategoriasHome imageAdapter = new ImageAdapterCategoriasHome(this);

        // Locate the ImageView in single_item_view.xml
        ImageView imageView = (ImageView) findViewById(R.id.image);

        // Get image and position from ImageAdapter.java and set into ImageView
        imageView.setImageResource(imageAdapter.mThumbIds[position]);
    }
}
