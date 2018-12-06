package com.martinb.marvelapp.data;


import android.content.Context;

import com.martinb.marvelapp.BuildConfig;
import com.martinb.marvelapp.data.model.Character;
import com.martinb.marvelapp.data.remote.MarvelApiService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelApiClient {

    private static MarvelApiClient instance;
    private Context context;
    private MarvelApiService service;
    private String hash;

    public static MarvelApiClient getInstance(Context context){
        if(instance == null){
            instance = new MarvelApiClient(context);
        }
        return instance;
    }

    private MarvelApiClient(Context context){
        this.context = context;
      //  this.hash = md5(String.format("%s%s%s","1",BuildConfig.SECRET,BuildConfig.APIKEY));
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

       service = retrofit.create(MarvelApiService.class);
    }



}
