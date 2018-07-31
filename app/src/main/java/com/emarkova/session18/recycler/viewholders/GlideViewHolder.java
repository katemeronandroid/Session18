package com.emarkova.session18.recycler.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.emarkova.session18.R;

public class GlideViewHolder extends RecyclerView.ViewHolder {
    private ImageView glideImageView;
    public GlideViewHolder(@NonNull View itemView) {
        super(itemView);
        glideImageView = itemView.findViewById(R.id.image_view);
    }

    public ImageView getGlideImageView() {
        return glideImageView;
    }
}
