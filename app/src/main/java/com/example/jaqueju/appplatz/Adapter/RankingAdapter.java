package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Activity.EventosEspecificosActivity;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;
import com.example.jaqueju.appplatz.Util.WebClientUtil;

import java.util.ArrayList;

/**
 * Created by 15153766 on 08/11/2016.
 */

public class RankingAdapter extends BaseAdapter {

    private ArrayList<Evento> eventos;
    private Context context;

    public RankingAdapter(Context context, ArrayList<Evento> reults){
        this.context = context;
        this.eventos = reults;
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
            convertView = inflater.inflate(R.layout.lista_eventos_destaque, null);
        }

        final Evento evento = eventos.get(position);

        ImageView imagemEvento = (ImageView) convertView.findViewById(R.id.imagemEventoDestaque);
        new DownloadImageBitmapAsyncTask(imagemEvento).execute(WebClientUtil.WEBSERVICE + "/evento/imagemCapa/" + evento.getId());

        TextView nomeEvento = (TextView) convertView.findViewById(R.id.nomeEventoDestaque);
        nomeEvento.setText(evento.getNome());


        TextView posicaoEvento = (TextView) convertView.findViewById(R.id.posicaoEventoRanking);
        String txtPosicao = "#" + (position + 1);
        posicaoEvento.setText(txtPosicao);

        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.notaEventoDestaque);
        ratingBar.setRating(evento.getMedia());

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
