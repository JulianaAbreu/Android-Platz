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
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;

import java.util.ArrayList;

/**
 * Created by 15153766 on 19/10/2016.
 */

public class EventosHomeAdapter extends BaseAdapter {

    ArrayList<Evento> eventos = new ArrayList<>();
    Context context;

    public EventosHomeAdapter(Context context, ArrayList<Evento> results){
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

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_template, null);
        }

        final Evento evento = eventos.get(position);

        ImageView imagemEvento = (ImageView) convertView.findViewById(R.id.imagem_evento);
        new DownloadImageBitmapAsyncTask(imagemEvento).execute(evento.getImagemCapa());

        TextView nomeEvento = (TextView) convertView.findViewById(R.id.txt_game_name);
        nomeEvento.setText(evento.getNome());

        TextView dataEvento = (TextView) convertView.findViewById(R.id.txt_relase_date);
        dataEvento.setText(evento.getDataInicio());

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
