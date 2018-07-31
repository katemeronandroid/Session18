package com.emarkova.session18.recycler.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import com.emarkova.session18.R;

public class HttpViewHolder extends RecyclerView.ViewHolder {
    private ImageView hpptImageView;

    public HttpViewHolder(@NonNull View itemView) {
        super(itemView);
        hpptImageView = itemView.findViewById(R.id.image_view);
    }

    public void setHpptImageView(ImageView hpptImageView) {
        this.hpptImageView = hpptImageView;
    }

    public ImageView getHpptImageView() {
        return hpptImageView;
    }
}
