package com.example.jaqueju.appplatz.Fragment;


import android.content.Intent;
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
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.jaqueju.appplatz.ImagesAdapter;
import com.example.jaqueju.appplatz.ListaCategorias;
import com.example.jaqueju.appplatz.LoginActivity;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.RegisterActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    String [] items;
    ArrayList<String> listItems;
    ArrayAdapter<String> adapter;
    Button btncategorias;



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
        final Button btnCategorias = (Button)view.findViewById(R.id.btnCategorias);

        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCategorias.setBackgroundResource(R.drawable.style_clicked_all_categories);
                Intent i = new Intent(getActivity(), ListaCategorias.class);
                startActivity(i);

               // Log.d("Test","Testando");
                //Toast.makeText(getActivity().getApplicationContext(), "Test",        Toast.LENGTH_LONG).show();

            }
        });
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