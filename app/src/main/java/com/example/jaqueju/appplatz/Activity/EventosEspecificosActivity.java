package com.example.jaqueju.appplatz.Activity;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
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
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView imagemCapaEvento;
    private TextView dataInicioEvento;
    private TextView descricaoEvento;
    private TextView precoEvento;
    private TextView dataFimEvento;
    private TextView lotacaoMaxEvento;
    private TextView enderecoEvento;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_especificos);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        imagemCapaEvento = (ImageView) findViewById(R.id.imgCapaEvento);
        dataInicioEvento = (TextView) findViewById(R.id.dataInicioEvento);
        descricaoEvento = (TextView) findViewById(R.id.descricaoEventoEspecifico);
        precoEvento = (TextView) findViewById(R.id.precoEvento);
        dataFimEvento = (TextView) findViewById(R.id.dataFimEvento);
        lotacaoMaxEvento = (TextView) findViewById(R.id.lotacaoMaxEvento);
        enderecoEvento = (TextView) findViewById(R.id.enderecoEvento);

        setSupportActionBar(mToolbar);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(false);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final String id = (String) bundle.get("id");
        buscarPeloId(id, new ResponseCallback<Evento>() {
            @Override
            public void onSuccess(final Evento evento) {

                EventosEspecificosActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        mToolbar.setTitle(evento.getNome());
                        mCollapsingToolbarLayout.setTitle(evento.getNome());
                        new DownloadImageBitmapAsyncTask(imagemCapaEvento).execute(WebClientUtil.WEBSERVICE + "/evento/imagemCapa/" + evento.getId());
                        dataInicioEvento.setText(evento.getDataInicio());
                        descricaoEvento.setText(evento.getDetalhes());
                        if (evento.getPreco() != 0.0){
                            precoEvento.setText(String.valueOf(evento.getPreco()));
                        }else{
                            precoEvento.setText("Gratuito");
                        }
                        dataFimEvento.setText(evento.getDataFim());
                        lotacaoMaxEvento.setText(String.valueOf(evento.getLotacaoMax()));
                        enderecoEvento.setText(evento.getEndereco().getCep() + " - " + evento.getEndereco().getRua() + " " + evento.getEndereco().getCidade().getNome() + " / " +evento.getEndereco().getCidade().getEstado().getUf());
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
