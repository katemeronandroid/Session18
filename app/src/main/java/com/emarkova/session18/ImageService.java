package com.emarkova.session18;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.emarkova.session18.data.api.APIHelper;
import com.emarkova.session18.data.api.RetrofitHelper;
import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.data.model.ImageList;

import java.util.List;

public class ImageService extends IntentService {
    private static final long TIMEOUT = 1000;
    private static final String KEY = "image";
    private static final  String FILTER = "emarkova.GET_IMAGE";

    public ImageService() {
        super("Image");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        APIHelper apiHelper = new APIHelper(new RetrofitHelper());
        apiHelper.getListOfImages();
        Log.d("Logs", "null");
        while (apiHelper.getGallery() == null){
            try {
                Thread.sleep(TIMEOUT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d("Logs", "not null");
        Bundle bundle = new Bundle();
        ImageList imageList = apiHelper.getGallery();
        bundle.putSerializable(KEY, imageList);
        Intent broadcastIntent = new Intent(FILTER);
        broadcastIntent.putExtra(KEY, bundle);
        sendBroadcast(broadcastIntent);
        Log.d("Logs", "sent");
    }
}
