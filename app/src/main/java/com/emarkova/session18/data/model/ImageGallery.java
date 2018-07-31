package com.emarkova.session18.data.model;

import com.google.gson.annotations.SerializedName;

public class ImageGallery {
    @SerializedName("data")
    private Image image;

    public Image getImage() {
        return this.image;
    }
    /*private ImageList imageList;

    public ImageList getImageList() {
        return imageList;
    }

    public void setImageList(ImageList imageList) {
        this.imageList = imageList;
    }*/
}
