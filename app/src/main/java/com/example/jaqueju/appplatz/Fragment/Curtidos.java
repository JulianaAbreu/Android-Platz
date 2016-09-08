package com.example.jaqueju.appplatz.Fragment;


import android.app.ListActivity;
import android.os.Bundle;
import android.support.v4.app.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class Curtidos extends android.support.v4.app.ListFragment {
    String[] brandsNames = new String[] { "Conferência TED", "Bienal do Livro",
            "Festival do Churros", "Culinária", "Teatro", "Show Nando Reis" };

    int[] brandsImages = new int[] { R.drawable.religiao_ctg,
            R.drawable.conference_ctg, R.drawable.teatro_ctg,
            R.drawable.cultura_ctg, R.drawable.gastronomia_ctg, R.drawable.esporte_teste_ctg };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < brandsNames.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("brand_names", brandsNames[i]);
            map.put("brand_images", Integer.toString(brandsImages[i]));
            aList.add(map);
        }

        // Keys used in Hashmap
        String[] from = {"brand_images", "brand_names"};

        // Ids of views in listview_layout
        int[] to = { R.id.brand_image, R.id.brand_name};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity()
                .getBaseContext(), aList, R.layout.list_single_item, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}


