package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.HashUtils
import com.martinb.marvelapp.data.remote.MarvelApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainPresenter(private val marvelApiService: MarvelApiService) : BasePresenter<MainView>(), PresenterContract.PresenterMain {


    override fun getCharacterInfo() {
        compositeDisposable.add(
                marvelApiService.getData(timestamp, BuildConfig.APIKEY, hash).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { result ->
                            mvpView?.charactersInfo(result)
                        })

    }

    override fun getCharacterFilteredInfo(input: String) {
        compositeDisposable.add(
                marvelApiService.getDataFiltered(timestamp,BuildConfig.APIKEY,hash,input)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{ result -> mvpView?.filteredCharactersInfo(result)
                        }
        )
   }


}
