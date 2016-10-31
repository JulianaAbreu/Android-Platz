package com.example.jaqueju.appplatz.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.example.jaqueju.appplatz.Adapter.EventosCategoriaAdapter;
import com.example.jaqueju.appplatz.Model.Categoria;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class EventosCategoriasActivity extends AppCompatActivity {

    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();
    ListView eventosListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_eventos_categorias);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        eventosListView = (ListView) findViewById(R.id.listaEventosCategoria);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String id = (String) bundle.get("id");
        ArrayList<Evento> listaDeEventos = buscarPorCategoria(id);

        //Cria uma instância de CategoriaAdapter
        eventosListView.setAdapter(new EventosCategoriaAdapter(this, listaDeEventos));

    }

    public ArrayList<Evento> buscarPorCategoria(String id) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/eventos/categoria/" + id).build();
        final ArrayList<Evento> listaDeEventos = new ArrayList<>();

        client.newCall(request).enqueue(new Callback() {
            //Caso de erro
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("==============================> Erro ao Fazer Request na Consulta de Categorias");
                e.printStackTrace();
            }

            //Se retornar algo
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //Se a resposta for válida
                if (response.isSuccessful()) {
                    System.out.println("==============================> Retornou uma Response Válida na Consulta de Eventos por Categorias");

                    //Fazer algo se a resposta for válida
                    String json = response.body().string();

                    Evento[] matrizEventos = gson.fromJson(json, Evento[].class);
                    Collections.addAll(listaDeEventos, matrizEventos);

                    for(Evento e : listaDeEventos){
                        System.out.println(e.getNome());
                        System.out.println(e.getEmpresa().getCnpj());
                    }

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Eventos por Categorias");
                    throw new IOException("Erro");
                }
            }
        });

        System.out.println("Perto do Return" + Arrays.toString(listaDeEventos.toArray()));

        return listaDeEventos;
    }
}


