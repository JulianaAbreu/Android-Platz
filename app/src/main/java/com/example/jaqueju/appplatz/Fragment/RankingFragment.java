package com.example.jaqueju.appplatz.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.jaqueju.appplatz.Adapter.RankingAdapter;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.ResponseCallback;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingFragment extends Fragment {

    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private ListView listaEventos;

    public RankingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ranking_categorias, container, false);
        listaEventos = (ListView) rootView.findViewById(R.id.listaEventosDestaque);

        return rootView;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        listarEventos(new ResponseCallback<ArrayList<Evento>>() {
            @Override
            public void onSuccess(final ArrayList<Evento> eventos) {

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listaEventos.setAdapter(new RankingAdapter(getContext(),eventos));
                    }
                });

            }
        });

        super.onActivityCreated(savedInstanceState);
    }

    public void listarEventos(final ResponseCallback<ArrayList<Evento>> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/eventos/top/10").build();
        final ArrayList<Evento> listaDeEventos = new ArrayList<>();

        client.newCall(request).enqueue(new Callback() {
            //Caso de erro
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("==============================> Erro ao Fazer Request na Consulta de Eventos Home");
                e.printStackTrace();
            }

            //Se retornar algo
            @Override
            public void onResponse(Call call, Response response) throws IOException {


                //Se a resposta for válida
                if (response.isSuccessful()) {
                    System.out.println("==============================> Retornou uma Response Válida na Consulta de Eventos Home");

                    //Fazer algo se a resposta for válida
                    String json = response.body().string();

                    Evento[] matrizEventos = gson.fromJson(json, Evento[].class);
                    Collections.addAll(listaDeEventos, matrizEventos);

                    callback.onSuccess(listaDeEventos);

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Eventos Home");
                    throw new IOException("Erro");
                }
            }
        });
    }

}
