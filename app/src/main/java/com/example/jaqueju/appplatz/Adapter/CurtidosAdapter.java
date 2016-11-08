package com.example.jaqueju.appplatz.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaqueju.appplatz.Activity.EventosEspecificosActivity;
import com.example.jaqueju.appplatz.Model.Categoria;
import com.example.jaqueju.appplatz.Model.Curtida;
import com.example.jaqueju.appplatz.Model.CurtidaCadastro;
import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.Model.Usuario;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;
import com.example.jaqueju.appplatz.Util.ResponseCallback;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 15153766 on 03/11/2016.
 */

public class CurtidosAdapter extends BaseAdapter {
    private OkHttpClient client = new OkHttpClient();
    private Gson gson = new Gson();
    private ArrayList<Evento> eventos;
    private Context context;

    public CurtidosAdapter(Context context, ArrayList<Evento> results) {
        this.eventos = results;
        this.context = context;
    }

    @Override
    public int getCount() {
        return eventos.size();
    }

    @Override
    public Object getItem(int position) {
        return eventos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        System.out.println("Adapter da view: " + position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_curtidos, null);
        }

        final Evento evento = eventos.get(position);

        ImageView imagemEvento = (ImageView) convertView.findViewById(R.id.imgEventoCurtido);
        new DownloadImageBitmapAsyncTask(imagemEvento).execute(WebClientUtil.WEBSERVICE + "/evento/imagemCapa/" + evento.getId());

        TextView nomeEvento = (TextView) convertView.findViewById(R.id.nomeEventoCurtido);
        nomeEvento.setText(evento.getNome());

        TextView categoriaEvento = (TextView) convertView.findViewById(R.id.categoriaEventoCurtidos);

        String categorias = "";

        for (Categoria categoria : evento.getCategorias()) {
            categorias += categoria.getNome() + " ";
        }

        categoriaEvento.setText(categorias);

        imagemEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EventosEspecificosActivity.class);
                intent.putExtra("id", evento.getId());
                context.startActivity(intent);
            }
        });

        CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBoxCurtido);

        checkBox.setActivated(true);

        if (checkBox.isActivated()) {

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("Conta", 0);
                    String idConta = sharedPreferences.getString("idConta", "");

                    buscarPeloId(idConta, new ResponseCallback<Usuario>() {
                        @Override
                        public void onSuccess(Usuario usuario) {

                            descurtirEvento(usuario.getId(), evento.getId(), new ResponseCallback<Boolean>() {
                                @Override
                                public void onSuccess(Boolean ok) {

                                    if (ok) {
                                        System.out.println("Descurtiu");
                                    } else {
                                        System.out.println("Não Descurtiu");
                                    }

                                }
                            });
                        }
                    });

                }
            });
        }

        return convertView;
    }

    public void curtirEvento(String idUsuario, String idEvento, final ResponseCallback<Evento> callback) {

        RequestBody requestBody = RequestBody.create(WebClientUtil.JSON_MEDIA_TYPE, gson.toJson(new CurtidaCadastro(idEvento, idUsuario)));

        Request request = new Request.Builder().post(requestBody).url(WebClientUtil.WEBSERVICE + "/curtir").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("==============================> Erro ao Fazer Request na Consulta de Categorias");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                try {
                    Curtida curtida = gson.fromJson(json, Curtida.class);
                    Evento evento = curtida.getEvento();

                    callback.onSuccess(evento);

                } catch (Exception e) {
                    callback.onSuccess(null);
                }

            }
        });

    }

    public void descurtirEvento(String idUsuario, String idEvento, final ResponseCallback<Boolean> callback) {

        SharedPreferences sharedPreferences = context.getSharedPreferences("Conta", 0);
        String token = sharedPreferences.getString("token", "");
        System.out.println(token);
        Request request = new Request.Builder().delete().url(WebClientUtil.WEBSERVICE + "/descurtir/" + idUsuario + "/" + idEvento + "/").addHeader("Authorization", token).build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callback.onSuccess(false);
                System.out.println("==============================> Erro ao Fazer Request na Consulta de Categorias");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.code());
                callback.onSuccess(true);
            }
        });

    }

    public void buscarPeloId(String id, final ResponseCallback<Usuario> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/usuario/conta/" + id).build();

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

                    //Fazer algo se a resposta for válida
                    String json = response.body().string();

                    Usuario usuario = gson.fromJson(json, Usuario.class);

//                    System.out.println(ev.getNome());
//                    System.out.println(ev.getDetalhes());

                    callback.onSuccess(usuario);

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Usuário pela Conta");
                    throw new IOException("Erro");
                }
            }
        });
    }

}
