package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Activity.EventosEspecificosActivity;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;
import com.example.jaqueju.appplatz.Util.WebClientUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15153818 on 20/09/2016.
 */
public class EventosCategoriaAdapter extends BaseAdapter {
    private ArrayList<Evento> eventos;
    private Context context;

    public EventosCategoriaAdapter(Context context, ArrayList<Evento> results) {
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
            convertView = inflater.inflate(R.layout.list_item_template, null);
        }

        final Evento evento = eventos.get(position);

        ImageView imagemEvento = (ImageView) convertView.findViewById(R.id.imagem_evento);
        new DownloadImageBitmapAsyncTask(imagemEvento).execute(WebClientUtil.WEBSERVICE + "/evento/imagemCapa/" + evento.getId());

//        WebView webView = (WebView) convertView.findViewById(R.id.webViewImgEvento);
//        webView.loadUrl(WebClientUtil.WEBSERVICE + "/evento/imagemCapa/" + evento.getId());

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

