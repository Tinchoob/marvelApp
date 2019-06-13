package com.martinb.marvelapp.data.remote;

import com.martinb.marvelapp.data.model.Character;
import com.martinb.marvelapp.data.model.ComicsResults;

import kotlinx.coroutines.Deferred;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MarvelApiService {

    @GET("/v1/public/characters")
    Deferred<Character> getData(@Query("ts") String timeStamp, @Query("apikey") String API_KEY, @Query("hash") String Hash);

    @GET("/v1/public/characters")
    Deferred<Character> getDataFiltered(@Query("ts") String timeStamp,
                                          @Query("apikey") String API_KEY, @Query("hash") String Hash,
                                          @Query("nameStartsWith") String input);

    @GET("/v1/public/comics")
    Deferred<ComicsResults> getComicsData(@Query("ts") String timeStamp,
                                            @Query("apikey") String API_KEY, @Query("hash") String Hash,
                                            @Query("characters") String characterId);

}
