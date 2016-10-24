package com.example.jaqueju.appplatz.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jaqueju.appplatz.MainActivity;
import com.example.jaqueju.appplatz.Model.Conta;
import com.example.jaqueju.appplatz.Model.Credenciais;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.ResponseCallback;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {

    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText txtEmail = (EditText) findViewById(R.id.loginEmail);
        final EditText txtSenha = (EditText) findViewById(R.id.loginSenha);
        final Button button = (Button) findViewById(R.id.btnLogin);

        final SharedPreferences sharedPreferences = getSharedPreferences("Conta", 0);
        final Editor editor = sharedPreferences.edit();

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString();
                String senha = txtSenha.getText().toString();

                login(email, senha, new ResponseCallback<Conta>() {
                    @Override
                    public void onSuccess(Conta conta) {
                        editor.putString("idConta", conta.getId());
                        editor.putString("perfilConta", conta.getPerfil());
                        editor.putString("tokenConta", conta.getToken());
                        editor.apply();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    public void login(String email, String senha, final ResponseCallback<Conta> callback) {

        RequestBody requestBody = RequestBody.create(WebClientUtil.JSON_MEDIA_TYPE, gson.toJson(new Credenciais(email, senha)));

        Request request = new Request.Builder().post(requestBody).url(WebClientUtil.WEBSERVICE + "/login").build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("==============================> Erro ao Fazer Request na Consulta de Categorias");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String json = response.body().string();

                Conta conta = gson.fromJson(json, Conta.class);

                callback.onSuccess(conta);

                System.out.println("Logou!!!");

            }
        });


    }


}
