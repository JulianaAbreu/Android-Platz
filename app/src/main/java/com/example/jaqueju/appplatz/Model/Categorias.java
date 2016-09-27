package com.example.jaqueju.appplatz.Model;

import android.graphics.Bitmap;

/**
 * Created by 15153818 on 27/09/2016.
 */
public class Categorias {
    private Bitmap image;
    private String title;


    public Categorias(Bitmap image, String title){
        super();
        this.image = image;
        this.title = title;
    }
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
