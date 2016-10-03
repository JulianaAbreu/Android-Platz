package com.example.jaqueju.appplatz;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jaqueju.appplatz.Model.AlbumCategorias;

import java.util.ArrayList;

/**
 * Created by 15153818 on 28/09/2016.
 */
public class RecycleCardsAdapter extends RecyclerView.Adapter<RecycleCardsAdapter.CardViewHolder> {
    private ArrayList<AlbumCategorias> mAlbums;

    public static class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageHolder;
        TextView mTextTitle;
        ImageView mImageOverflow;


        public CardViewHolder(View itemView){
            super(itemView);
            this.mImageHolder = (ImageView) itemView.findViewById(R.id.image_holder);
            this.mTextTitle = (TextView) itemView.findViewById(R.id.text_title);
            this.mImageOverflow = (ImageView) itemView.findViewById(R.id.image_overflow);
        }
    }
    public RecycleCardsAdapter(ArrayList<AlbumCategorias> albums) {
        this.mAlbums = albums;
    }

    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        CardViewHolder cardViewHolder = new CardViewHolder(view);
        return cardViewHolder;
    }

    @Override
    public void onBindViewHolder(final CardViewHolder holder, final int listPosition) {
        AlbumCategorias album = mAlbums.get(listPosition);
        holder.mImageHolder.setImageResource(album.getmAlbumArt());
        holder.mTextTitle.setText(album.getmTitle());
    }

    @Override
    public int getItemCount() {
        return mAlbums.size();
    }
}


