package com.example.jaqueju.appplatz.Activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Adapter.CustomCategoriasAdapter;
import com.example.jaqueju.appplatz.R;

/**
 * Created by 15153818 on 31/08/2016.
 */


public class ListaCategoriasActivity extends AppCompatActivity {
    ListView listView;
    private TextView tvDescription;

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
            R.drawable.ctg_lazer,
            R.drawable.ctg_religiao,
            R.drawable.ctg_workshop,
            R.drawable.ctg_teatro,
            R.drawable.ctg_festival,
            R.drawable.ctg_gastronomia,
            R.drawable.ctg_conference
    };


    private Toolbar toolbar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);


        CustomCategoriasAdapter adapter = new CustomCategoriasAdapter(ListaCategoriasActivity.this, categorias, imagesid);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int indice, long l) {
                System.out.println("clicou no botao ");

            }
        });

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return true;
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }


    @Override
    public void onBackPressed() {
        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP ){
            TransitionManager.beginDelayedTransition(toolbar, new Slide());
            tvDescription.setVisibility( View.INVISIBLE );
        }

        super.onBackPressed();
    }


}
