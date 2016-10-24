package com.example.jaqueju.appplatz.Activity;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;
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

public class EventosEspecificosActivity extends AppCompatActivity {

    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_especificos);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String id = (String) bundle.get("id");
        buscarPeloId(id, new ResponseCallback<Evento>() {
            @Override
            public void onSuccess(final Evento evento) {

                EventosEspecificosActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ImageView imagemCapaEvento = (ImageView) findViewById(R.id.imagemEventoEspecifico);
                        new DownloadImageBitmapAsyncTask(imagemCapaEvento).execute(evento.getImagemCapa());

                        TextView nomeEvento = (TextView) findViewById(R.id.nomeEventoEspecifico);
                        nomeEvento.setText(evento.getNome());

                        //Arrumar data e hora

                        TextView detalhesEvento = (TextView) findViewById(R.id.descricaoEventoEspecifico);
                        detalhesEvento.setText(evento.getDetalhes());

                        TextView enderecoEvento = (TextView) findViewById(R.id.enderecoEventoEspecico);
                        String endereco = evento.getEndereco().getRua() + " " + evento.getEndereco().getNumero() + ", " + evento.getEndereco().getCidade().getNome() + "/" + evento.getEndereco().getCidade().getEstado().getUf();
                        enderecoEvento.setText(endereco);

                        TextView telefoneEvento = (TextView) findViewById(R.id.telefoneEventoEspecifico);
                        telefoneEvento.setText(evento.getEmpresa().getTelefone());

                        TextView precoEvento = (TextView) findViewById(R.id.precoEventoEspecifico);
                        precoEvento.setText(evento.getPreco().toString());
                    }
                });
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;

    }

    public void buscarPeloId(String id, final ResponseCallback<Evento> callback) {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/evento/" + id).build();

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

                    Evento evento = gson.fromJson(json, Evento.class);

//                    System.out.println(ev.getNome());
//                    System.out.println(ev.getDetalhes());

                    callback.onSuccess(evento);

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Eventos Home");
                    throw new IOException("Erro");
                }
            }
        });
    }

}
