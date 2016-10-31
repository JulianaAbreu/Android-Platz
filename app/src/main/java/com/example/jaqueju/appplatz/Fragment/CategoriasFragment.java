package com.example.jaqueju.appplatz.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Adapter.CategoriasCustomAdapter;
import com.example.jaqueju.appplatz.Model.Categoria;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.ResponseCallback;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

    public CategoriasFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_grid_categorias, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("A Activity foi criada");

        listarTodos(new ResponseCallback<ArrayList<Categoria>>() {
            @Override
            public void onSuccess(ArrayList<Categoria> categorias) {
                final ArrayList<Categoria> listaDeCategorias = categorias;

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        GridView categoriasGridView = (GridView) getActivity().findViewById(R.id.gridview);
                        categoriasGridView.setAdapter(new CategoriasCustomAdapter(getContext(), listaDeCategorias));
                    }
                });

            }
        });

    }

    public void listarTodos(final ResponseCallback<ArrayList<Categoria>> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/categorias/naoExcluidas").build();
        final ArrayList<Categoria> listaCategorias = new ArrayList<>();

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
                    System.out.println("==============================> Retornou uma Response Válida na Consulta de Categorias");

                    //Fazer algo se a resposta for válida
                    String json = response.body().string();

                    Categoria[] matrizCategorias = gson.fromJson(json, Categoria[].class);
                    Collections.addAll(listaCategorias, matrizCategorias);

                    System.out.println("Na Response " + Arrays.toString(listaCategorias.toArray()));

                    callback.onSuccess(listaCategorias);

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Categorias");
                    throw new IOException("Erro");
                }
            }
        });
    }
}

