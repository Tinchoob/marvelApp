package com.martinb.marvelapp.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.remote.MarvelApiService
import com.martinb.marvelapp.ui.comics.ComicsFragmentPresenter
import com.martinb.marvelapp.ui.MainPresenter
import okhttp3.OkHttpClient
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val marvelAppModule = module(override=true) {
    single { MainPresenter(get()) }
    single { createService() }
    single { ComicsFragmentPresenter(get()) }
}


fun createService(): MarvelApiService {

    val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .build()

    val retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(okHttpClient)
                .build()
    }
    return retrofit.create(MarvelApiService::class.java)
}

