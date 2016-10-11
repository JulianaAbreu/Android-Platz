package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Model.Categorias;
import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;

/**
 * Created by 15153818 on 29/09/2016.
 */
public class CategoriasCustomAdapter extends BaseAdapter {

    private ArrayList<Categorias> categorias;
    private Context context;

    public CategoriasCustomAdapter(Context context, ArrayList<Categorias> results) {
        this.categorias = results;
        this.context = context;
    }


    @Override
    public int getCount() {
        return categorias.size();
    }

    @Override
    public Object getItem(int position) {
        return categorias.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.categorias_grid_item, null);
        }

        ImageView imgCategoria = (ImageView) convertView.findViewById(R.id.imagem_categoria);
        TextView txtNome = (TextView) convertView.findViewById(R.id.nome_categoria);

        Categorias categoria = categorias.get(position);
        //Fazendo os sets nos text views
        txtNome.setText(categoria.getNome());
        imgCategoria.setImageResource(R.drawable.ctg_esporte_teste);

        return convertView;
    }

}