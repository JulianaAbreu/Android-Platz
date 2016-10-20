package com.example.jaqueju.appplatz.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

import android.widget.ListView;

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
    ArrayList<Evento> listaDeEventos = listarTodos();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        listaDeEventos = listarTodos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_eventos_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        System.out.println("Criou a Actitvy");
        ListView listView = (ListView) getActivity().findViewById(R.id.listaEventosHome);
        listView.setAdapter(new EventosHomeAdapter(getContext(), listaDeEventos));
    }

    public ArrayList<Evento> listarTodos() {

        Request request = new Request.Builder().get().url(WebClientUtil.WEBSERVICE + "/eventos/").build();
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

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Eventos Home");
                    throw new IOException("Erro");
                }
            }
        });

        //System.out.println("Perto do Return" + Arrays.toString(listaDeEventos.toArray()));

        return listaDeEventos;
    }

    public ArrayList<Evento> buscarPeloNome(String nome) {

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

                } else {
                    //Fazer algo se a resposta for inválida
                    System.out.println("==============================> A response foi inválida na Consulta de Eventos Home");
                    throw new IOException("Erro");
                }
            }
        });

        System.out.println("Perto do Return" + Arrays.toString(listaDeEventos.toArray()));

        return listaDeEventos;
    }


}

//    ArrayList<CardViewModelEventos> listitems = new ArrayList<>();
//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setupListItems();
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//
//        View rootView = inflater.inflate(R.layout.fragment_eventos_home, container, false);
//
//        RecyclerView recList = (RecyclerView) rootView.findViewById(R.id.cardList);
//        recList.setHasFixedSize(true);
//
//        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
//        llm.setOrientation(LinearLayoutManager.VERTICAL);
//        if (listitems.size() > 0 & recList != null) {
//            recList.setAdapter(new MyAdapter(listitems));
//        }
//        recList.setLayoutManager(llm);
//
//        /*
//        final Button btnCategorias = (Button)rootView.findViewById(R.id.btnCategorias);
//        btnCategorias.setOnClickListener(this);
//
//        btnCategorias.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                btnCategorias.setBackgroundResource(R.drawable.style_clicked_all_categories);
//                Intent i = new Intent(getActivity(), ListaCategoriasActivity.class);
//                startActivity(i);
//
//                // Log.d("Test","Testando");
//                //Toast.makeText(getActivity().getApplicationContext(), "Test",        Toast.LENGTH_LONG).show();
//
//            }});
//*/
//        return rootView;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//    }
//
//    //Lista de Eventos abaixo
//    public void setupListItems() {
//        listitems.clear();
//
//        CardViewModelEventos item1 = new CardViewModelEventos();
//        item1.setCardName("Festival das Luzes");
//        item1.setImageResourceId(R.drawable.evento);
//        item1.setIsfav(0);
//        item1.setIsturned(0);
//        listitems.add(item1);
//
//        CardViewModelEventos item2 = new CardViewModelEventos();
//        item2.setCardName("Festival das Luzes");
//        item2.setImageResourceId(R.drawable.evento);
//        item2.setIsfav(0);
//        item2.setIsturned(0);
//        listitems.add(item2);
//
//        /*CardViewModel item3 = new CardViewModel();
//        item3.setCardName("Cart Item");
//        item3.setImageResourceId(R.drawable.fc_tab_bg_new);
//        item3.setIsfav(0);
//        item3.setIsturned(0);
//        listitems.add(item3);*/
//
//        CardViewModelEventos item4 = new CardViewModelEventos();
//        item4.setCardName("Festival das Luzes");
//        item4.setImageResourceId(R.drawable.ctg_conference);
//        item4.setIsfav(0);
//        item4.setIsturned(0);
//        listitems.add(item4);
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//
//        public ViewHolder(View v) {
//            super(v);
//        }
//    }
//
//    //A ViewHolder descreve uma tela de item e metadados sobre seu lugar dentro da RecyclerView.
//    public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
//        private ArrayList<CardViewModelEventos> list;
//
//        // Provide a suitable constructor (depends on the kind of dataset)
//        public MyAdapter(ArrayList<CardViewModelEventos> myDataset) {
//            list = myDataset;
//        }
//
//
//        // Create new views (invoked by the layout manager)
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent,
//                                             int viewType) {
//            // create a new view
//            View v = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.recycle_items, parent, false);
//            // set the view's size, margins, paddings and layout parameters
//
//            ViewHolder vh = new ViewHolder(v);
//            return vh;
//        }
//
//        // Replace the contents of a view (invoked by the layout manager)
//        @Override
//        public void onBindViewHolder(final ViewHolder holder, int position) {
//            // - get element from your dataset at this position
//            // - replace the contents of the view with that element
//            Drawable dr = getResources().getDrawable(list.get(position).getImageResourceId());
//
//
//        }
//
//        // Return the size of your dataset (invoked by the layout manager)
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//    }


//}