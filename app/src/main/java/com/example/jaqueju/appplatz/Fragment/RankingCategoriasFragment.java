package com.example.jaqueju.appplatz.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RankingCategoriasFragment extends android.support.v4.app.ListFragment {

    String [] posicao = new String[]{"#1","#2","#3","#4","#5","#6"};
    String[] nomeEventoDestaque = new String[]{"Conferência", "Bienal do Livro",
            "Festival do Churros", "Culinária", "Teatro", "Show Nando Reis"};
    int  imagemEventoDestaque [] = new int[] {R.drawable.evento, R.drawable.evento, R.drawable.evento, R.drawable.evento, R.drawable.evento, R.drawable.evento};

    public RankingCategoriasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view_root = inflater.inflate(R.layout.fragment_ranking_categorias, container, false);
        // Inflate the layout for this fragment
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < nomeEventoDestaque.length; i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("posicao", posicao[i]);
            map.put("nomeEventoDestaque", nomeEventoDestaque[i]);
            map.put("imagemEventoDestaque", Integer.toString(imagemEventoDestaque[i]));
            aList.add(map);
        }

        // Keys used in Hashmap
        String[] from = {"posicao","imagemEventoDestaque", "nomeEventoDestaque"};

        // Ids of views in listview_layout
        int[] to = {R.id.posicao,R.id.imagemEventoDestaque, R.id.nomeEventoDestaque};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity()
                .getBaseContext(), aList, R.layout.lista_eventos_destaque, from, to);

        setListAdapter(adapter);


        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
