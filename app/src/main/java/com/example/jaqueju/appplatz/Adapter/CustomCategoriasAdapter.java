package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.R;

/**
 * Created by 15153818 on 31/08/2016.
 */
public class CustomCategoriasAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] descricaoEvento;
    private final Integer[] imageId;

    public CustomCategoriasAdapter(Activity context,
                                   String[] web, Integer[] imageId) {
        super(context, R.layout.list_single_ctg, web);
        this.context = context;
        this.descricaoEvento = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single_ctg, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(descricaoEvento[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }
}



