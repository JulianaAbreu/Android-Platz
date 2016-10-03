package com.example.jaqueju.appplatz;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 15153818 on 28/09/2016.
 */
public class CardViewHolder extends RecyclerView.ViewHolder {
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
