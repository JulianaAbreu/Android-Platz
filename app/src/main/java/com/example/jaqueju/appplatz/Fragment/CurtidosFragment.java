package com.example.jaqueju.appplatz.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

public class CurtidosFragment extends android.support.v4.app.ListFragment {

    String[] nomeEvento = new String[]{"Conferência", "Bienal do Livro",
            "Festival do Churros", "Culinária", "Teatro", "Show Nando Reis"};

    int[] imagenEvento = new int[]{R.drawable.evento,
            R.drawable.evento, R.drawable.evento,
            R.drawable.evento, R.drawable.evento, R.drawable.evento};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View teste = inflater.inflate(R.layout.fragment_curtidos, container, false);

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < nomeEvento.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("brand_names", nomeEvento[i]);
            map.put("brand_images", Integer.toString(imagenEvento[i]));
            aList.add(map);
        }

        // Keys used in Hashmap
        String[] from = {"brand_images", "brand_names"};

        // Ids of views in listview_layout
        int[] to = {R.id.brand_image, R.id.brand_name};

        SimpleAdapter adapter = new SimpleAdapter(getActivity()
                .getBaseContext(), aList, R.layout.list_single_item, from, to);

        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }
}


