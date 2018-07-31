package com.emarkova.session18.recycler.binders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.recycler.viewholders.PicassoViewHolder;
import com.squareup.picasso.Picasso;

public class PicassoHolderBinder implements ImageHolderBinder {
    private int type;
    private Image image;

    public PicassoHolderBinder(int type, Image image){
        this.type = type;
        this.image = image;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        final PicassoViewHolder picassoViewHolder = (PicassoViewHolder) holder;
        Picasso.get().load(image.getWebformatURL()).into(picassoViewHolder.getPicassoImageView());
        picassoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(picassoViewHolder.getPicassoImageView().getContext(), "Picasso", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getType() {
        return type;
    }
}
