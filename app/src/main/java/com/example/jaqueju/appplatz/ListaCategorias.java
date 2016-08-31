package com.example.jaqueju.appplatz;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by 15153818 on 31/08/2016.
 */


public class ListaCategorias extends Activity {
    ListView listView;

    String [] categorias ={
            "Esporte",
            "Cultura",
            "Lazer",
            "Religião",
            "Workshop",
            "Palestras"
    };
    Integer [] imagesid ={
            R.drawable.icon_search,
            R.drawable.icon_search,
            R.drawable.icon_search,
            R.drawable.icon_search,
            R.drawable.icon_search,
            R.drawable.icon_search,
            R.drawable.icon_search
    };




@Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_categorias);

    CustomCategoriasAdapter adapter = new CustomCategoriasAdapter(ListaCategorias.this, categorias, imagesid);
    listView = (ListView) findViewById(R.id.list);
    listView.setAdapter(adapter);



    }
}
