package com.example.jaqueju.appplatz.Util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.example.jaqueju.appplatz.R;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 15153766 on 13/10/2016.
 */

public class DownloadImageBitmapAsyncTask extends AsyncTask<String, Void, Bitmap> {

    private ImageView imageView;
    private int data = 0;

    public DownloadImageBitmapAsyncTask(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        InputStream input;

        try {
            URL url = new URL(WebClientUtil.WEBSERVICE + "/categoria/imagem/" + params[0]);
            URLConnection connection = url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
        } else {
            imageView.setImageResource(R.drawable.image_placeholder);
        }

    }
}
