package com.example.jaqueju.appplatz.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jaqueju.appplatz.Adapter.EventosHomeAdapter;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.ResponseCallback;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_eventos_home, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Criou a Activity para o Home Fragment");

        EditText editText = (EditText) getActivity().findViewById(R.id.editTextNomeEvento);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                buscarPeloNome(s.toString(), new ResponseCallback<ArrayList<Evento>>() {

                    @Override
                    public void onSuccess(ArrayList<Evento> eventos) {

                        final ArrayList<Evento> listaDeEventos = eventos;

                        getActivity().runOnUiThread(new Runnable() {

                            @Override
                            public void run() {
                                ListView listView = (ListView) getActivity().findViewById(R.id.listaEventosHome);
                                listView.setAdapter(new EventosHomeAdapter(getContext(), listaDeEventos));
                            }
                        });
                    }
                });
            }
        });

        listarEventos(new ResponseCallback<ArrayList<Evento>>() {
            @Override
            public void onSuccess(ArrayList<Evento> eventos) {

                final ArrayList<Evento> listaDeEventos = eventos;

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ListView listView = (ListView) getActivity().findViewById(R.id.listaEventosHome);
                        listView.setAdapter(new EventosHomeAdapter(getContext(), listaDeEventos));
                    }
                });
            }
        });

    }

    public void listarEventos(final ResponseCallback<ArrayList<Evento>> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/eventos/semana/").build();
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

    public void buscarPeloNome(String nome, final ResponseCallback<ArrayList<Evento>> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/eventos/" + nome).build();
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

                    for (Evento e : listaDeEventos) {
                        System.out.println(e.getNome());
                        System.out.println(e.getEmpresa().getCnpj());
                    }

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