package com.example.jaqueju.appplatz;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by 15153818 on 31/08/2016.
 */


public class ListaCategorias extends Activity {
    ListView listView;

    String[] categorias = {
            "Esporte",
            "Música",
            "Lazer",
            "Religião",
            "Workshop",
            "Teatro",
            "Festival",
            "Gastronomia",
            "Conferencia"
    };
    Integer[] imagesid = {
            R.drawable.teste_sporte,
            R.drawable.music_ctg,
            R.drawable.lazer_ctg,
            R.drawable.religiao_ctg,
            R.drawable.workshop_ctg,
            R.drawable.teatro_ctg,
            R.drawable.festival_ctg,
            R.drawable.gastronomia_ctg,
            R.drawable.conference_ctg
    };


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);

        CustomCategoriasAdapter adapter = new CustomCategoriasAdapter(ListaCategorias.this, categorias, imagesid);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {
                System.out.println("clicou no botao ");
            }
        });


    }


}
