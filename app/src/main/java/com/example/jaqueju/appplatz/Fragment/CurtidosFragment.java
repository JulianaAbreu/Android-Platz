package com.example.jaqueju.appplatz.Fragment;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.jaqueju.appplatz.Adapter.CurtidosAdapter;
import com.example.jaqueju.appplatz.Model.Curtidos;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.Model.Usuario;
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

public class CurtidosFragment extends Fragment {

    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_curtidos, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Conta", 0);

        String idConta = sharedPreferences.getString("idConta", "");

        buscarUsuarioPelaConta(idConta, new ResponseCallback<Usuario>() {
            @Override
            public void onSuccess(Usuario usuario) {

                listarEventosCurdidos(usuario.getId(), new ResponseCallback<ArrayList<Evento>>() {
                    @Override
                    public void onSuccess(final ArrayList<Evento> eventos) {

                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                listView = (ListView) getActivity().findViewById(R.id.listaEventosCurtidos);
                                listView.setAdapter(new CurtidosAdapter(getContext(), eventos));

                            }
                        });

                    }
                });


            }
        });


    }


    public void buscarUsuarioPelaConta(String idConta, final ResponseCallback<Usuario> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/usuario/conta/" + idConta).build();
        client.newCall(request).enqueue(new Callback() {
            //Caso de erro
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("==============================> Erro ao Fazer Request na Consulta de Usuário Pela Conta");
                e.printStackTrace();
            }

            //Se retornar algo
            @Override
            public void onResponse(Call call, Response response) throws IOException {


                //Se a resposta for válida
                if (response.isSuccessful()) {
                    System.out.println("==============================> Retornou uma Response Válida na Consulta de Usuário Pela Conta");

                    //Fazer algo se a resposta for válida
                    String json = response.body().string();

                    try {
                        Usuario usuario = gson.fromJson(json, Usuario.class);
                        callback.onSuccess(usuario);

                    } catch (Exception e) {
                        callback.onSuccess(null);
                    }

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Usuário Pela Conta");
                    throw new IOException("Erro");
                }
            }
        });
    }


    public void listarEventosCurdidos(String idUsuario, final ResponseCallback<ArrayList<Evento>> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/curtidas/usuario/" + idUsuario).build();
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

                    try {
                        Curtidos[] matrizCurtidos = gson.fromJson(json, Curtidos[].class);
                        Evento[] matrizEventos = new Evento[matrizCurtidos.length];

                        for (int i = 0; i < matrizCurtidos.length; i++) {
                            matrizEventos[i] = matrizCurtidos[i].getEvento();
                        }

                        Collections.addAll(listaDeEventos, matrizEventos);

                        callback.onSuccess(listaDeEventos);
                    } catch (Exception e) {
                        callback.onSuccess(null);
                    }

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Eventos Home");
                    throw new IOException("Erro");
                }
            }
        });
    }

}


