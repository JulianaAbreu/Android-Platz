package com.example.jaqueju.appplatz;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class EventosCategorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_categorias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


            ListView gameList;
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
            EventosCategoriaAdapter adapter = new EventosCategoriaAdapter(EventosCategorias.this,R.layout.list_item_template,games_arr);
            gameList.setAdapter(adapter);



    }

}


