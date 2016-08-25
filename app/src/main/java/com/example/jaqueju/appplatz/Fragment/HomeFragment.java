package com.example.jaqueju.appplatz.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SeekBar;

import com.example.jaqueju.appplatz.ImagesAdapter;
import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    String [] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;



    private static final String TAG = HomeFragment.class.getSimpleName();
    CardView mCardview;



    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        fragment.setRetainInstance(true);
        return fragment;
    }


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new ImagesAdapter(view.getContext()));
        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false);
    }

    /* View view = inflater.inflate(R.layout.photos_layout,container,false);
        GridView gridView = (GridView) view.findViewById(R.id.photogridview);
        gridView.setAdapter(new MyAdapter(view.getContext())); // uses the view to get the context instead of getActivity().
        return view; */

    //@Override
   // public void onViewCreated(View view, Bundle savedInstanceState) {
     //   super.onViewCreated(view, savedInstanceState);
       // mCardview = (CardView) view.findViewById(R.id.cardview);

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //}

}