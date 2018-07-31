package com.emarkova.session18.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Image implements Serializable {

    @SerializedName("webformatHeight")
    private int webformatHeight;

    @SerializedName("imageWidth")
    private int imageWidth;

    @SerializedName("webformatURL")
    private String webformatURL;

    @SerializedName("previewHeight")
    private int previewHeight;

    @SerializedName("previewURL")
    private String previewURL;

    @SerializedName("type")
    private String type;

    @SerializedName("imageHeight")
    private int imageHeight;

    @SerializedName("previewWidth")
    private int previewWidth;

    @SerializedName("largeImageURL")
    private String largeImageURL;

    @SerializedName("id")
    private int id;

    @SerializedName("imageSize")
    private int imageSize;

    @SerializedName("webformatWidth")
    private int webformatWidth;

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }
}
