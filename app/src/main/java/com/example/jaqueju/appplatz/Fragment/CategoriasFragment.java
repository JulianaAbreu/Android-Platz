package com.example.jaqueju.appplatz.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import com.example.jaqueju.appplatz.Activity.EventosCategoriasActivity;
import com.example.jaqueju.appplatz.Adapter.CategoriasCustomAdapter;
import com.example.jaqueju.appplatz.Model.Categorias;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriasFragment extends Fragment {

    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();
    ArrayList<Categorias> listaCategorias = new ArrayList<>();

    public CategoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_grid_categorias, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //listaCategorias = this.listarTodos();

        listaCategorias = listarTodos();

        GridView categoriasGridView = (GridView) this.getActivity().findViewById(R.id.gridview);
        categoriasGridView.setAdapter(new CategoriasCustomAdapter(getContext(), listaCategorias));

    }

    public ArrayList<Categorias> listarTodos() {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/categorias/naoExcluidas").build();
        final ArrayList<Categorias> listaCategorias = new ArrayList<>();

        client.newCall(request).enqueue(new Callback() {
            //Caso de erro
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("================================>Erro ao Fazer Request");
                e.printStackTrace();
            }

            //Se retornar algo
            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //Se a resposta for válida
                if (response.isSuccessful()) {

                    System.out.println("==================Retornou uma Response Válida");

                    //Fazer algo se a resposta for válida
                    String json = response.body().string();

                    Categorias[] matrizCategorias = gson.fromJson(json, Categorias[].class);
                    Collections.addAll(listaCategorias, matrizCategorias);

                    for (Categorias c : listaCategorias) {
                        System.out.println("============================");
                        System.out.println(c.getNome());
                    }

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("======================================>A response foi inválida");
                    throw new IOException("Erro");
                }
            }
        });
        return listaCategorias;
    }
}

