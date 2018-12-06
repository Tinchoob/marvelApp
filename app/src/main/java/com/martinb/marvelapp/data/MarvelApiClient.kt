package com.martinb.marvelapp.data

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.remote.MarvelApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MarvelApiClient{

    companion object {
        fun create(): MarvelApiService {

            val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                    .build()

            val retrofit by lazy {
                Retrofit.Builder()
                        .baseUrl(BuildConfig.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .client(okHttpClient)
                        .build()
            }
            return retrofit.create(MarvelApiService::class.java)
        }
    }
}