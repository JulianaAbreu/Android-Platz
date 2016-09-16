package com.example.jaqueju.appplatz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 15153818 on 12/09/2016.
 */
public class CustomGridCategoriasHome extends BaseAdapter {
    private Context mContext;
    private final String[] Categorias;

    public  CustomGridCategoriasHome(Context c,String[] Categorias){
        mContext =c;
        this.Categorias = Categorias;
    }
    @Override
    public int getCount(){
        return Categorias.length;
    }
    public Object getItem(int position){
    return null;
    }
    public long getItemId(int podition){
        return 0;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View gridView;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            gridView = new View(mContext);
            gridView = inflater.inflate(R.layout.fragment_home, null);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_text);
            textView.setText(Categorias[position]);
        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

}
