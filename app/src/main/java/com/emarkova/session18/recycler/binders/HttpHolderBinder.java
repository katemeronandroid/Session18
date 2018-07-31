package com.emarkova.session18.recycler.binders;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.emarkova.session18.data.model.Image;
import com.emarkova.session18.recycler.viewholders.HttpViewHolder;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHolderBinder implements ImageHolderBinder {
    private int type;
    private Image image;
    private static Bitmap bitmap = null;

    public HttpHolderBinder(int type, Image image){
        this.type = type;
        this.image = image;
    }

    @Override
    public void bindViewHolder(RecyclerView.ViewHolder holder) {
        final HttpViewHolder httpViewHolder = (HttpViewHolder)holder;
        final ImageView imageView = httpViewHolder.getHpptImageView();
        bitmap = null;
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    getImage(image.getWebformatURL());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();


        while (bitmap == null){}
        imageView.setImageBitmap(bitmap);
        httpViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(httpViewHolder.itemView.getContext(), "HttpConnection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getType() {
        return type;
    }

    public static void getImage(String urlString) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if(responseCode == 200) {
                bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (connection!=null) {
                connection.disconnect();
            }
        }
    }
}
