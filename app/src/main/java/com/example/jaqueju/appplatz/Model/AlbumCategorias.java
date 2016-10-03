package com.example.jaqueju.appplatz.Model;

/**
 * Created by 15153818 on 28/09/2016.
 */
public class AlbumCategorias {
    private int mId;
    private int mAlbumArt;
    private String mTitle;
    private String mArtistName;
    private String mReleaseYear;
    private String[] mSongTitles;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public int getmAlbumArt() {
        return mAlbumArt;
    }

    public void setmAlbumArt(int mAlbumArt) {
        this.mAlbumArt = mAlbumArt;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmArtistName() {
        return mArtistName;
    }

    public void setmArtistName(String mArtistName) {
        this.mArtistName = mArtistName;
    }

    public String getmReleaseYear() {
        return mReleaseYear;
    }

    public void setmReleaseYear(String mReleaseYear) {
        this.mReleaseYear = mReleaseYear;
    }

    public String[] getmSongTitles() {
        return mSongTitles;
    }

    public void setmSongTitles(String[] mSongTitles) {
        this.mSongTitles = mSongTitles;
    }
    public AlbumCategorias(int mId,int mAlbumArt,String mTitle,String mArtistName,String mReleaseYear,String[] mSongTitles ){
        this.mId = mId;
        this.mAlbumArt = mAlbumArt;
        this.mArtistName= mArtistName;
        this.mTitle = mTitle;
        this.mReleaseYear = mReleaseYear;
        this.mSongTitles = mSongTitles;

    }
}
