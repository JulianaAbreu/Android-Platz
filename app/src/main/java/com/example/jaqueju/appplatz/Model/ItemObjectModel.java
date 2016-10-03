package com.example.jaqueju.appplatz.Model;

/**
 * Created by 15153818 on 29/09/2016.
 */
public class ItemObjectModel {
    private int screenShot;
    private String musicName;

    public ItemObjectModel(int screenShot, String musicName) {
        this.setScreenShot(screenShot);
        this.setMusicName(musicName);
    }

    public int getScreenShot() {
        return screenShot;
    }

    public void setScreenShot(int screenShot) {
        this.screenShot = screenShot;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

}

