package com.emarkova.session18.recycler.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.emarkova.session18.R;

public class PicassoViewHolder extends RecyclerView.ViewHolder {
    private ImageView picassoImageView;

    public PicassoViewHolder(@NonNull View itemView) {
        super(itemView);
        picassoImageView = itemView.findViewById(R.id.image_view);
    }

    public ImageView getPicassoImageView() {
        return picassoImageView;
    }
}
