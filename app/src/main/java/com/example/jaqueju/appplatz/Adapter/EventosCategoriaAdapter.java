package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.R;

/**
 * Created by 15153818 on 20/09/2016.
 */
public class EventosCategoriaAdapter extends ArrayAdapter<String> {
    private Context con;
    private int lastPosition = -1;
    ImageView imagemEvento;
    TextView nomeEvento;
    TextView dataEvento;
    TextView tv_gameplateform;

    //Array contendo o nome do Evento
    String games_arr[] = {

            "Evento",
            "Evento",
            "Evento",
            "Evento",
            "Evento",
            "Evento",
            "Evento",
            "Evento"

    };

    //Array contendo a imagem de determinado Evento
    int images_arr[] = {

            R.drawable.evento,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork,
            R.drawable.newyork
    };

    //Array cintendo as datas dos Eventos
    String releaseDate_arr[] = {

            "Coming Nov 6, 2015",
            "Coming Oct 23, 2015",
            "Coming Nov 10, 2015",
            "Coming Nov 3, 2015",
            "Coming Nov 10, 2015",
            "Coming Dec 31, 2016",
            "Coming Mar 8, 2016",
            "Coming Dec 1, 2015"
    };


    //Contrutor da classe
    public EventosCategoriaAdapter(Context context, int resource, String[] objects) {
        super(context, resource, objects);
        this.con = context;
        this.games_arr = objects;
    }

    @Override
//Pega a visão dos dados a partir de uma posição especificada
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_item_template, parent, false);

        imagemEvento = (ImageView) row.findViewById(R.id.game_image);
        imagemEvento.setImageResource(images_arr[position]);

        nomeEvento = (TextView) row.findViewById(R.id.txt_game_name);
        nomeEvento.setText(games_arr[position]);

        dataEvento = (TextView) row.findViewById(R.id.txt_relase_date);
        dataEvento.setText(releaseDate_arr[position]);

        Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        row.startAnimation(animation);
        lastPosition = position;

        return row;
    }
}

