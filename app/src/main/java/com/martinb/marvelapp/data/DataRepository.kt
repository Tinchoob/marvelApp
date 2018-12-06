package com.martinb.marvelapp.data

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.model.HashUtils.md5
import com.martinb.marvelapp.data.remote.MarvelApiService
import com.martinb.marvelapp.data.remote.RemoteDataListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class DataRepository(private val service: MarvelApiService, private val listener: RemoteDataListener ){

    var disposable: Disposable? = null
    val hash = md5(String.format("%s%s%s", "1", BuildConfig.SECRET, BuildConfig.APIKEY))

    fun getData() {
        disposable =
        service.getData("1",BuildConfig.APIKEY,hash).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result -> listener.charactersInfo(result) }
    }


}