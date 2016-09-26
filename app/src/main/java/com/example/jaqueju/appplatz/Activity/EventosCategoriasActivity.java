package com.example.jaqueju.appplatz.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.jaqueju.appplatz.Adapter.EventosCategoriaAdapter;
import com.example.jaqueju.appplatz.R;

public class EventosCategoriasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_categorias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


            ListView gameList;
        //Array contendo o nome dos Eventos
            String games_arr[] = {
                    "Festival das Luzes",
                    "Festival das Luzes",
                    "Festival das Luzes",
                    "Festival das Luzes",
                    "Festival das Luzes",
                    "Festival das Luzes",
                    "Festival das Luzes",
                    "Festival das Luzes"
            };

            gameList = (ListView) findViewById(R.id.listView);
        //Cria uma instância de CategoriaAdapter
            EventosCategoriaAdapter adapter = new EventosCategoriaAdapter(EventosCategoriasActivity.this,R.layout.list_item_template,games_arr);
            gameList.setAdapter(adapter);


    }

}


