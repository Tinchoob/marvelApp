package com.martinb.marvelapp.ui

import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.data.HashUtils
import com.martinb.marvelapp.data.remote.MarvelApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainPresenter : BasePresenter<PresenterContract.MainView>(), PresenterContract.PresenterMain {

    private val marvelApiClient = MarvelApiClient.create()
    private val hash = HashUtils.md5(String.format("%s%s%s", "1", BuildConfig.SECRET, BuildConfig.APIKEY))

    override fun getCharacterInfo() {
        compositeDisposable.add(
                marvelApiClient.getData("1", BuildConfig.APIKEY, hash).subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe { result ->
                            mvpView?.charactersInfo(result)
                        })

    }

    override fun getCharacterFilteredInfo(input: String) {
        compositeDisposable.add(
                marvelApiClient.getDataFiltered("1",BuildConfig.APIKEY,hash,input)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe{ result -> mvpView?.filteredCharactersInfo(result)
                        }
        )
   }


}
