package com.example.jaqueju.appplatz.Model;

import com.example.jaqueju.appplatz.R;

import java.util.ArrayList;
import java.util.List;


public class Eventos {
    String name;
    String lugar;
    int photoId;

    Eventos(String name, String lugar, int photoId){
        this.name = name;
        this.lugar = lugar;
        this.photoId = photoId;
    }
    private List<Eventos> eventosList;

private void initializeData(){
    eventosList = new ArrayList<>();
    eventosList.add(new Eventos("Festival","Santo Amaro, SP", R.drawable.evento));
    eventosList.add(new Eventos("Festival","Santo Amaro, SP", R.drawable.evento));

}
}

