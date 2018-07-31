package com.emarkova.session18.recycler.binders;

import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.recycler.viewholders.GlideViewHolder;

public class GlideHolderBinder implements ImageHolderBinder {
    private int type;
    private Image image;

    public GlideHolderBinder(int type, Image image){
        this.type = type;
        this.image = image;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        final GlideViewHolder glideViewHolder = (GlideViewHolder) holder;
        Glide.with(glideViewHolder.itemView).load(image.getWebformatURL()).into(glideViewHolder.getGlideImageView());
        glideViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(glideViewHolder.getGlideImageView().getContext(), "Glide", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getType() {
        return type;
    }
}
