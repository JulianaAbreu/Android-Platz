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

import com.example.jaqueju.appplatz.Activity.EventosEspecificosActivity;
import com.example.jaqueju.appplatz.Model.Categoria;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;
import com.example.jaqueju.appplatz.Util.WebClientUtil;

import java.util.ArrayList;

/**
 * Created by 15153766 on 03/11/2016.
 */

public class CurtidosAdapter extends BaseAdapter {

    ArrayList<Evento> eventos;
    Context context;

    public CurtidosAdapter(Context context, ArrayList<Evento> results) {
        this.eventos = results;
        this.context = context;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        System.out.println("Adapter da view: " + position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_curtidos, null);
        }

        final Evento evento = eventos.get(position);

        ImageView imagemEvento = (ImageView) convertView.findViewById(R.id.imgEventoCurtido);
        new DownloadImageBitmapAsyncTask(imagemEvento).execute(WebClientUtil.WEBSERVICE + "/evento/imagemCapa/" + evento.getId());

        TextView nomeEvento = (TextView) convertView.findViewById(R.id.nomeEventoCurtido);
        nomeEvento.setText(evento.getNome());

        TextView categoriaEvento = (TextView) convertView.findViewById(R.id.categoriaEventoCurtidos);

        String categorias = "";

        for (Categoria categoria : evento.getCategorias()) {
            categorias += categoria.getNome() + " ";
        }

        categoriaEvento.setText(categorias);

        imagemEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventosEspecificosActivity.class);
                intent.putExtra("id", evento.getId());
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
