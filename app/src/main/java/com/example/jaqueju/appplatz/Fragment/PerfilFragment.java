package com.example.jaqueju.appplatz.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jaqueju.appplatz.Model.Evento;
import com.example.jaqueju.appplatz.Model.Usuario;
import com.example.jaqueju.appplatz.R;
import com.example.jaqueju.appplatz.Util.DownloadImageBitmapAsyncTask;
import com.example.jaqueju.appplatz.Util.ResponseCallback;
import com.example.jaqueju.appplatz.Util.WebClientUtil;
import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */

public class PerfilFragment extends Fragment {

    private Button btncamera;
    private ImageView capturedImage;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private ImageView imageView;
    private FragmentTabHost mTabHost;
    final Gson gson = new Gson();
    final OkHttpClient client = new OkHttpClient();

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_perfil, container, false);

        btncamera = (Button) rootView.findViewById(R.id.btnCamera);
        capturedImage = (ImageView) rootView.findViewById(R.id.imgPerfil);

        btncamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                getActivity().startActivityFromFragment(PerfilFragment.this, cameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        //mTabHost = (FragmentTabHost)rootView.findViewById(android.R.id.tabhost);
        //   mTabHost.setup(getActivity(), getChildFragmentManager(),R.id.realtabcontent);


        // mTabHost.addTab(mTabHost.newTabSpec("Curtidos").setIndicator("Curtidos"), CurtidosFragment.class, null);
        // mTabHost.addTab(mTabHost.newTabSpec("EventosMarcados").setIndicator("EU vou!"), EventosMarcadosFragment.class, null);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {

        System.out.println("Criou a Activity do Perfil Fragment");

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("Conta", 0);

        if (sharedPreferences.contains("idConta")) {
            String idConta = sharedPreferences.getString("idConta", null);


            buscarPeloId(idConta, new ResponseCallback<Usuario>() {
                @Override
                public void onSuccess(final Usuario usuario) {

                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            ImageView imgPerfil = (ImageView) getActivity().findViewById(R.id.imgPerfil);
                            new DownloadImageBitmapAsyncTask(imgPerfil).execute(WebClientUtil.WEBSERVICE + "/usuario/imagem/" + usuario.getId());

                            TextView nomeUsuario = (TextView) getActivity().findViewById(R.id.nomeUsuario);
                            nomeUsuario.setText(usuario.getNome());

                            TextView emailUsuario = (TextView) getActivity().findViewById(R.id.emailUsuario);
                            emailUsuario.setText(usuario.getConta().getEmail());

                            TextView cidadeEstadoUsuario = (TextView) getActivity().findViewById(R.id.cidadeEstadoUsuario);
                            cidadeEstadoUsuario.setText(usuario.getEndereco().getCidade().getNome() + " / " + usuario.getEndereco().getCidade().getEstado().getUf());

                            TextView dataNascimentoUsuario = (TextView) getActivity().findViewById(R.id.dataNascimentoUsuario);
                            dataNascimentoUsuario.setText(usuario.getDataNascimento());

                        }
                    });

                }
            });

        } else {
            System.out.println("Id inexistente");
        }

        super.onActivityCreated(savedInstanceState);
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
                    System.out.println("==============================> Retornou uma Response Válida na Consulta de Usuário pela conta");

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

    private void openCamera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();

                    capturedImage.setImageBitmap(photo);

                }
            }
        } catch (Exception e) {
            Toast.makeText(this.getActivity(), e + "Something went wrong", Toast.LENGTH_LONG).show();

        }
    }


}