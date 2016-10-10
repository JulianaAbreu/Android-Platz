package com.example.jaqueju.appplatz.Fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.jaqueju.appplatz.Adapter.CustomAdapter;
import com.example.jaqueju.appplatz.Model.ItemObjectModel;
import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriasFragment extends Fragment {


    public CategoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View root_View = inflater.inflate(R.layout.fragment_list2, container, false);
       // gridview.setAdapter(new ImageAdapter(getActivity()));
        GridView gridview = (GridView) root_View.findViewById(R.id.gridview);

        List<ItemObjectModel> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getContext(), allItems);
        gridview.setAdapter(customAdapter);

        return root_View;
    }
    private List<ItemObjectModel> getAllItemObject() {
        List<ItemObjectModel> items = new ArrayList<>();
        items.add(new ItemObjectModel(R.drawable.ctg_cultura, "Cultura"));
        items.add(new ItemObjectModel(R.drawable.ctg_conference, "Conferência"));
        items.add(new ItemObjectModel(R.drawable.ctg_gastronomia, "Gastronomia"));
        items.add(new ItemObjectModel(R.drawable.ctg_religiao, "Religião"));
        items.add(new ItemObjectModel(R.drawable.ctg_workshop, "Workshop"));
        items.add(new ItemObjectModel(R.drawable.ctg_conference, "Conferência"));
        items.add(new ItemObjectModel(R.drawable.ctg_cultura, "Cultura"));
        items.add(new ItemObjectModel(R.drawable.ctg_gastronomia, "Gastronomia"));
        items.add(new ItemObjectModel(R.drawable.ctg_cultura, "Cultura"));
        items.add(new ItemObjectModel(R.drawable.ctg_conference, "Conferência"));
        items.add(new ItemObjectModel(R.drawable.ctg_workshop, "Workshop"));
        items.add(new ItemObjectModel(R.drawable.ctg_cultura, "Cultura"));
        return items;
    }


}

