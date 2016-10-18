package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Activity.EventosCategoriasActivity;
import com.example.jaqueju.appplatz.Model.Categoria;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;

import java.util.ArrayList;

/**
 * Created by 15153818 on 29/09/2016.
 */
public class CategoriasCustomAdapter extends BaseAdapter {

    private ArrayList<Categoria> categorias;
    private Context context;

    public CategoriasCustomAdapter(Context context, ArrayList<Categoria> results) {
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
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.categorias_grid_item, null);
        }
        final Categoria categoria = categorias.get(position);

        TextView txtNome = (TextView) convertView.findViewById(R.id.nome_categoria);
        txtNome.setText(categoria.getNome());

        ImageView imgCategoria = (ImageView) convertView.findViewById(R.id.imagem_categoria);
        new DownloadImageBitmapAsyncTask(imgCategoria).execute(categoria.getId());

        imgCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Clicou na Imagem");
                Intent intent = new Intent(context, EventosCategoriasActivity.class);
                intent.putExtra("id", categoria.getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }

}