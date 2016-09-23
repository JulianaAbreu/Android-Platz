package com.example.jaqueju.appplatz;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 15153818 on 20/09/2016.
 */
public class RecyclerViewHolders extends RecyclerView.ViewHolder  implements View.OnClickListener {
    public TextView nomeEvento;
    public ImageView imagemEvento;

    public RecyclerViewHolders(View itemView){
        super(itemView);

        nomeEvento = (TextView) itemView.findViewById(R.id.country_name);
        imagemEvento = (ImageView) itemView.findViewById(R.id.country_photo);

    }
    @Override
    public void onClick(View view){
        Toast.makeText(view.getContext(),"Clicou na imagem de posição: " + getPosition(),Toast.LENGTH_SHORT).show();

    }
}
