package com.example.jaqueju.appplatz.Fragment;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Activity.ListaCategoriasActivity;
import com.example.jaqueju.appplatz.ImageAdapterCategoriasHome;
import com.example.jaqueju.appplatz.Model.CardViewModelEventos;
import com.example.jaqueju.appplatz.Activity.EventosEspecificosActivity;
import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    String[] descricaoEvento = {"Esporte",
            "Esporte",
            "Esporte",
            "Esporte",
            "Esporte",
            "Esporte"

    };

    ArrayList<CardViewModelEventos> listitems = new ArrayList<CardViewModelEventos>();
    RecyclerView recList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupListItems();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cardrecycler, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapterCategoriasHome(getActivity()));

        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.cardList);
        recList.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        if (listitems.size() > 0 & recList != null) {
            recList.setAdapter(new MyAdapter(listitems));
        }

        recList.setLayoutManager(llm);



        /*
        final Button btnCategorias = (Button)rootView.findViewById(R.id.btnCategorias);
        btnCategorias.setOnClickListener(this);




        btnCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnCategorias.setBackgroundResource(R.drawable.style_clicked_all_categories);
                Intent i = new Intent(getActivity(), ListaCategoriasActivity.class);
                startActivity(i);

                // Log.d("Test","Testando");
                //Toast.makeText(getActivity().getApplicationContext(), "Test",        Toast.LENGTH_LONG).show();

            }});
*/
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCategorias:
                Intent i = new Intent(getActivity(), ListaCategoriasActivity.class);
                startActivity(i);
                break;
            case R.id.image_card_cover:
                Intent i2 = new Intent(getActivity(), EventosEspecificosActivity.class);
                startActivity(i2);
                break;
        }
    }

    //A ViewHolder descreve uma tela de item e metadados sobre seu lugar dentro da RecyclerView.
    public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
        private ArrayList<CardViewModelEventos> list;

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(ArrayList<CardViewModelEventos> myDataset) {
            list = myDataset;
        }


        // Create new views (invoked by the layout manager)
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.recycle_items, parent, false);
            // set the view's size, margins, paddings and layout parameters

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            Drawable dr = getResources().getDrawable(list.get(position).getImageResourceId());


        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return list.size();
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View v) {
            super(v);
        }
    }

    //Lista de Eventos abaixo
    public void setupListItems() {
        listitems.clear();

        CardViewModelEventos item1 = new CardViewModelEventos();
        item1.setCardName("Festival das Luzes");
        item1.setImageResourceId(R.drawable.evento);
        item1.setIsfav(0);
        item1.setIsturned(0);
        listitems.add(item1);

        CardViewModelEventos item2 = new CardViewModelEventos();
        item2.setCardName("Festival das Luzes");
        item2.setImageResourceId(R.drawable.evento);
        item2.setIsfav(0);
        item2.setIsturned(0);
        listitems.add(item2);

        /*CardViewModel item3 = new CardViewModel();
        item3.setCardName("Cart Item");
        item3.setImageResourceId(R.drawable.fc_tab_bg_new);
        item3.setIsfav(0);
        item3.setIsturned(0);
        listitems.add(item3);*/

        CardViewModelEventos item4 = new CardViewModelEventos();
        item4.setCardName("Festival das Luzes");
        item4.setImageResourceId(R.drawable.ctg_conference);
        item4.setIsfav(0);
        item4.setIsturned(0);
        listitems.add(item4);
    }

    public static Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        final Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmap;
    }

    private int getThemePrimaryColor() {
        final TypedValue typedValue = new TypedValue();
        getActivity().getTheme().resolveAttribute(R.attr.colorPrimary, typedValue, true);
        int[] attribute = new int[]{R.attr.colorPrimary};
        final TypedArray array = getActivity().obtainStyledAttributes(typedValue.resourceId, attribute);
        return array.getColor(0, Color.MAGENTA);
    }


}