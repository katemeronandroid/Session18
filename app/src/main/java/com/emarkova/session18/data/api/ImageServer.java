package com.emarkova.session18.data.api;
import com.emarkova.session18.data.model.ImageList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ImageServer {
    @GET("api/")
    Call<ImageList> getListOfImage(@Query("key") String key, @Query("q") String query, @Query("per_page") int perPage);
}
