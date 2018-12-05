package com.martinb.marvelapp.data;


import android.content.Context;

import com.martinb.marvelapp.BuildConfig;
import com.martinb.marvelapp.data.model.Character;

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

    public static MarvelApiClient getInstance(Context context){
        if(instance == null){
            instance = new MarvelApiClient(context);
        }
        return instance;
    }

    private MarvelApiClient(Context context){
        this.context = context;
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

       service = retrofit.create(MarvelApiService.class);
    }

    public Call<Character> getData(){
        String hash = md5(String.format("%s%s%s","1",BuildConfig.SECRET,BuildConfig.APIKEY));
        return service.getData("1",BuildConfig.APIKEY,hash);
    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

}
