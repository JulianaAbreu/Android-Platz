package com.example.jaqueju.appplatz.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by 15153818 on 09/09/2016.
 */
public class CategoriasAdapterHome {
    private Context context;
    private String[] categorias = {"Esporte", "Festivais", "Educação", "Lazer", "Culinária", "Cultura", "Diversão", "Gratuitos", "Exposição"};

    public CategoriasAdapterHome(Context context) {
        this.context = context;
    }

    public int getCount() {
        return 9;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tv;
        if (convertView == null) {
            tv = new TextView(context);
            tv.setLayoutParams(new GridView.LayoutParams(85, 85));
        } else {
            tv = (TextView) convertView;
        }

        tv.setText(categorias[position]);
        return tv;
    }

}
