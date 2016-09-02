package com.example.jaqueju.appplatz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 15153818 on 02/09/2016.
 */
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

