package com.example.jaqueju.appplatz;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by JaqueJu on 24/09/2016.
 */
public class ImageAdapterCategoriasHome extends BaseAdapter {
    private Context context;

    public ImageAdapterCategoriasHome(Context c){
        context=c;
    }
    public int getCount(){
        return mThumbIds.length;
    }
    public Object getItem(int position){
        return null;
    }
    public long getItemId(int position){
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        ImageView imageView;
        if(convertView==null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(120, 120));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0,0,0,0);

        } else {
            imageView = (ImageView) convertView;
        }
        // Set images into ImageView
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // References to our images in res > drawable
    public Integer[] mThumbIds = {R.drawable.ctg_cultura,R.drawable.ctg_religiao,
            R.drawable.ctg_festival, R.drawable.ctg_cultura,R.drawable.ctg_gastronomia , R.drawable.ctg_esporte_teste
            };
}
