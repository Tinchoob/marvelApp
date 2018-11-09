package com.martinb.marvelapp.data;

import com.martinb.marvelapp.data.model.Character;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApiService {

    @GET("/v1/public/characters")
    Call<Character> getData(@Query("ts") String timeStamp,@Query("apikey") String API_KEY,@Query("hash") String Hash);

}
