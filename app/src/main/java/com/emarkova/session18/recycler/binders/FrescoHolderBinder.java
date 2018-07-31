package com.emarkova.session18.recycler.binders;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.emarkova.session18.R;
import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.recycler.viewholders.FrescoViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

public class FrescoHolderBinder implements ImageHolderBinder {
    private int type;
    private Image image;

    public FrescoHolderBinder(int type, Image image){
        this.type = type;
        this.image = image;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        final FrescoViewHolder frescoViewHolder = (FrescoViewHolder)holder;
        Uri uri = Uri.parse(image.getWebformatURL());
        frescoViewHolder.frescoDraweeView.setImageURI(image.getWebformatURL());
        frescoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(frescoViewHolder.itemView.getContext(), "Fresco", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getType() {
        return type;
    }
}
