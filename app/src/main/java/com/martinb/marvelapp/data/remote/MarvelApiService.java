package com.martinb.marvelapp.data.remote;

import com.martinb.marvelapp.data.model.Character;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApiService {

    @GET("/v1/public/characters")
    Observable<Character> getData(@Query("ts") String timeStamp, @Query("apikey") String API_KEY, @Query("hash") String Hash);

    @GET("/v1/public/characters")
    Observable<Character> getDataFiltered(@Query("ts") String timeStamp,
                                          @Query("apikey") String API_KEY, @Query("hash") String Hash,
                                          @Query("nameStartsWith") String input);


}
