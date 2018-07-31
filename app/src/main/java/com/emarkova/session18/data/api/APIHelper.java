package com.emarkova.session18.data.api;

import android.util.Log;

import com.emarkova.session18.data.model.ImageGallery;
import com.emarkova.session18.data.model.ImageList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class APIHelper {
    private static RetrofitHelper retrofitHelper = null;
    private static final String APIKEY = "9673269-acd48720a01b6f098da214d0f";
    private static final String PAGE = "2koKTdh";
    private ImageList gallery = null;

    public APIHelper(RetrofitHelper helper) {
        this.retrofitHelper = helper;
    }

    public void getListOfImages(){
        retrofitHelper.getServer().getListOfImage(APIKEY, "sunset", 10).enqueue(new Callback<ImageList>() {
            @Override
            public void onResponse(Call<ImageList> call, Response<ImageList> response) {
                Log.d("Logs", "response");
                gallery = response.body();
                Log.d("Logs", "response" + response.body().getImageList().size());
            }

            @Override
            public void onFailure(Call<ImageList> call, Throwable t) {

            }
        });
    }


    public ImageList getGallery() {
        return gallery;
    }
}
